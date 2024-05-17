import java.io.*;
import java.util.*;
import java.io.FileNotFoundException;
import java.io.File;
import java.util.Scanner;

public class ReadFile {
  public static void duplicate(/*String[] args*/) {
    try {
      File crFile = new File("outFile.txt");
      if (!crFile.createNewFile())  System.out.println("file exisit");
      else System.out.println("File created automatically");
      try {
        FileWriter outFile = new FileWriter("outFile.txt");
        outFile.write("File updated!");
        //outFile.close();
        try {
          File inFile = new File("inFile.txt");
          Scanner read = new Scanner(inFile);
          while (read.hasNextLine()) {
            String line = read.nextLine();
            outFile.write(line + "\n");
            System.out.println(line);
          }
        } catch (FileNotFoundException  e) {
          e.printStackTrace();
        }
        outFile.close();
      } catch (IOException e) {
        e.printStackTrace();
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
