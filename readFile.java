import java.io.*;
import java.util.*;
import utilities.*;

public class readFile {
	public static void main(String[] args) {
		String inFileName = "inFile.cpp";
		String workFileName = "workFile.txt";
		String outFileName = "outFile.mlog";
		if (args.length == 0) {
			int n = 0;
		} else if (args[0].charAt(0) == '-') {
			for (int i = 0; i < args.length; i++) {
				if (!(args[i].charAt(0) == '-')) {
					throw new RuntimeException("need '-' before a parameter letter");
				}
						switch (args[i].charAt(1)) {
				/*default:
					i--;
					break;*/
				case 'i':
					i++;
					inFileName = args[i];
					break;
				case 'o':
					i++;
					outFileName = args[i];
					break;
				case 'w':
					i++;
					workFileName = args[i];
					break;
				}
			}
		} else if (args.length == 1) {
			inFileName = args[0];
		} else if (args.length == 2) {
			inFileName = args[0];
			outFileName = args[1];
		} else if (args.length == 3) {
			inFileName = args[0];
			workFileName = args[1];
			outFileName = args[2];
		}
		try {
			File outFileCk = new File(outFileName);
			File workFileCk = new File(workFileName);
			if (outFileCk.createNewFile())
				System.out.println("Output file created automatically");
			else
				System.out.println("Output file arleady exisit");
			if (workFileCk.createNewFile())
				System.out.println("Work file created automatically");
			FileWriter outFile = new FileWriter(outFileName);
			FileWriter workFile = new FileWriter(workFileName);
			workFile.write("New file recived!");
			try {
				File inFile = new File(inFileName);
				Scanner read = new Scanner(inFile);
				while (read.hasNextLine()) {
					String line = read.nextLine();
					stringManager str = new stringManager(line);
					outFile.write(str.countOp() + " operation\t");
					outFile.write(line + "\n");
					System.out.print(str.countOp() + " operation\t");
					System.out.println(line);
				}
				read.close();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
			workFile.close();
			outFile.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
