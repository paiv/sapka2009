using System;
using System.IO;
using Archer.Sapka.Client;

namespace Archer.Sapka.Visualizer
{
	class Program
	{
		static void Main(string[] args)
		{
			if(args.Length < 1)
			{
				Console.WriteLine("usage: sapkaviz <filename>\n" +
					"   or: sapkaviz <bindhost> <bindport>");
				return;
			}

			var fileName = args[0];
			string host = null;
			int port = 0;

			if(!File.Exists(fileName))
			{
				if(args.Length < 2)
				{
					Console.WriteLine("! file not found: {0}", fileName);
					return;
				}
				fileName = null;
				host = args[0];
				port = int.Parse(args[1]);
			}

			var sapka = new SapkaClient();
			var viz = new SapkaVisualizerConsole(sapka.PacketDispatcher);

			if(fileName != null)
			{
				//viz.StepDelay = 10;
				sapka.ReadFile(fileName);
				return;
			}

			//sapka.LogTo("viz.log");
			sapka.Observe(host, port);

			Console.WriteLine("Visualizer is listening on {0}:{1}", host, port);
			Console.WriteLine("Press ENTER to terminate.");
			Console.ReadLine();
			Console.WriteLine("Terminated.");
		}
	}
}
