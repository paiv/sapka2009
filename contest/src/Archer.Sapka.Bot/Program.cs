using System;
using Archer.Sapka.Client;

namespace Archer.Sapka.Bot
{
	internal class Program
	{
		private static void Main(string[] args)
		{
			if(args.Length < 3)
			{
				Console.WriteLine("usage: bot <luascript> <host> <port>");
				return;
			}

			var luai = args[0];
			var host = args[1];
			var port = int.Parse(args[2]);

			SapkaVisualizerConsole viz = null;
			var sapka = new SapkaClient();

			using(var bot = new BotAI(sapka))
			{
				if(!bot.Load(luai))
				{
					Console.WriteLine(".terminated");
					return;
				}
				if(bot.NeedsVisualizer)
					viz = new SapkaVisualizerConsole(sapka.PacketDispatcher);

				sapka.Observe(host, port);
				bot.Activate();

				Console.WriteLine("Press ENTER to terminate.");
				Console.ReadLine();
			}
		}
	}
}
