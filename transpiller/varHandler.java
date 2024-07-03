package transpiller;

import java.util.*;

public class varHandler {
	private static HashMap<String, Integer> scope = new HashMap<String, Integer>();
	private static HashMap<String, Integer> type = new HashMap<String, Integer>();
	@SuppressWarnings("unused")
	private static HashMap<Integer, ArrayList<Integer>> child = new HashMap<Integer, ArrayList<Integer>>();
	private static HashMap<Integer, ArrayList<Integer>> parent1 = new HashMap<Integer, ArrayList<Integer>>();
	private static int curScope = 0;
	private static int maxScope = 0;

	private static String getType(String varName) {
		return getType(type.get(varName));
	}

	private static String getType(int n) {
		switch (n) {
		case 1:
			return "Var"; // Generic type
		case 2:
			return "String";
		case 3:
			return "Bool";
		case 4:
			return "Object"; // Either unit reference or buliding reference
		case 5:
			return "Type";
		case 6:
			throw new RuntimeException(
					"An error occured.\nHow unfortunate.\n\n\n\n\nReason: The array aren't handeld rn bc i want to focus onto the rest");
		// return "Array"; //TODO Plz implement me ;)
		case 7:
			return "Int";
		case 8:
			return "Short";
		case 9:
			return "Long";
		default:
			throw new RuntimeException(
					"An error occured.\nHow unfortunate.\n\n\n\n\nReason: Method getType in varHandler needs to get a valid number(1-9)");
		}
	}

	public static int getScope(String name) {
		return scope.get(name);
	}

	public static void newScope() {
		ArrayList<Integer> c = new ArrayList<Integer>(child.get(curScope));
		c.add(curScope);
		child.replace(curScope, child.get(curScope), c);
		ArrayList<Integer> p = new ArrayList<Integer>(parent1.get(curScope));
		p.add(curScope);
		parent1.put(curScope, p);
		maxScope++;
		curScope = maxScope;
	}

	public static void closeScope() {
		curScope = parent1.get(curScope).get(parent1.get(curScope).size() - 1);
	}

	public static String getName(String name) {
		return name + "_" + scope.get(name) + "_" + getType(name);
	}

	public static boolean addVar(String name, int Type) {
		return addVar(name, curScope, Type);
	}

	public static boolean addVar(String name, int Scope, int Type) {
		if (scope.containsKey(name) || type.containsKey(name) || Scope > maxScope)
			return false;
		scope.put(name, Scope);
		type.put(name, Type);
		return true;
	}
}