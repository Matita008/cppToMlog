import java.io.*;
import java.util.*;
/*import java.io.FileNotFoundException;
import java.io.File;
import java.util.Scanner;*/

public class readFile {
  public static void main(String[] args) {
    try {
      File crFile = new File("outFile.txt");
      if (!crFile.createNewFile())  System.out.println("file exisit");
      else System.out.println("File created automatically");
      try {
          FileWriter outFile = new FileWriter("outFile.txt");
          outFile.write("New file recived!");
          FileWriter workFile = new FileWriter("workFile.txt");
        //outFile.close();
        try {
          File inFile = new File("inFile.txt");
          	Scanner read = new Scanner(inFile);
	          while (read.hasNextLine()) {
	            String line = read.nextLine();
	            outFile.write(opCounter.count(line) + " operation\t");
	            outFile.write(line + "\n");
	            System.out.print(opCounter.count(line) + " operation\t");
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
