using System;
using System.Net.Sockets;
using System.Text;

namespace Archer.Sapka.Client
{
	/// <summary>
	/// TCP client to Sapka server.
	/// </summary>
	public class SapkaClient : TcpClient
	{
		private readonly PacketDispatcher _dispatcher;
		private readonly SapkaReader _reader;

		public SapkaClient()
		{
			_dispatcher = new PacketDispatcher(this);
			_reader = new SapkaReader();
			_reader.PacketReceived += new EventHandler<SapkaPacketEventArgs>(Reader_PacketReceived);
			_reader.ServerMessage += new EventHandler<ServerMessageEventArgs>(Reader_ServerMessage);
		}

		public PacketDispatcher PacketDispatcher { get { return _dispatcher; } }

		/// <summary>
		/// For local testing purposes - read server messages from trace file.
		/// </summary>
		/// <param name="fileName"></param>
		public void ReadFile(string fileName)
		{
			_reader.Read(fileName);
		}

		public void Observe(string host, int port)
		{
			Connect(host, port);
			_reader.Read(GetStream());
		}

		public void LogTo(string fileName)
		{
			_reader.LogTo(fileName);
		}

		public void Write(byte[] data, int offset, int count)
		{
			GetStream().Write(data, offset, count);
		}

		public void Write(string format, params object[] args)
		{
			if(string.IsNullOrEmpty(format))
				return;
			var value = string.Format(format, args);
			var data = Encoding.UTF8.GetBytes(value);
			Write(data, 0, data.Length);
		}

		private void Reader_PacketReceived(object sender, SapkaPacketEventArgs e)
		{
			_dispatcher.Process(e.Packet);
		}

		private void Reader_ServerMessage(object sender, ServerMessageEventArgs e)
		{
			_dispatcher.Process(e.Message);
		}
	}
}
