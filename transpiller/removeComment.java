package transpiller;

import java.io.*;
import java.util.*;

public class removeComment {
	private File in;
	private FileWriter out;
	private Scanner scanner;

	removeComment(File in, FileWriter out) {
		this.in = in;
		this.out = out;
	}

	removeComment(File in, String out) throws IOException {
		this.in = in;
		this.out = new FileWriter(out);
	}

	removeComment(String in, FileWriter out) {
		this.in = new File(in);
		this.out = out;
	}

	removeComment(String in, String out) throws IOException {
		this.in = new File(in);
		this.out = new FileWriter(out);
	}

	public void removeMultiLane() throws IOException {
		Scanner read = new Scanner(in);
		while (read.hasNextLine()) {
			String line = read.nextLine();
			if (line.contains("\\*")) {

			}
		}
		read.close();
	}

	public void removeSingleLane(FileWriter output) throws IOException {
		Scanner read = new Scanner(in);
		while (read.hasNextLine()) {
			String line = read.nextLine();
			if (!line.startsWith("\\")) {
				output.write(line);
			}
		}
		read.close();
		output.close();
	}
}
