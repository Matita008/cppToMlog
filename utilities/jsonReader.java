package utilities;

import java.util.*;
//import java.io.*;

public final class jsonReader {
	@SuppressWarnings ("unused")
	private HashMap <String, jData> content = new HashMap <>(); //TODO why?

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
	default String unused(){
	 	return unused;
	}
}

final class jMap implements jData {
	public jMap (String s) {
		// TODO Auto-generated method stub
	}
}

final class jArr implements jData {
	public jArr (String s) {
		// TODO Auto-generated method stub
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
