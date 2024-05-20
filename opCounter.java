	public class opCounter {
		/*enum symb {
			'+',
			'-',
			'*',
			'/'
		}*/
	public static int count(String input) {
		char val[] = { '+','-','*','/'};
		int count = 0;
		char[] characters = input.toCharArray();
		for(char c : characters) {
			for(char v : val) {
				if (c == v) count++;
			}
		}
		return count;
	}
}