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

	abstract String getJson ();

	public static JData scan (String d) {
		if (d.startsWith("{")) return new JMap(d);
		else if (d.startsWith("[")) return new JArr(d);
		else return JVar.scan(d);
	}
}
