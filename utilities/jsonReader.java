package utilities;

import java.util.*;
//import java.io.*;

public final class jsonReader {
	@SuppressWarnings ("unused")
	private HashMap <String, jData> content = new HashMap <>(); // TODO why?

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
	String unused;

	default String unused () {
		return unused;
	}

	public static jData scan (String d) {
		if (d.startsWith("{")) return new jMap(d);
		throw new RuntimeException();
	}
}

final class jMap implements jData {
	private HashMap <String, jData> d = new HashMap <>();

	public jMap (String s) {
		// TODO Auto-generated method stub
	}

	public jData get (String key) {
		return this.d.get(key);
	}
}

final class jArr implements jData {
	public jArr (String s) {
		// TODO Auto-generated method stub
	}
}

abstract class jVar implements jData {}

final class jString extends jVar {
	private String d;

	public jString (String s) {
		this.d = "q";
	}

	public String get () {
		return this.d;
	}
}

final class jNum extends jVar {

}
