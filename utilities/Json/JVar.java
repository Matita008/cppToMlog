package utilities.Json;

public abstract class JVar implements JData {
	public static JData scan (String d) {
		if (JData.removeSpaces(d).startsWith("\"")) return new JString(d);
		throw new RuntimeException();
	}
}
