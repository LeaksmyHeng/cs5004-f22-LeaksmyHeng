package model;

import java.io.Serializable;
import java.time.Instant;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Set;


/**
 * Create a Photo Album class that implement IPhotoAlbum interface.
 */
public class PhotoAlbum implements Serializable, IPhotoAlbum {
  private final int botomLeftX;
  private final int botomLeftY;
  private int canvasWidth;
  private int canvasHeight;
  private final Map<String, IShape> shapeList = new LinkedHashMap<>();
  private final Map<String, Map<String, IShape>> snapShotList = new LinkedHashMap<>();
  private static int elementIndex = 0;

  /**
   * Create a constructor for PhotoAlbum or canvas. Throw an illegal argument if our height
   * or our width is negative.
   */
  public PhotoAlbum(int botomLeftX, int botomLeftY, int canvasHeight, int canvasWidth)
          throws IllegalArgumentException {
    this.botomLeftX = botomLeftX;
    this.botomLeftY = botomLeftY;
    this.canvasHeight = canvasHeight;
    this.canvasWidth = canvasWidth;

    if (canvasHeight < 0 || canvasWidth < 0) {
      throw new IllegalArgumentException("Canvas height and width cannot be negative.");
    }
  }

  @Override
  public void addShape(String name, shapeType type, int x, int y, int r, int g, int b, int width, int height) {
    IShape shape;

    if (width < 0 || height < 0) {
      throw new IllegalArgumentException("Width or height cannot be negative.");
    }
    if (r < 0 || g < 0 || b < 0) {
      throw new IllegalArgumentException("RGB color cannot be less than 0");
    }
    if (r > 255 || g > 255 || b > 255) {
      throw new IllegalArgumentException("RBG color cannot be greater than 255");
    }
    if (shapeList.containsKey(name.toUpperCase())) {
      throw new IllegalArgumentException("Shape ID already exist! Change the name of your shape.");
    }

    // Check if the shape Oval and Rectangle is in the canvas. If it is not then do try and catch.
    if (Objects.equals(type.name, "O")) {
      try {
          shape = new Oval(x, y, width, height, r, g, b, name);
          String id = name.toUpperCase();
          // Add the shape into our LinkedHashMap and its copy.
          shapeList.put(id, shape);
      }
      catch (IllegalArgumentException e) {
        System.out.println("Oval out of canvas boundary.");
      }
    }
    else if (Objects.equals(type.name, "R")) {
      try {
          shape = new Rectangle(x, y, width, height, r, g, b, name);
          String id = name.toUpperCase();
          // Add the shape into our LinkedHashMap and its copy.
          shapeList.put(id, shape);
      }
      catch (IllegalArgumentException e) {
        System.out.println("Rectangle is invalid - outside of canvas boundary.");
      }
    }
  }

  /**
   * Check if the shapeID is in our dictionary or hashmap.
   */
  public boolean isInHashMap(String shapeID) throws IllegalArgumentException {
    if (shapeID == null) {
      throw new IllegalArgumentException("Shape ID cannot be null.");
    }
    String id = shapeID.toUpperCase();
    if (!shapeList.containsKey(id)) {
      throw new IllegalArgumentException("shapeID does not exist.");
    }
    return true;
  }

  @Override
  public void changePosition(String shapeID, int toX, int toY) throws IllegalArgumentException {
      if (isInHashMap(shapeID)) {
        String id = shapeID.toUpperCase();
        int x = shapeList.get(id).getX();
        int y = shapeList.get(id).getY();

        // Check if the X and Y coordinate is the same as the before making changes.
        if (x == toX && y == toY) {
          throw new IllegalArgumentException("X or Y need to be different from the original position.");
        }
        new ChangePosition(shapeList.get(id), toX, toY);
        //System.out.println(shapeList.get(id).getX() + shapeList.get(id).getY());
        //System.out.println("Expected" + toX + toY);
        //System.out.println("Expected" + shapeList.get(id));
      }
  }

  @Override
  public void changeColor(String shapeID, int toR, int toG, int toB) throws IllegalArgumentException {
    if (isInHashMap(shapeID)) {
      String id = shapeID.toUpperCase();
      int red = shapeList.get(id).getR();
      int green = shapeList.get(id).getG();
      int blue = shapeList.get(id).getB();

      // check if the color that is changed is the same as the old color.
      if (red == toR && green == toG && blue == toB) {
        throw new IllegalArgumentException("The colors you are changing to is the same.");
      }
      else {
        new ChangeColor(shapeList.get(id), toB, toG, toR);
      }
    }
  }

