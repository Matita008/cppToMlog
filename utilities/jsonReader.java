package utilities;

import java.util.*;
//import java.io.*;

public final class jsonReader {
	@SuppressWarnings ("unused")
	private HashMap <String, jData> content = new HashMap <>();

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
	/**
	 * @param s the string to elaborate (it will trash code after all the
	 *          parenthesis are closed)
	 */

	Object get ();
	jData load();
}

final class jMap implements jData {

	public static jData load (String s) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public jData get () {
		// TODO Auto-generated method stub
		return null;
	}

}

final class jArr implements jData {
	@Override
	public static jData load (String s) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public jData get () {
		// TODO Auto-generated method stub
		return null;
	}

}

abstract class jVar implements jData {
	@Override
	public static jData load (String s) {
		return jNum.load(s);
	}
}

final class jString extends jVar {
	@Override
	public static jData load (String s) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public jData get () {
		// TODO Auto-generated method stub
		return null;
	}

}

final class jNum extends jVar {

	@Override
	public static jData load (String s) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public jData get () {
		// TODO Auto-generated method stub
		return null;
	}

}
