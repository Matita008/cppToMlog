@ -1,76 +0,0 @@
import java.io.*;
import java.util.*;
import utilities.*;
import transpiller.*;
import static transpiller.formatter.*;

public class readFile {
	public static void main (String[] args) throws Throwable {
		boolean stop = false;
		String inFileName = "inFile.cpp";
		// String workFileName = "workFile.txt";
		String outFileName = "outFile.mlog";
		if (args.length == 0) {} else if (args[0].startsWith("-")) {
			for (int i = 0; i < args.length; i++) {
				if (!args[i].startsWith("-")) { throw new RuntimeException("need '-' before a parameter letter"); }
				switch (args[i]) {
					default:
						throw new RuntimeException("Parameter not recognized :" + args[i]);
					case "-in":
						i++;
						inFileName = args[i];
					break;
					case "-out":
						i++;
						outFileName = args[i];
					break;
					/*
					 case "-work": i++; workFileName = args[i]; break;
					 */
					case "-?":
					case "-help":
						System.out.println("Guide:");
						System.out.println("-in for the input file(if no extension is provided .cpp will be added)");
						System.out.println("-out for the name of the output file (if no extension is provided .mlog will be added)");
						// System.out.println("-work for a workfile");//TODO NO.
						System.out.println("-help it's this fabulous guide ;)");
						stop = true;
					break;
				}
			}
		} else if (args.length == 1) {
			inFileName = args[0];
		} else if (args.length == 2) {
			inFileName = args[0];
			outFileName = args[1];
		}
		/*
		 else if (args.length == 3) { inFileName = args[0]; workFileName =
		 args[1];//TODO NO. outFileName = args[2]; }
		 */
		if (stop) return;

		File outFileCk = new File(outFileName);
		// File workFileCk = new File(workFileName);//TODO NO.
		if (outFileCk.createNewFile()) System.out.println("Output file created automatically");
		else System.out.println("Output file arleady exisit");
		// if (workFileCk.createNewFile()) System.out.println("Work file created
		// automatically");//TODO NO.
		FileWriter outFile = new FileWriter(outFileName);
		// FileWriter workFile = new FileWriter(workFileName);//TODO NO.
		// FileWriter workFile1 = new FileWriter(workFileName + "_1.txt");//TODO NO.
		File inFile = new File(inFileName);
		/*
		  removeComment.MultiLane(inFile, workFile); File workFileRead = new
		  File(workFileName); removeComment.SingleLane(workFileRead, workFile1);
		  Scanner read = new Scanner(inFile); while (read.hasNextLine()) { String line
		  = read.nextLine(); stringManager str = new stringManager(line);
		  outFile.write(str.countOp()); outFile.write(" operation\t");
		 outFile.write(line + "\n"); System.out.print(str.countOp() + " operation\t");
		  System.out.println(line); }
		 */
		read.close();
		// workFile.close();//TODO NO.
		outFile.close();
	}
}