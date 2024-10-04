package utilities.Json;

public class JString extends JVar implements JData {

	private String d;

	public JString(String s) {
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

	public String getUnmod () { return this.d; }

	public String get () {
		return this.d;
	}

	public String getJson () { return '"' + this.d + '"'; }

}
