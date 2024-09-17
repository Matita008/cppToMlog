package utilities;

import java.util.*;

public final class jsonReader {
	@SuppressWarnings ("unused")
	private HashMap <String, jData> content = new HashMap <>();

}

interface jData {
	// Object get ();
	void load (String s);

	 default String readText (String s) {
		boolean skip = false;
		String r = "";
		for (char c : s.toCharArray()) {
			if (skip) {
				skip = false;
				r = switch (c) {
					default -> "\\" + c;
					case '"' -> "\"";
					case 'n' -> "\n";
					case 't' -> "\t";
					case '\\' -> "\\";
					case 'b' -> "\b";
					case 'f' -> "\f";
					case 'r' -> "\r";
				};
				continue;
			}
			if (c == '\\') {
				skip = true;
			} else if (c == '"') {
				break;
			}
			r = r + c;
		}
		return r;
	}
}

final class jMap implements jData {

	@Override
	public void load (String s) {
		// TODO Auto-generated method stub

	}

}

final class jArr implements jData {

	@Override
	public void load (String s) {
		// TODO Auto-generated method stub

	}

}

abstract class jVar implements jData {

}

final class jString extends jVar {

	@Override
	public String readText (String s) {
		String p=super(s);
	}

	@Override
	public void load (String s) {
		// TODO Auto-generated method stub
		
	}
}

final class jNum extends jVar {

	@Override
	public void load (String s) {
		// TODO Auto-generated method stub

	}
}