  @Override
  public void changeShapeSize(String shapeID, int toWidth, int toHeight) throws IllegalArgumentException {
    if (isInHashMap(shapeID)) {
      String id = shapeID.toUpperCase();
      int fromWidth = shapeList.get(id).getWidth();
      int fromHeight = shapeList.get(id).getHeight();

      // check if the fromWidth and fromHeight is the same as the toWidth and toHeight.
      if (fromHeight == toHeight && fromWidth == toWidth) {
        throw new IllegalArgumentException("Same width and height as the old one.");
      }
      if (toHeight < 0 || toWidth < 0) {
        throw new IllegalArgumentException("Height and Width cannot be negative.");
      }
      else {
        new ChangeShapeSize(shapeList.get(id), toWidth, toHeight);
      }
    }
  }

  @Override
  public void remove(String shapeID) {
    if (shapeID == null) {
      throw new IllegalArgumentException("Shape ID cannot be null.");
    }
    if (isInHashMap(shapeID)) {
      shapeList.remove(shapeID.toUpperCase());
    }
    else {
      throw new IllegalArgumentException("No ID to be removed.");
    }
  }

  public int numberOfSnapShot() {
    return snapShotList.keySet().size();
  }

  @Override
  public void snapshot(String description) {
    if (description == null) {
      description = " ";
    }
    StringBuilder string = new StringBuilder();
    String timestamp = Instant.now().toString();
    // Insert id and description in the same string
    String idAndDescription = timestamp + "- desc:" + description;
    Map<String, IShape> newShapeList = new LinkedHashMap<>();
    for (String key: shapeList.keySet()) {
      newShapeList.put(key, shapeList.get(key).copy());
    }
    snapShotList.put(idAndDescription, newShapeList);
    //System.out.println("\n printing new shaplist" + snapShotList);
  }

  public String shapeListToString() {
    StringBuilder string = new StringBuilder();
    string.append("Shape information:\n");

    for (String key : shapeList.keySet()) {
      string.append(shapeList.get(key).toString());
    }
    return string.toString();
  }


  @Override
  public String snapShotInformation() {
    StringBuilder string = new StringBuilder();
    string.append("Printing Snapshots: \n");
    for (String key: snapShotList.keySet()) {
      String[] stringSplit = key.split("- desc:", 0);
      String id = stringSplit[0];
      String description;
      try {
        description = stringSplit[1];
      }
      catch (ArrayIndexOutOfBoundsException e) {
        description = "";
      }
      String[] date = id.split("T", 0);
      String timestamp = date[1];
      string.append("Snapshot ID: ").append(id).append("\n");
      string.append("Timestamp: ").append(date[0]).append(" ").append(timestamp).append("\n");
      string.append("Description: ").append(description).append("\n");
      string.append("Shape information: ").append("\n");
      for (String snapshotKey: snapShotList.get(key).keySet()) {
        string.append(snapShotList.get(key).get(snapshotKey).toString());
      }


      //System.out.println(snapShotList);
    }
    return string.toString();
  }

  @Override
  public int getBotomLeftX() {
    return this.botomLeftX;
  }

  @Override
  public int getBotomLeftY() {
    return this.botomLeftY;
  }

  @Override
  public int getCanvasWidth() {
    return this.canvasWidth;
  }

  @Override
  public int getCanvasHeight() {
    return this.canvasHeight;
  }

  @Override
  public void setCanvasWidth(int canvasWidth) {
    this.canvasWidth = canvasWidth;
  }

  @Override
  public void setCanvasHeight(int canvasHeight) {
    this.canvasHeight = canvasHeight;
  }

  @Override
  public Map<String, IShape> getShapeList() {
    Map<String, IShape> copyShape = new LinkedHashMap<>();
    for (String key : shapeList.keySet()) {
      copyShape.put(key, shapeList.get(key).copy());
    }
    return copyShape;
  }

  @Override
  public Map<String, IShape> getNext() {
    try {
      if (snapShotList.size() > 0) {
        Set<String> keys = snapShotList.keySet();
        ArrayList<String> keysList = new ArrayList<String>(keys);
        // the element index for the next key;
        try {
          elementIndex = elementIndex + 1;
          String snapshotKey = keysList.get(elementIndex);
          Map<String, IShape> nextSnapShot = snapShotList.get(snapshotKey);
          return nextSnapShot;
        }
        catch (IndexOutOfBoundsException e) {
          System.out.println("We don't have any more snapshot to view.");
        }
      }
    }
    catch (IllegalArgumentException e) {
      System.out.println("Cannot go to next snapshot cause your album has 0 snapshot it in.");
    }
    return null;
  }

