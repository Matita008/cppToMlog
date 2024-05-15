import java.io.*;
import java.util.*;
import java.io.FileNotFoundException;
import java.io.File;
import java.util.Scanner;

public class ReadFile {
  public static void main(String[] args) {
    try {
      File outFile = new File("outFile.txt");
      if (!outFile.createNewFile())  System.out.println("file exisit");
      else System.out.println("File created automatically");
      outFile.write("File updated!");
      outFile.close();
      try {
        File inFile = new File("inFile.txt");
        Scanner read = new Scanner(inFile);
        while (read.hasNextLine()) {
          String line = read.nextLine();
          //outFile.write(line + "\n");
          System.out.println(line);
        }
      } catch (FileNotFoundException  e) {
        e.printStackTrace();
      }
      //outFile.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
