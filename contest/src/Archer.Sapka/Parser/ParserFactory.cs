using System;
using System.IO;
using System.Reflection;
using GoldParser;
using GParser = GoldParser.Parser;

namespace Archer.Sapka.Parser
{
	// this class will construct a parser without having to process
	//  the CGT tables with each creation.  It must be initialized
	//  before you can call CreateParser()
	public sealed class ParserFactory
	{
		static Grammar m_grammar;
		static bool _init;

		private ParserFactory()
		{
		}

		private static BinaryReader GetResourceReader(string resourceName)
		{
			Assembly assembly = Assembly.GetExecutingAssembly();
			Stream stream = assembly.GetManifestResourceStream(resourceName);
			return new BinaryReader(stream);
		}

		public static void InitializeFactoryFromFile(string FullCGTFilePath)
		{
			if(!_init)
			{
				BinaryReader reader = new BinaryReader(new FileStream(FullCGTFilePath, FileMode.Open));
				m_grammar = new Grammar(reader);
				_init = true;
			}
		}

		public static void InitializeFactoryFromResource(string resourceName)
		{
			if(!_init)
			{
				BinaryReader reader = GetResourceReader(resourceName);
				m_grammar = new Grammar(reader);
				_init = true;
			}
		}

		public static GParser CreateParser(TextReader reader)
		{
			if(_init)
			{
				return new GParser(reader, m_grammar);
			}
			throw new Exception("You must first Initialize the Factory before creating a parser!");
		}
	}
}
