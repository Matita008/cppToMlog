package utilities;

import java.util.*;
//import java.io.*;

public final class jsonReader {
	/*
	 * @SuppressWarnings ("unused") private HashMap <String, jData> content = new
	 * HashMap <>(); // TODO why?
	 */

	/*
	 * public jsonReader(File file (String name)-> {File file = new File(name)}) {
	 * this(file); }
	 */

	/*
	 * public jsonReader(File file) throws FileNotFoundException { this.file = file;
	 * scanFile(); } private void scanFile() throws FileNotFoundException { Scanner
	 * scanner = new Scanner(file); scanFile(scanner); } private void
	 * scanFile(Scanner scanner) { }
	 */
}

interface jData {
	String unused = null;

	default String unused () {
		return unused;
	}

	abstract String getJson ();

	public static jData scan (String d) {
		if (d.startsWith("{")) return new jMap(d);
		else if (d.startsWith("[")) return new jArr(d);
		else return jVar.scan(d);
	}

	static String removeSpaces (String d) {
		return d.replace(' ', "".toCharArray()[0]).replace('\t', "".toCharArray()[0]);
	}
}

final class jMap implements jData {
	private HashMap <String, jData> d = new HashMap <>();

	public jMap(String s) {
		// TODO Auto-generated method stub
	}

	public jData get (String key) {
		return this.d.get(key);
	}

	@Override
	public String getJson () {
		StringBuilder b = new StringBuilder();
		b.append('{');
		for (String s : d) {
			b.append(s);
			b.append(", ");
			b.append(d.get(s).getJson());
		}
		b.append('}');
		return b.toString();
	}
}

final class jArr implements jData {
	public jArr(String s) {
		// TODO Auto-generated method stub
	}

	@Override
	public String getJson () { // TODO Auto-generated method stub
		return null;
	}
}

abstract class jVar implements jData {
	public static jData scan (String d) {
		if (jData.removeSpaces(d).startsWith("\"")) return new jString(d);
		throw new RuntimeException();
	}
}

final class jString extends jVar {
	private String d;

	public jString(String s) {
		if (!s.startsWith("\"") || !d.replace(' ', "".toCharArray()[0]).startsWith("\"")) throw new RuntimeException();
		int i = 0;
		boolean skip = false;
		StringBuilder b = new StringBuilder();
		while (s.charAt(i) != '"') i++;
		while (s.charAt(i) != '"' && !skip) {
			b.append(s.charAt(i));
			if (s.charAt(i) == '\\' && !skip) skip = true;
			else skip = false;
		}
		d = b.toString();
	}

	public String getUnmod () {
		return this.d;
	}

public String get () {
		return this.d;
	}

	public String getJson () { return '"' + this.d + '"'; }
}

final class jNum extends jVar {
	float n;

	public jNum(String s) {
		n = 0;
	}

	@Override
	public String getJson () { // TODO Auto-generated method stub
		return (String) n;
	}

}
