import com.der3318.ArgParser;

public class Demo {
	
	public static void main(String[] args) {
		// test case 1
		String[] testArgs1 = new String[] {"--epoch", "10", "--dir", "data/", "-d", "input.csv", "output.csv"};
		ArgParser parser1 = new ArgParser();
		parser1.add("--dir", false);
		parser1.add("--epoch", false);
		parser1.add("--delete", true);
		parser1.add("-d", true);
		parser1.parse(testArgs1);
		System.out.println( parser1.getParserDict() );
		// Map - {"-d" = "", "--dir" = "data/", "--epoch" = "10"}
		System.out.println( parser1.getParams() );
		// List - ["input.csv", "output.csv"]
		
		// test case 2
		String[] testArgs2 = new String[] {"input.csv", "--dir", "data/", "-d", "output.csv"};
		ArgParser parser2 = new ArgParser();
		parser2.add("--dir", false);
		parser2.add("--epoch", false);
		parser2.add("--help", true);
		parser2.add("-h", true);
		parser2.parse(testArgs2);
		System.out.println( parser2.getParserDict() );
		// Map - {"--dir" = "data/"}
		System.out.println( parser2.getParams() );
		// List - ["input.csv", "-d", "output.csv"]
	}
	
}
