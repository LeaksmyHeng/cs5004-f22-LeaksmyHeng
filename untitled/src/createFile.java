import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class createFile {
  public static void main(String[] args) throws FileNotFoundException {
    java.io.File input = new java.io.File("firstFile.txt");
    if (input.exists()) {
      System.out.println("File already exists.\n");
    }
    else {
      try (java.io.PrintWriter createFile = new java.io.PrintWriter(input)) {
        createFile.print("Hello my name is Leaksmy");
        createFile.println("I am 20 years old");
        createFile.println("I have take 3 courses so far.");
      }
    }
  }
}
