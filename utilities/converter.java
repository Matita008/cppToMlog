package utilities;
import java.util.*;

public class converter {
	public static final char[] toPrimitive(Character[] refArray){
		char[] charArray = new char[refArray.length];
		for (int i = 0; i < refArray.length; i++) {
			charArray[i] = refArray[i];
		}
		return charArray;
	}
	public static final char[] toCharPrimitive(Character[] data) {
		char[] end = new char[data.length];
		for (int i = 0; i < data.length; i++) {
			end[i] = data[i];
		}
		return end;
	}
	public static final char[][] toCharPrimitive(Character[][] data) {
		char[][] end = new char[data.length][data.length];
		for (int i = 0; i < data.length; i++) {
			end[i] = toCharPrimitive(data[i]);
		}
		return end;
	}
	
	/*public static final char[] toCharPrimitive(Object[] data) {
		return toCharPrimitive(data);
	}
	public static final char[][] toCharPrimitive(Object[][] data) {
		return toCharPrimitive(data);
	}*/
	/*public static final char[][] toChar(String[] data)  {
		char[][] end = new char[data.length][data.length];
		for(int i = 0; i < data.length; i++)   end[i] = data[i].toCharArray();
		return end;
	}
	public static final char[][] toChar(Object[] data)  {
		return toChar(data);
	}*/
	public static final char[][] toChar(ArrayList<String> data)  {
		char[][] end = new char[data.size()][data.size()];
		for(int i = 0; i < data.size(); i++)   end[i] = data.get(i).toCharArray();
		return end;
	}
}
