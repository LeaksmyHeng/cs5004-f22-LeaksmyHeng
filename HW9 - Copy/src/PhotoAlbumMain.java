import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.StringReader;
import java.util.Scanner;

import javax.swing.*;

import Utilities.photoAlbumBuilder;
import Utilities.photoAlbumBuilderImp;
import Utilities.photoAlbumReader;
import controller.Controller;
import model.IPhotoAlbum;
import view.IView;
import view.graphicalView;
import view.htmlView;

/**
 * The main method will be the main function of our program. It scans the commandline argument that
 * we put in. Example of commandline argument: -in <InputFile.txt> -out <OutputFile.html> -v web
 * or in <Input.txt> -v graphical 800 800
 * After scanning, it will use the controller to start our program based on the view type that
 * it gets from the commandline argument and the specified file.
 */
public final class PhotoAlbumMain {

  /**
   * Create a static main method.
   */
  public static void main(String[] args) throws FileNotFoundException {
    Readable r = new StringReader(String.join(" ", args));
    Scanner scan = new Scanner(r);
    IView view = null;
    IPhotoAlbum model = null;
    String viewType = "";
    String output = "";
    Readable inFile = null;
    String filename = "";
    int height = -1;
    int width = -1;

    while (scan.hasNext()) {
      String input = scan.next();
      switch (input) {
        case "-in":
          if (scan.hasNext()) {
            try {
              filename = scan.next();
              inFile = new FileReader(filename);
            }
            catch (FileNotFoundException e) {
              System.out.println("An error occurred.");
              e.printStackTrace();
            }
          }
          break;
        case "-out":
          if (output.equals("") && scan.hasNext()) {
            output = scan.next();
          }
          break;
        case "-v":
        case "-view":
          if (viewType.equals("") && scan.hasNext()) {
            viewType = scan.next();
          }
          if (scan.hasNextInt()) {
            height = scan.nextInt();
          }
          if (scan.hasNextInt()) {
            width = scan.nextInt();
          }
          break;
        default:
          JFrame frame = new JFrame();
          frame.setSize(100, 100);
          frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
          JOptionPane.showMessageDialog(frame, "Invalid input",
                  "Error", JOptionPane.ERROR_MESSAGE);
      }
    }

    photoAlbumReader fileReader = new photoAlbumReader();
    photoAlbumBuilder<IPhotoAlbum> builder = new photoAlbumBuilderImp();

    try {
      model = photoAlbumReader.parseFile(inFile, builder);
      if (height != -1) {
        model.setCanvasHeight(height);
      }
      if (width != -1) {
        model.setCanvasWidth(width);
      }
    }
    catch (Exception e) {
      System.out.println(e.getMessage());
      JFrame frame = new JFrame();
      frame.setSize(100, 100);
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      JOptionPane.showMessageDialog(frame,
              "Error while trying to parse the file.",
              "Encountered Error", JOptionPane.ERROR_MESSAGE);
    }

    try {
      if (viewType.equalsIgnoreCase("web")) {
        view = new htmlView(model, filename);
        Controller controller = new Controller(model, view, output);
        controller.start();
      }
      else if (viewType.equalsIgnoreCase("graphical")) {
        assert model != null;
        view = new graphicalView(model);
        Controller c = new Controller(model, view);
        c.start();
      }
    }
    catch (Exception e) {
      System.out.println("Error" + e.getMessage());
      JFrame frame = new JFrame();
      frame.setSize(100, 100);
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      JOptionPane.showMessageDialog(frame, "Cannot parse this view type.",
              "Encountered Error", JOptionPane.ERROR_MESSAGE);
    }
  }

}
