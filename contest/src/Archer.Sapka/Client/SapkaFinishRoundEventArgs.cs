using System;

namespace Archer.Sapka.Client
{
	public class SapkaFinishRoundEventArgs : EventArgs
	{
		public SapkaFinishRoundEventArgs(int score)
		{
			Score = score;
		}

		public int Score { get; private set; }
	}
}
