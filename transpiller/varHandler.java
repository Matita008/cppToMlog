package transpiller;

import java.util.*;

public class varHandler {
	private static ArrayList<String> name = new ArrayList<String>();
	private static HashMap<Integer, ArrayList<Integer>> child = new HashMap<Integer, ArrayList<Integer>>();
	private static HashMap<Integer, ArrayList<Integer>> parent1 = new HashMap<Integer, ArrayList<Integer>>();
	private static int curScope = 0;
	private static int maxScope = 0;

	private static Boolean isValideType(String type) {
		if (type == "Array")
			throw new RuntimeException("Arrays aren't supported rn bc i want to focus onto the rest");
		// TODO Plz implement me ;)
		if (type == "Var" || type == "String" || type == "Bool" || type == "Object" || type == "Type" || type == "Int"
				|| type == "Short" || type == "Long") {
			return true;
		}
		return false;
	}

	/*
	 * public static int getScope(String name) { return scope.get(name); }
	 */// TODO Fix this

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

	public static String getName(String name, int Scope, String Type) {
		if (!isValideType(Type) || Scope > maxScope)
			throw new RuntimeException("an error occurred");// TODO
		return name + "_" + Scope + "_" + Type;
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
		return exist(name, curScope, 1);
	}

	public static boolean exist(String name, int Type) {
		return exist(name, curScope, Type);
	}

	public static boolean exist(String name, int Scope, String Type) {
		return !isValideType(Type) || Scope > maxScope || ;
	}
}