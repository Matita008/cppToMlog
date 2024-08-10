package transpiller;

import java.util.*;
import utilities.*;

public class varHandler {
	@SuppressWarnings ("unused")
	private static HashMap <Integer, ArrayList <String>> name = new HashMap <Integer, ArrayList <String>>();
	public static HashMap <Integer, ArrayList <Integer>> child = new HashMap <Integer, ArrayList <Integer>>();
	public static HashMap <Integer, ArrayList <Integer>> parent = new HashMap <Integer, ArrayList <Integer>>();
	private static int curScope = 0;
	private static int maxScope = 0;

	private static int getType (String Type) {
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

	@SuppressWarnings ("unused")
	private static String getType (int n) {
		switch (n) {
			default:
			case -1:
				return "unsupported";
			case 0:
				return "var";
			case 1:
				return "string";
			case 2:
				return "bool";
			case 3:
				return "object";
			case 4:
				return "int";
			case 5:
				return "short";
			case 6:
				return "long";
		}
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
			String[] a = s.getSt().splitWithDelimiters("_", 2);
			if (a.length == 3) s.set(a[1]);
			return s.toInt();
		}
		return -1;
	}

	public static void newScope () {
		ArrayList <Integer> c = new ArrayList <Integer>(child.get(curScope));
		c.add(curScope);
		child.put(curScope, c);
		ArrayList <Integer> p = new ArrayList <Integer>(parent.get(curScope));
		p.add(curScope);
		parent.put(curScope, p);
		maxScope++;
		curScope = maxScope;
	}

	public static void closeScope () {
		curScope = parent.get(curScope).get(parent.get(curScope).size() - 1);
	}

	public static String getName (String name, int Scope, String Type) {
		if (!isValideType(Type) || Scope > maxScope || name.replace(" ", "") == "" || name.contains("_")) throw new RuntimeException("an error occurred");// TODO
		return name.replace(" ", "") + "_" + (curScope == 0 ? "" : Scope) + (Type == "" || Type.toLowerCase() == "var" || Type == null ? "" : "_" + Type);
	}

	public static boolean addVar (String name) {
		return addVar(name, curScope, "Var");
	}

	public static boolean addVar (String name, String Type) {
		return addVar(name, curScope, Type);
	}

	public static boolean addVar (String name, int Scope, String Type) {
		if (!isValideType(Type) || Scope > maxScope) return false;
		// name.add(); //TODO
		return true;
	}

	public static boolean exist (String name) {
		return exist(name, curScope, "var");
	}

	public static boolean exist (String name, String Type) {
		return exist(name, curScope, Type);
	}

	public static boolean exist (String name, int Scope, String Type) {
		return ! (isValideType(Type) || Scope > maxScope) || false;
	}
}
