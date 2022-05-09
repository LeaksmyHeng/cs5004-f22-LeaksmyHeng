package view;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

import model.IPhotoAlbum;

/**
 * Create the htmlView class.
 */
public class htmlView implements IView {
  private final IPhotoAlbum photoAlbums;

  /**
   * Create a constructor for html view.
   */
  public htmlView(IPhotoAlbum photoAlbums, String filename) {
    if (photoAlbums == null) {
      throw new IllegalArgumentException("Error");
    }
    this.photoAlbums = photoAlbums;
  }

  @Override
  public String getView() throws IllegalStateException {
    return "<!DOCTYPE html>\n<html>\n<body>\n" +
            photoAlbums.htmlCommand() +
            "</body>\n</html>\n";
  }

  @Override
  public void makeVisible() {
  }

  @Override
  public GraphicalBuilder getPanel() {
    return null;
  }

  @Override
  public void output(String outputFile, String string) {
    System.out.println("Output file: " + outputFile);

    try {
      BufferedWriter output;
      if (outputFile.equals("System.out")) {
        output = new BufferedWriter(new OutputStreamWriter(System.out));
      }
      else {
        File outFile = new File(outputFile);
        output = new BufferedWriter(new FileWriter(outFile));
      }
      output.write(string);
      output.close();
    }
    catch (IOException iea) {
      System.out.println("Output file " + outputFile + " failed");
    }
  }

  @Override
  public String getViewType() {
    return "web";
  }
}