  @Override
  public Map<String, IShape> getPrev() {
    try {
      if (snapShotList.size() > 0) {
        Set<String> keys = snapShotList.keySet();
        ArrayList<String> keysList = new ArrayList<String>(keys);
        // the element index for the next key;
        try {
          elementIndex = elementIndex - 1;
          String snapshotKey = keysList.get(elementIndex);
          return snapShotList.get(snapshotKey);
        }
        catch (IndexOutOfBoundsException e) {
          System.out.println("We don't have any more snapshot to view.");
        }
      }
    }
    catch (IllegalArgumentException e) {
      System.out.println("Cannot go to next snapshot cause your album has 0 snapshot it in.");
    }
    return null;
  }

  public String htmlHeadCommand(String key, String description) {
    return "<div>\n" +
            "<h2>" + key + "</h2>\n" +
            "<h3>Description: " + description + "</h3>\n" +
            "<svg width=\"1000\" height=\"1000\">\n";
  }

  public String htmlBodyCommand(String key) {
    StringBuilder string = new StringBuilder();
    Map<String, IShape> shapes = snapShotList.get(key);
    for (String shapeKey : shapes.keySet()) {
      if (Objects.equals(shapes.get(shapeKey).shapeType().toString(), "RECTANGLE")) {
        string.append("<rect id=\"" + shapes.get(shapeKey).shapeName()
                + "\" x=\"" + shapes.get(shapeKey).getX() + "\" Y=\"" + shapes.get(shapeKey).getY()
                + "\" width=\""  + shapes.get(shapeKey).getWidth()
                + "\" height=\""  + shapes.get(shapeKey).getHeight()
                + "\" fill=\"rgb("  + shapes.get(shapeKey).getR() + ","+ shapes.get(shapeKey).getG() + ","+ shapes.get(shapeKey).getB()
                + ")\" visibility=\"visible\"></rect>\n");
      }
      if (Objects.equals(shapes.get(shapeKey).shapeType().toString(), "OVAL")) {
        string.append("<ellipse id=\"" + shapes.get(shapeKey).shapeName()
                + "\" cx=\"" + shapes.get(shapeKey).getX() + "\" cy=\"" + shapes.get(shapeKey).getY()
                + "\" rx=\""  + shapes.get(shapeKey).getWidth()
                + "\" ry=\""  + shapes.get(shapeKey).getHeight()
                + "\" fill=\"rgb("  + shapes.get(shapeKey).getR() + ","+ shapes.get(shapeKey).getG() + ","+ shapes.get(shapeKey).getB()
                + ")\" visibility=\"visible\"></ellipse>\n");
      }
    }
    return string.toString();
  }

  public String htmlEndCommand() {
    StringBuilder string = new StringBuilder();
    string.append("</svg>\n");
    string.append("</div>\n");
    return string.toString();
  }

  @Override
  public String htmlCommand() {
    StringBuilder string = new StringBuilder();
    for (String key: snapShotList.keySet()) {
      String[] stringSplit = key.split("- desc:", 0);
      String id = stringSplit[0];
      String description;
      try {
        description = stringSplit[1];
      }
      catch (IndexOutOfBoundsException e) {
        description = "";
      }
      String[] date = id.split("T", 0);
      String timestamp = date[1];
      string.append(htmlHeadCommand(id, description));
      string.append(htmlBodyCommand(key));
      string.append(htmlEndCommand());
    }
    return string.toString();
  }

  @Override
  public Map<String, Map<String, IShape>> getSnapShotList() {
    Map<String, Map<String, IShape>> copySnapShotList = new LinkedHashMap<>();
    for (String key : snapShotList.keySet()) {
      copySnapShotList.put(key, snapShotList.get(key));
    }
    return copySnapShotList;
  }

  @Override
  public ArrayList<String> getSnapShotListKey() {
    ArrayList<String> keysList = new ArrayList<String>();
    int counter = 1;
    for (String key: snapShotList.keySet()) {
      String[] stringSplit = key.split("- desc:", 0);
      String id = counter + ". " + stringSplit[0];
      String description;
      try {
        description = stringSplit[1];
      }
      catch (ArrayIndexOutOfBoundsException e) {
        description = "";
      }
      keysList.add(id);
      counter++;
    }
    return keysList;
  }
}
