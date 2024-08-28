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

	public static void MultiLane (File in, FileWriter out, String start, String end) throws IOException {
		Scanner read = new Scanner(in);
		while (read.hasNextLine()) {
			String line = read.nextLine();
			if (line.contains(start)) {
				line = line + 1;
				out.write(line.//TODO NO.(line.indexOf(start) <= 1 || line.indexOf(start) + 1 >= line.length() ? 2 : line.indexOf(start) + 1) + "\n");
				while (!line.contains(end)) {
					line = read.nextLine();
				}
				out.write((String) line.subSequence(line.indexOf(end) + end.length(), line.length()) + "\n");
			} else out.write(line + "\n");
		}
		read.close();
		out.close();
	}

	public static void SingleLane (File in, FileWriter out, String prefix) throws IOException {
		Scanner read = new Scanner(in);
		while (read.hasNextLine()) {
			String line = read.nextLine();
			if (line.contains(prefix)) out.write(line.codePointBefore(line.indexOf(prefix)) + "\n");
			else out.write(line + "\n");
		}
		read.close();
		out.close();
	}

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

	public static void MultiLane (File in, FileWriter out) throws Exception {
		MultiLane(in, out, "/*", "*/");
	}

	public static void SingleLane (File in, FileWriter out) throws Exception {
		SingleLane(in, out, "//");
	}
}
