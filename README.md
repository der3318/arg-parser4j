## Java Arguments Parser (arg-parser4j)
#### Prerequisite
* Java SE - 1.7


#### API
* Constructor - `new ArgParser()`
* Method - `add(_param, _isFlag)`
    * Specify whether the parmter is a flag
    * If it is not a flag, a following String is expected
* Method - `parse(_args)`
    * Parse the the array of String
* Method - `getParserDict()`
    * Retrun a Map, both key and value are String
    * Keyset is the subset of the parameters added
    * If the arguments does not include the parameter, the map won't contain the key related to the parameter
* Method - `getParams()`
    * Return a List with String elements
    * Collect the paramters having nothing to do with API-add
    * The order will not be changed


#### Demo
```java=
// test case no.1
String[] testArgs1 = new String[] 
    {"--epoch", "10", "--dir", "data/", "-d", "input.csv", "output.csv"};
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

// test case no.2
String[] testArgs2 = new String[]
    {"input.csv", "--dir", "data/", "-d", "output.csv"};
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
```


#### Usage
* Add `arg-parser4j.jar` into classpath
* Import `com.der3318.ArgParser`

