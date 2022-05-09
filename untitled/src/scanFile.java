import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class scanFile {
  public static void main(String[] args) throws FileNotFoundException {
    File output = new File("Building.txt");
    // create a scanner now
    Scanner input = new Scanner(output);
    while (input.hasNext()) {
      System.out.println(input.next());
      //System.out.println(input.nextInt());
    }
    input.close();
  }
}
