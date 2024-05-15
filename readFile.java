import java.io.*;
import java.util.*;

public class ReadFile {
  public static void main(String[] args) {
    try {
      File outFile = new File("outFile.txt");
      if (!outFile.createNewFile())  System.out.println("file exisit");
      else System.out.println("File created automatically");
      outFile.write("File updated!");
      try {
        File inFile = new File("inFile.txt");
        Scanner read = new Scanner(inFile);
        while (read.hasNextLine()) {
          String line = read.nextLine;
          outFile.write(line + "\n");
          System.out.println(line);
				}
			} catch (IOExeption e) {
        e.printStackTrace();
			}
			outFile.close();
    } catch (IOExeption e) {
      e.printStackTrace();
    }
  }
}
