package transpiller;

import java.io.*;
import java.util.*;

//TODO redo it all to work with string arrays and why i've used //TODO NO.???

public class removeComment {
	/*
	 * public static void main (String[] args) throws Exception {
	 * @SuppressWarnings ("unused") File a = new File("String.java");
	 * @SuppressWarnings ("unused") File b = new
	 * File("C:\\Users\\matti\\Documents\\GitHub\\cppToMlog\\transpiller\\f.n");
	 * MultiLane(b, new FileWriter("String.java")); }
	 */

	public static String[] MultiLane (String[] st, String start, String end) {
		StringBuilder out = new StringBuilder();
		boolean in = false;
		for (String line : st) {
			int s = 0;
			if (line.contains(start) && !in) {
				s = line.indexOf(start);
				in = true;
			}
			if (in) {
				if (s != 0 || line.contains(end)) out.append(line.substring(s, line.indexOf(end) != -1 ? line.indexOf(end) : line.length()+
						) + "\n");
				if (line.contains(end)) in = false;
				continue;
			}
			out.append(line + "\n");
		}
		return out.toString().split("\n");

	}

	public static String[] SingleLane (String[] st, String prefix) {
		StringBuilder out = new StringBuilder();
		for (String line : st) {
			if (line.contains(prefix)) out.append(line.substring(line.indexOf(prefix)) + "\n");
			else out.append(line + "\n");
		}
		return out.toString().split("\n");
	}
	/*
	 * public static String[] SingleLane (String[] st, String prefix, boolean keep)
	 * { List <String> out; for (String line : st) { if (line.contains(prefix))
	 * out.add(line.substring(0, line.indexOf(prefix)) + (keep ?
	 * line.substring(line.indexOf(prefix)) : "")); else out.add(line + ""); }
	 * return (String[]) out.toArray(); }
	 */// TODO

	public static void MultiLane (String[] st) throws Exception {
		MultiLane(st, "/*", "*/");
	}

	public static void SingleLane (String[] st) throws Exception {
		SingleLane(st, "//");
	}
}
