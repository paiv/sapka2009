using System;
using System.Text;

namespace Archer.Sapka
{
	internal class Program
	{
		[STAThread]
		private static void Main(string[] args)
		{
			if(args.Length < 3)
			{
				Console.WriteLine("usage: token <teamname> CFG|DMA <tokenid>\n" +
					"example: token foo DMA jnonSXard7wSSPDLesnc");
				return;
			}

			var team = args[0];
			var type = args[1];
			var toki = args[2];

			var token = MakeToken(type.ToUpper(), toki, team);
			Console.WriteLine(token);
		}

		private static string MakeToken(string type, string tokenId, string team)
		{
			if(team.Length > 80)
				team = team.Substring(0, 80);
			if(team.Length < 80)
			{
				StringBuilder so = new StringBuilder(team);
				for(int i = 1; so.Length < 80; )
				{
					so.Append(i);
					i += 2;
					if(i > 8)
						i -= 8;
				}
				team = so.ToString();
			}

			byte[] s1 = Encoding.UTF8.GetBytes(team);
			byte[] s = Encoding.UTF8.GetBytes(tokenId);
			char[] ac = new char[20];
			int j = 8726;
			for(int k = 0; k < 20; k++)
			{
				int l = s1[k] * s1[k + 20] * j + s1[k + 40] * s1[k + 60];
				j = (j | l) << 4 ^ (l | s[k] + k);
				ac[k] = (char)(64 + (j >= 0 ? j : -j) % 58);
				for(int i1 = 0; ac[k] >= '[' && ac[k] <= '`' || ac[k] < '@' || ac[k] > 'z'; i1++)
				{
					char c = (char)(64 + (ac[k] << 3 + (k + 1) + s[k] ^ (j >= 0 ? j : -j) + i1) % 58);
					c = (char)(64 + (c + i1) % 58);
					ac[k] = c;
				}
			}

			return type + (new string(ac));
		}
	}
}
