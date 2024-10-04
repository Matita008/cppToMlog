/**
 * 
 */
package utilities.Json;

import java.util.HashMap;

/**
 * 
 */
public class JMap implements JData {
	private HashMap <String, JData> map = new HashMap <>();

	public JMap(String s) {
		// TODO Auto-generated method stub
	}

	public JData get (String key) {
		return this.map.get(key);
	}

	@Override
	public String getJson () {
		StringBuilder b = new StringBuilder();
		b.append('{');
		for (String s : map) {
			b.append(s);
			b.append(", ");
			b.append(map.get(s).getJson());
		}
		b.append('}');
		return b.toString();
	}
}
