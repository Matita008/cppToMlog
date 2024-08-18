/**
 * 
 */
package transpiller;

import java.util.*;

/**
 * 
 */
public final class formatter {
	public static String toLine (String[] s) {
		StringJoiner j = new StringJoiner("");
		Arrays.stream(s).forEachOrdered(st -> j.add(st));
		return j.toString();
	}

	public static String[] putLine (String s) {
		return s.split(";");
	}
}
