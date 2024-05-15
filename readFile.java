import java.io.*;
import java.util.*;

public class ReadFile {
  public static void main(String[] args) {
    try {
      File myObj = new File("outFile.txt");
      if (myObj.createNewFile()) {
        System.out.println("File created: " + myObj.getName());
      } else {
        System.out.println("File already exists.");
      }
    } catch (IOException e) {
      System.out.println("An error occurred.");
      e.printStackTrace();
    }
    FileWriter out = new FileWriter("filename.txt");
    try {
      File myObj = new File("inFile.txt");
      Scanner myReader = new Scanner(myObj);
      while (myReader.hasNextLine()) {
        String data = myReader.nextLine();
        out.write(data);
        System.out.println(data);
      }
     try {
      myReader.close();
     } catch (IOException e) {
      System.out.println("An error occurred.");
      e.printStackTrace();
    } catch (FileNotFoundException e) {
      System.out.println("An error occurred.");
      e.printStackTrace();
    }
    try {
    out.close();
    } catch (IOException e) {
      System.out.println("An error occurred.");
      e.printStackTrace();
    } catch (IOException e) {
      System.out.println("An error occurred.");
      e.printStackTrace();
  }
}
