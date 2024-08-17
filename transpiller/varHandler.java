package transpiller;

import java.util.*;
import utilities.*;

public class varHandler {
	private static HashMap <Integer, ArrayList <String>> name = new HashMap <>();
	public static HashMap <Integer, ArrayList <Integer>> child = new HashMap <>();
	public static HashMap <Integer, ArrayList <Integer>> parent = new HashMap <>();
	private static int curScope = 0;
	private static int maxScope = 0;

	private static int getType (String Type) {
		return switch (Type.toLowerCase()) {
			default -> -1;
			case "var" -> 0;
			case "" -> 0;
			case "string" -> 1;
			case "bool" -> 2;
			case "boolean" -> 2;
			case "obj" -> 3;
			case "object" -> 3;
			case "int" -> 4;
			case "short" -> 5;
			case "long" -> 6;
		};
	}

	@SuppressWarnings ("unused")
	private static String getType (int n) {
		return switch (n) {
			default -> "unsupported";
			case 0 -> "var";
			case 1 -> "string";
			case 2 -> "bool";
			case 3 -> "object";
			case 4 -> "int";
			case 5 -> "short";
			case 6 -> "long";
		};
	}

	private static Boolean isValideType (String type) {
		if (getType(type) == -1) return false;
		else if (getType(type) == getType("array")) System.out.println("Array aren't fully supported");
		// TODO Plz implement me ;)
		return true;
	}

	public static int getScope (String name) {// TODO doesn't account for all possible cases
		stringManager s = new stringManager(name);
		if (s.countOcc("_") == 2) {
			String[] a = s.getSt().splitWithDelimiters("_", 3);
			if (a.length == 5) s.set(a[1]);
			else if (a[1] == "__") s.set("0");
			return s.toInt();
		}
		return -1;
	}

	public static void newScope () {
		ArrayList <Integer> c = new ArrayList <>(child.get(curScope));
		c.add(curScope);
		child.put(curScope, c);
		ArrayList <Integer> p = new ArrayList <>(parent.get(curScope));
		p.add(curScope);
		parent.put(curScope, p);
		maxScope++;
		curScope = maxScope;
	}

	public static void closeScope () {
		curScope = parent.get(curScope).get(parent.get(curScope).size() - 1);
	}

	public static Boolean testName (String n, int s, String t) {
		if (!isValideType(t) || s > maxScope || n.replace(" ", "") == "" || n.contains("_")) return false;
		return true;
	}

	private static String compType (String t) {
		return t == "var" ? "" : t;
	}

	private static String getFullName (String n, int Scope, String Type) {
		if (testName(n, Scope, Type)) throw new RuntimeException("an error occurred");// TODO add custom error message
		return n.replace(" ", "") + "_" + (curScope == 0 ? "" : Scope) + (Type == "" || Type.toLowerCase() == "var" || Type == null ? "" : "_" + Type);
	}

	public static boolean addVar (String n) {
		return addVar(n, curScope, "Var");
	}

	public static boolean addVar (String n, String t) {
		return addVar(n, curScope, t);
	}

	public static boolean addVar (String n, int s) {
		return addVar(n, s, "var");
	}

	public static boolean addVar (String n, int s, String t) {
		if (testName(n, s, t)) return false;
		ArrayList <String> a = new ArrayList <>();
		if (name.containsKey(s)) {
			a = name.get(s);
			if (a.contains(getFullName(n, s, t))) return false;
			a.removeIf(st -> st.contains(n) && st.contains(compType(t)));
		}
		a.add(getFullName(n, s, t));
		name.put(s, a);
		return true;
	}

	public static boolean exist (String n) {
		return exist(n, curScope, "var");
	}

	public static boolean exist (String n, String Type) {
		return exist(n, curScope, Type);
	}

	public static boolean exist (String n, int s, String t) {
		return !isValideType(t) || s > maxScope || name.containsKey(s) ? name.get(s).contains(getFullName(n, s, t)) : false;
	}

	@Override
	public String toString () {
		return name + "/n/tscopes: children:" + child + " parent: " + parent + " current scope selected:" + curScope + " maxium scope:" + maxScope;
	}
}
