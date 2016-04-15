using System;
using System.IO;
using System.Text;
using Archer.Sapka.Parser;
using Archer.Sapka.Parser.Ast;

namespace Archer.Sapka.Client
{
	public class SapkaReader
	{
		private const int READ_CHUNK_SIZE = 200;
		private readonly SapkaParser _parser;
		private string _logfile;
		private bool _isingame;

		#region ReadBaton private class

		private class ReadBaton
		{
			public Stream Input;
			public byte[] Buf;
			public Stream Output;
		}

		#endregion

		public SapkaReader()
		{
			_parser = new SapkaParser();
		}

		#region Events

		public event EventHandler<SapkaPacketEventArgs> PacketReceived;
		public event EventHandler<ServerMessageEventArgs> ServerMessage;

		#region event helpers

		private void OnPacketReceived(SapkaInfoNode packet)
		{
			if(PacketReceived != null)
				PacketReceived(this, new SapkaPacketEventArgs(packet));
		}

		private void OnServerMessage(string message)
		{
			if(ServerMessage != null)
				ServerMessage(this, new ServerMessageEventArgs(message));
		}

		#endregion

		#endregion

		public void Read(string fileName)
		{
			using(var fs = File.OpenRead(fileName))
				Read(new BufferedStream(fs));
		}

		public void LogTo(string fileName)
		{
			_logfile = fileName;
		}

		public void Read(Stream stream)
		{
			if(stream == null)
				throw new ArgumentNullException("stream");

			var baton = new ReadBaton();
			baton.Buf = new byte[READ_CHUNK_SIZE];
			baton.Input = stream;
			stream.BeginRead(baton.Buf, 0, baton.Buf.Length, OnStreamRead, baton);
		}

		private void OnStreamRead(IAsyncResult result)
		{
			var baton = (ReadBaton)result.AsyncState;
			bool eos = false;
			try
			{
				int n = baton.Input.EndRead(result);

				// split input stream into packets

				if(n <= 0)
				{
					eos = true;
					return;
				}
				WriteLog(baton.Buf, 0, n);

				int pos = 0;

				if(!_isingame)
				{
					// until game starts pass server messages as-is
					var s = Encoding.ASCII.GetString(baton.Buf, 0, n);
					var x = s.IndexOf("PID");
					if(x < 0)
					{
						// HACK: for the buggy server 1.4
						// if the bot starts second
						// consider its ID = 1, what else can we do...
						x = s.IndexOf("START");
						if(x >= 0)
						{
							if(x > 0)
								s = s.Substring(x);
							s = "PID1&10\r\n.\r\n;" + s;
							x = 0;
						}
						else
						{
							OnServerMessage(s);
							return;
						}
					}
					if(x > 0)
					{
						OnServerMessage(s.Substring(0, x));
						pos = x;
					}
					_isingame = true;
				}

				for(int i = pos; i < n; )
				{
					bool msg = false;
					for(; i < n; )
					{
						if(baton.Buf[i++] == ';')
						{
							msg = true;
							break;
						}
					}

					if(baton.Output == null)
						baton.Output = new MemoryStream();
					baton.Output.Write(baton.Buf, pos, i - pos);
					if(msg)
					{
						baton.Output.Position = 0;
						using(var rr = new StreamReader(baton.Output))
							FeedParser(rr);
						baton.Output.Dispose();
						baton.Output = null;
					}

					pos = i;
				}
			}
			catch(Exception ex)
			{
				Console.WriteLine("! {0}", ex);
			}
			finally
			{
				if(!eos)
					baton.Input.BeginRead(baton.Buf, 0, baton.Buf.Length, OnStreamRead, baton);
			}
		}

		private void WriteLog(byte[] buf, int offset, int count)
		{
			if(string.IsNullOrEmpty(_logfile))
				return;
			using(var fs = File.Open(_logfile, FileMode.Append, FileAccess.Write, FileShare.Read))
			{
				fs.Write(buf, offset, count);
			}
		}

		private void FeedParser(TextReader stream)
		{
			if(!_parser.Parse(stream))
			{
				Console.WriteLine("! {0} (at {1} char in \"{2}\")",
					_parser.ErrorString, _parser.LinePosition, _parser.ErrorLine);
				return;
			}

			var msg = (SapkaDataNode)_parser.SyntaxTree;
			foreach(var info in msg)
				OnPacketReceived(info);
		}

	}
}
