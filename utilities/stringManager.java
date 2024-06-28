package utilities;

import java.util.*;
import java.io.*;
import utilities.converter;

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

	public final int[] countSimb(char[][] value, char any) {
		int[] array = new int[value.length];
		for (int i = 0; i < value.length; i++) {
			char[][] tmp = { value[i] };
			array[i] = countOcc(tmp, any);
		}
		return array;
	}

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

	public final int getPos(char[][] val) {
		for (int i = 0; i < length - val[0].length; i++) {
			for (int n = 0; n < val.length; n++) {
				if (val[i][n] != this.data[i + n])
					n = val.length + 1;
				else if (n == val.length)
					return i;
			}
		}
		String error = "in " + dataSt + " weren't found any of the following: ";
		for (char[] v : val)  {
			for (char a : v)	error = error + a;
			error = error + ",\n";
		}
		Throwable err = new Throwable(error);
		throw new IOError(err);
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