package Utilities;

import java.util.InputMismatchException;
import java.util.Objects;
import java.util.Scanner;
import java.util.regex.Pattern;


/**
 * This class would be used to read the file that we put in through the command line argument.
 */
public class photoAlbumReader{

  /**
   * This is a method that is used to produce the photoAlbum based on the keyword detected.
   * If detect shape, then add shape to the photoAlbum
   * If detect snapshot, then snapshot that photoAlbum at that certain time with the description
   * If detect move, then check for the shape key to change the position of that shape.
   * If detect resize, then check for the shape key to change the size of that shape.
   * If detect color, then check for the color of that key to change the shape color.
   * If detect remove, check for the shape key to remove that shape out of the album.
   * */
  public static <T> T parseFile(Readable readable, photoAlbumBuilder<T> builder) {
    Objects.requireNonNull(readable, "Must have non-null readable source");
    Objects.requireNonNull(builder, "Must provide a non-null AnimationBuilder");
    try {
      Scanner myReader = new Scanner(readable);
      myReader.useDelimiter(Pattern.compile("(\\p{Space}+|#.*)+"));
      while (myReader.hasNext()) {
        String word = myReader.next();
        switch (word) {
          case "shape":
            readShape(myReader, builder);
            break;
          case "snapshot":
            readSnapShot(myReader, builder);
            break;
          case "move":
            readChangePosition(myReader, builder);
            break;
          case "resize":
            readChangeShapeSize(myReader, builder);
            break;
          case "color":
            readChangeColor(myReader, builder);
            break;
          case "remove":
            readRemove(myReader, builder);
            break;
          default:
            throw new IllegalStateException("Unexpected keyword: " + word +  myReader.nextLine());
        }
      }
      return builder.build();
    }
    catch (NullPointerException e) {
      System.out.println("An error occurred.");
      e.printStackTrace();
    }
    return builder.build();
  }

  /**
   * A static method to detect the next integer in the line.
   */
  private static int getInt(Scanner scanner) {
    try {
      return scanner.nextInt();
    }
    catch (InputMismatchException e) {
      throw new InputMismatchException("This is not interger.\n");
    }
  }

  /**
   * A method that is used to add the shape in the photoAlbum.
   */
  private static <T> void readShape(Scanner scanner, photoAlbumBuilder<T> builder) throws IllegalStateException {
    int[] vals = new int[7];
    String name = null;
    String type = null;
    if (scanner.hasNext()) {
      name = scanner.next();
      //System.out.println(name);
    }
    if (scanner.hasNext()) {
      type = scanner.next();
      //System.out.println(type);
    }
    for (int i = 0; i < 7; i++) {
      vals[i] = getInt(scanner);
      //System.out.println(vals[i]);
    }
    //System.out.println(name + type +  vals[0]+  vals[1]+  vals[2 ]+  vals[3 ]+ vals[4 ]+ vals[5 ]+  vals[6]);
    builder.addShape(name, type, vals[0], vals[1], vals[2],vals[3], vals[4], vals[5],  vals[6]);
  }

  /**
   * A method that is used to snapshot the photoAlbum at a certain time.
   */
  private static <T> void readSnapShot(Scanner scanner, photoAlbumBuilder<T> builder) throws IllegalStateException {
    String snapshotDescription = " ";
    if (scanner.hasNext()) {
      snapshotDescription = scanner.nextLine();
    }
    //System.out.println("Snapshot description" + snapshotDescription);
    builder.snapshot(snapshotDescription);
  }

  /**
   * A method that is used to edit the shape position.
   */
  private static <T> void readChangePosition(Scanner scanner, photoAlbumBuilder<T> builder) throws IllegalStateException {
    int[] vals = new int[2];
    String name = null;
    if (scanner.hasNext()) {
      name = scanner.next();
    }
    for (int i = 0; i < 2; i++) {
      vals[i] = getInt(scanner);
      //System.out.println(vals[i]);
    }
    //System.out.println(name);
    builder.changePosition(name, vals[0], vals[1]);
  }

  /**
   * A method that is used to edit the shape size.
   */
  private static <T> void readChangeShapeSize(Scanner scanner, photoAlbumBuilder<T> builder) throws IllegalStateException {
    int[] vals = new int[2];
    String name = null;
    if (scanner.hasNext()) {
      name = scanner.next();
    }
    for (int i = 0; i < 2; i++) {
      vals[i] = getInt(scanner);
      //System.out.println(vals[i]);
    }
    //System.out.println(name + type +  vals[0]+  vals[1]);
    builder.changeShapeSize(name, vals[0], vals[1]);
  }

  /**
   * A method that is used to edit the shape color.
   */
  private static <T> void readChangeColor(Scanner scanner, photoAlbumBuilder<T> builder) throws IllegalStateException {
    int[] vals = new int[3];
    String shapeId = null;
    if (scanner.hasNext()) {
      shapeId = scanner.next();
    }
    for (int i = 0; i < 3; i++) {
      vals[i] = getInt(scanner);
    }
    builder.changeColor(shapeId, vals[0], vals[1], vals[2]);
  }

  /**
   * A method that is used to remove the shape from the photoAlbum.
   */
  private static <T> void readRemove(Scanner scanner, photoAlbumBuilder<T> builder) throws IllegalStateException {
    String shapeID = null;
    if (scanner.hasNext()) {
      shapeID = scanner.next();
    }
    //System.out.println("Snapshot description" + snapshotDescription);
    builder.remove(shapeID);
  }
}
