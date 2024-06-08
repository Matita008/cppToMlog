package utilities;

import java.util.*;

public class stringManager {
	String dataSt;
	char[] data;
	int length;
	int opLength = 3;
	ArrayList<String> op = new ArrayList<String>();

	public stringManager(String data) {
		this.dataSt = data;
		this.length = data.length();
		this.data = this.dataSt.toCharArray();
		loadBaseOp();
	}

	public final int countOp() {
		char empty = ' ';
		int n = opLength;
		@SuppressWarnings("unchecked")
		char[][] ops = converter.toChar((ArrayList<String>) this.op.clone());
		return countOcc(ops, n, empty);
	}

public final int countOcc(char[][] value) {
		return countOcc(value, value[0].length, ' ');
	}

public final int countOcc(char[][] value, char any) {
		return countOcc(value, value[0].length, any);
	}

	public final int countOcc(char[][] value, int nChar) {
		return countOcc(value, nChar, ' ');
	}

/*public final int[] countOcc(char[][] value, char any) {
		return countOcc(value, value[0].length, any);
	}*/// TODO

	public final int countOcc(char[][] value, int nChar, char any) {
		int count = 0;
		for (int i = 0; i < length - nChar + 1; i++) {
			for (int k = 0; k < value.length; k++) {
				boolean found = true;
				for (int n = 0; n < nChar; n++) {
					if (value[k][n] == any)
						continue;
					if (!(value[k][n] == this.data[i + n])) {
						found = false;
						break;
					}
				}
				if (found) {
					count++;
					i = i + nChar - 2;
					break;
				}
			}
		}
		return count;
	}

	public final int getOpPos(int index) {
		var count = 0/* ,rtn = 0 */;
		for (int i = 0; i < length - 3; i++) {
			boolean done = false;
			for (String opSt : op) {
				char[] val = opSt.toCharArray();
				for (int n = 0; n < 3; n++) {
					if (done || val[n] != this.data[i + n])
						n = 3 + 1;
					if (n == 3)
						done = true;
				}
			}
			if (done)
				count++;
		}
		return count;
	}

	public final void loadBaseOp() {
		op.add(" + ");
		op.add(" - ");
		op.add(" * ");
		op.add(" / ");
		op.add("<< ");
		op.add(">> ");
	}
}