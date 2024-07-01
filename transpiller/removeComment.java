package transpiller;

import java.io.*;
import java.util.*;

public class removeComment {
	public static void MultiLane(File in, FileWriter out, String start, String end) throws IOException {
		Scanner read = new Scanner(in);
		while (read.hasNextLine()) {
			String line = read.nextLine();
			if (line.contains(start)) {
				out.write(line.codePointBefore(line.indexOf(start)) + "\n");
				while (!line.contains(end)) {
					line = read.nextLine();
				}
				out.write((String) line.subSequence(line.indexOf(end) + end.length(), line.length()) + "\n");
			} else
				out.write(line + "\n");
		}
		read.close();
		out.close();
	}

	public static void SingleLane(File in, FileWriter out, String prefix) throws IOException {
		Scanner read = new Scanner(in);
		while (read.hasNextLine()) {
			String line = read.nextLine();
			if (line.contains(prefix))
				out.write(line.codePointBefore(line.indexOf(prefix)) + "\n");
			else
				out.write(line + "\n");
		}
		read.close();
		out.close();
	}

	public static void MultiLane(File in, FileWriter out) throws Exception {
		MultiLane(in, out, "/*", "*/");
	}

	public static void SingleLane(File in, FileWriter out) throws Exception {
		SingleLane(in, out, "//");
	}
}