import java.io.*;
import utilities.*;
import java.util.*;
/*import java.io.FileNotFoundException;
import java.io.File;
import java.util.Scanner;*/

public class readFile {
  public static void main(String[] args) {
    try {
      File outFileCk = new File("outFile.mlog");
      if (!outFileCk.createNewFile())  System.out.println("file exisit");
      else System.out.println("File created automatically");
      try {
          FileWriter outFile = new FileWriter("outFile.mlog");
          FileWriter workFile = new FileWriter("workFile.txt");
          workFile.write("New file recived!");
        try {
          File inFile = new File("inFile.txt");
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
        } catch (FileNotFoundException  e) {
          e.printStackTrace();
        }
        workFile.close();
        outFile.close();
      } catch (IOException e) {
        e.printStackTrace();
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
