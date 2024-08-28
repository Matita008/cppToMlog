package transpiller;

public class removeComment {
	/*
	 * public static void main (String[] args) throws Exception {
	 * @SuppressWarnings ("unused") File a = new File("String.java");
	 * @SuppressWarnings ("unused") File b = new
	 * File("C:\\Users\\matti\\Documents\\GitHub\\cppToMlog\\transpiller\\f.n");
	 * MultiLane(b, new FileWriter("String.java")); }
	 */

	public static String MultiLane0 (String[] st, String start, String end) {
		StringBuilder out = new StringBuilder();
		boolean in = false;
		for (String line : st) {
			int s = 0;
			if (line.contains(start) && !in) {
				s = line.indexOf(start);
				in = true;
			}
			if (in) {
				if (s != 0 || line.contains(end)) out.append(line.substring(s, line.indexOf(end) != -1 ? line.indexOf(end) : line.length()) + "\n");
				if (line.contains(end)) in = false;
				continue;
			}
			out.append(line + "\n");
		}
		return out.toString();

	}

	public static String SingleLane0 (String[] st, String prefix) {
		StringBuilder out = new StringBuilder();
		for (String line : st) {
			if (line.contains(prefix)) out.append(line.substring(line.indexOf(prefix)) + "\n");
			else out.append(line + "\n");
		}
		return out.toString();
	}

	public static String[] MultiLane (String[] st, String start, String end) {
		return MultiLane0(st, start, end).split("\n");
	}

	public static String[] MultiLane (String[] st) {
		return MultiLane0(st, "/*", "*/").split("\n");
	}

	public static String MultiLane0 (String[] st) {
		return MultiLane0(st, "/*", "*/");
	}

	public static String[] SingleLane (String[] st, String prefix) {
		return SingleLane0(st, prefix).split("\n");
	}

	public static String[] SingleLane (String[] st) {
		return SingleLane0(st, "//").split("\n");
	}

	public static String SingleLane0 (String[] st) {
		return SingleLane0(st, "//");
	}
}
