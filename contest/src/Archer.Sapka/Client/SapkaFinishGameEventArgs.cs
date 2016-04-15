using System;
using Archer.Sapka.Parser.Ast;

namespace Archer.Sapka.Client
{
	public class SapkaFinishGameEventArgs : EventArgs
	{
		public SapkaFinishGameEventArgs(RankScoreNode score)
		{
			Score = score;
		}

		public RankScoreNode Score { get; private set; }
	}
}
