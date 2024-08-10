package utilities;

import java.util.*;
import java.io.*;
//import utilities.converter;

public class stringManager {
	private String dataSt;
	private char[] data;
	int opLength = 3;
	ArrayList <String> op = new ArrayList <String>();

	public stringManager (String data) {
		this.dataSt = data;
		data.length();
		this.data = this.dataSt.toCharArray();
		loadBaseOp();
	}

	public final String getSt () { return dataSt; }

	public final char[] getCharA () { return data; }

	public final void set (String in) {
		dataSt = in;
		data = in.toCharArray();
	}

	public final void set (char[] in) {
		dataSt = in.toString();
		data = in;
	}

	public final int countOp () {
		char empty = ' ';
		int n = opLength;
		@SuppressWarnings ("unchecked")
		char[][] ops = converter.toChar((ArrayList <String>) this.op.clone());
		return countOcc(ops, n, empty);
	}

	public final int toInt () {
		int n = 0;
		for (char c : data) {
			int a = switch (c) {
				default -> 0;
				case '1' -> 1;
				case '2' -> 2;
				case '3' -> 3;
				case '4' -> 4;
				case '5' -> 5;
				case '6' -> 6;
				case '7' -> 7;
				case '8' -> 8;
				case '9' -> 9;
			};
			if (a != 0) n *= 10;
			n += a;
		}
		return n;
	}

	public final int countOcc (String value) {
		return countOcc(value.toCharArray());
	}

	public final int countOcc (String[] value) {
		int m = 1;
		for (String v : value) if (v.length() >= m) m = v.length();
		char[][] a = new char[value.length][m];
		for (int i = 0; i < value.length; i++) a[i] = value[i].toCharArray();
		return countOcc(a);
	}

	public final int countOcc (char[] value) {
		char[][] v = { value };
		return countOcc(v, value.length, ' ');
	}

	public final int countOcc (char[][] value) {
		return countOcc(value, value[0].length, ' ');
	}

	public final int countOcc (char[][] value, char any) {
		return countOcc(value, value[0].length, any);
	}

	public final int countOcc (char[][] value, int nChar) {
		return countOcc(value, nChar, ' ');
	}

	public final int[] countSimb (char[][] value, char any) {
		int[] array = new int[value.length];
		for (int i = 0; i < value.length; i++) {
			char[][] tmp = { value[i] };
			array[i] = countOcc(tmp, any);
		}
		return array;
	}

	public final int countOcc (char[][] value, int nChar, char any) {
		int count = 0;
		for (int i = 0; i < dataSt.length() - nChar + 1; i++) {
			for (int k = 0; k < value.length; k++) {
				boolean found = true;
				for (int n = 0; n < nChar; n++) {
					if (value[k][n] == any) continue;
					if (value[k][n] != this.data[i + n]) {
						found = false;
						break;
					}
				}
				if (found) {
					count++;
					i = i + nChar - 2;// TODO is this necessary?
					break;
				}
			}
		}
		return count;
	}

	public final int getPos (char[][] val) {
		for (int i = 0; i < dataSt.length() - val[0].length; i++) {
			for (int n = 0; n < val.length; n++) {
				if (val[i][n] != this.data[i + n]) n = val.length + 1;
				else if (n == val.length) return i;
			}
		}
		String error = "in " + dataSt + " weren't found any of the following: ";
		for (char[] v : val) {
			for (char a : v) error = error + a;
			error = error + ",\n";
		}
		Throwable err = new Throwable(error);
		throw new IOError(err);
	}

	public final int getOpPos (int index) {
		var count = 0/* ,rtn = 0 */;
		for (int i = 0; i < dataSt.length() - 3; i++) {
			boolean done = false;
			for (String opSt : op) {
				char[] val = opSt.toCharArray();
				for (int n = 0; n < 3; n++) {
					if (done || val[n] != this.data[i + n]) n = 3 + 1;
					if (n == 3) done = true;
				}
			}
			if (done) count++;
		}
		return count;// TODO ???????
	}

	public final void loadBaseOp () {
		op.add(" + ");
		op.add(" - ");
		op.add(" * ");
		op.add(" / ");
		op.add("<< ");
		op.add(">> ");
	}

	@Override
	public final String toString () {
		return dataSt;
	}
}
