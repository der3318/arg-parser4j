package test;

import com.der3318.ArgParser;

public class Test {

	public static void main(String[] args) {
		ArgParser parser = new ArgParser();
		parser.add("--dir", false);
		parser.add("--epoch", false);
		parser.add("--delete", true);
		parser.add("-d", true);
		parser.parse(args);
		System.out.println( parser.getParserDict() );
		System.out.println( parser.getParams() );
	}
	
}
