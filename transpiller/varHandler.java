package transpiller;

import java.util.*;

public class varHandler {
	private static ArrayList<String> name = new ArrayList<String>();
	public static HashMap<Integer, ArrayList<Integer>> child = new HashMap<Integer, ArrayList<Integer>>();
	public static HashMap<Integer, ArrayList<Integer>> parent = new HashMap<Integer, ArrayList<Integer>>();
	private static int curScope = 0;
	private static int maxScope = 0;

	private static int getType(String Type) {
		switch (Type.toLowerCase()) {
		default:
			return -1;
		case "var":
		case "":
			return 0;
		case "string":
			return 1;
		case "bool":
		case "boolean":
			return 2;
		case "obj":
		case "object":
			return 3;
		case "int":
			return 4;
		case "short":
			return 5;
		case "long":
			return 6;
		}
	}

	private static Boolean isValideType(String type) {
		if (getType(type) == -1)
			return false;
		else if (getType(type) == getType("array"))
			System.out.println("Array aren't fully supported");
		// TODO Plz implement me ;)
		return true;
	}

	public static int getScope(String name) {
		return name.substring(name.indexOf("_"), name.indexOf("_", name.indexOf("_") + 1));
	}
	// TODO Fix this

	public static void newScope() {
		ArrayList<Integer> c = new ArrayList<Integer>(child.get(curScope));
		c.add(curScope);
		child.replace(curScope, child.get(curScope), c);
		ArrayList<Integer> p = new ArrayList<Integer>(parent.get(curScope));
		p.add(curScope);
		parent.put(curScope, p);
		maxScope++;
		curScope = maxScope;
	}

	public static void closeScope() {
		curScope = parent.get(curScope).get(parent.get(curScope).size() - 1);
	}

	public static String getName(String name, int Scope, String Type) {
		if (!isValideType(Type) || Scope > maxScope || name.replace(" ", "") == "" || name.contains("_"))
			throw new RuntimeException("an error occurred");// TODO
		return name.replace(" ", "") + (curScope == 0 ? "" : "_" + Scope)
				+ (Type == "" || Type == null ? "" : "_" + Type);
	}

	public static boolean addVar(String name) {
		return addVar(name, curScope, "Var");
	}

	public static boolean addVar(String name, String Type) {
		return addVar(name, curScope, Type);
	}

	public static boolean addVar(String name, int Scope, String Type) {
		if (!isValideType(Type) || Scope > maxScope)
			return false;
		name.add();
		return true;
	}

	public static boolean exist(String name) {
		return exist(name, curScope, "var");
	}

	public static boolean exist(String name, String Type) {
		return exist(name, curScope, Type);
	}

	public static boolean exist(String name, int Scope, String Type) {
		return !isValideType(Type) || Scope > maxScope || false;
	}
}