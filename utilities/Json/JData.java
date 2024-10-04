/**
 * 
 */
package utilities.Json;

/**
 * 
 */
public interface JData {
	String unused = null;

	default String unused () {
		return unused;
	}

	abstract Object get ();
	abstract String getJson ();

	public static JData scan (String d) {
		if (d.startsWith("{")) return new JMap(d);
		else if (d.startsWith("[")) return new JArr(d);
		else return JVar.scan(d);
	}

	static String removeSpaces (String d) {
		return d.replace(' ', "".toCharArray()[0]).replace('\t', "".toCharArray()[0]);
	}
}
