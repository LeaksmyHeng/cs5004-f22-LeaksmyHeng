package model;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * Create a Photo Album class that implement IPhotoAlbum interface.
 */
public class PhotoAlbum implements IPhotoAlbum {
  private final int botomLeftX;
  private final int botomLeftY;
  private final int canvasWidth;
  private final int canvasHeight;
  private final Map<String, IShape> shapeList = new LinkedHashMap<>();
  private final Map<String, IShape> shapeListCopy = new LinkedHashMap<>();
  private final List<AbstractChange> shapeTranformation = new ArrayList<>();
  private final Map<String, IShape> copyOriginalList = new LinkedHashMap<>();

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
  public void addShape(String name, shapeType type, int x, int y, int r, int g, int b,
                       int width, int height) throws IllegalArgumentException {
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
        if ((x - width) >= botomLeftX && ((x + width) <= (botomLeftX + canvasWidth))
                && (y - height) >= botomLeftY
                && (y + height) <= (botomLeftY + canvasHeight)) {
          shape = new Oval(x, y, width, height, r, g, b, name);
          String id = name.toUpperCase();
          // Add the shape into our LinkedHashMap and its copy.
          shapeList.put(id, shape);
        }
        else {
          throw new IllegalArgumentException("Oval out of canvas boundary.");
        }
      }
      catch (IllegalArgumentException e) {
        System.out.println("Oval out of canvas boundary.");
      }
    }
    else if (Objects.equals(type.name, "R")) {
      try {
        if ((x >= getBotomLeftX()) && (x < (getBotomLeftX() + canvasWidth))
                && ((x + width) <= (getBotomLeftX() + canvasWidth)) && (y >= botomLeftY)
                && (y <= botomLeftY + canvasHeight)
                && ((y + height) <= (canvasHeight + getBotomLeftY()))) {
          shape = new Rectangle(x, y, width, height, r, g, b, name);
          String id = name.toUpperCase();
          // Add the shape into our LinkedHashMap and its copy.
          shapeList.put(id, shape);
        }
        else {
          throw new IllegalArgumentException("Rectangle is invalid - outside of canvas boundary.");
        }
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

  /**
   * Change the position of our shape by searching for shapeID first.
   * Our shape ID is not case-sensitive.
   * */
  @Override
  public void changePosition(String shapeID, int toX, int toY)
          throws IllegalArgumentException {
    if (isInHashMap(shapeID)) {
      String id = shapeID.toUpperCase();
      int x = shapeList.get(id).getX();
      int y = shapeList.get(id).getY();

      // Check if the X and Y coordinate is the same as the before making changes.
      if (x == toX && y == toY) {
        throw new IllegalArgumentException("X or Y need to be different from the original position.");
      }
      AbstractChange change = new ChangePosition(shapeList.get(id), toX, toY);
      shapeTranformation.add(change);
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
        AbstractChange change = new ChangeColor(shapeList.get(id), toB, toG, toR);
        shapeTranformation.add(change);
      }
    }
  }

  @Override
  public void changeShapeSize(String shapeID, int toWidth, int toHeight)
          throws IllegalArgumentException {
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
        AbstractChange change = new ChangeShapeSize(shapeList.get(id), toWidth, toHeight);
        shapeTranformation.add(change);
      }
    }
  }

  /**
   * Return a copy of the shape so that we are not going to mutate the original one.
   */
  @Override
  public Map<String, IShape> getShapeList() {
    Map<String, IShape> copyShapeList = new LinkedHashMap<>();
    for (String key : shapeList.keySet()) {
      copyShapeList.put(key, shapeList.get(key).copy());
    }
    return copyShapeList;
  }

  /**
   * Get a copy of the list that has been transformed.
   */
  public List<AbstractChange> getShapeTransformationList() {
    List<AbstractChange> copyTransformList = new ArrayList<>();
    copyTransformList.addAll(shapeTranformation);
    return copyTransformList;
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
  public void restart() {

  }

  public void snapshot() {
    Timestamp timestamp = new Timestamp(System.currentTimeMillis());
    String id = timestamp.toString();
    return;
  }

  /**
   * The helper class for the snapShotInformation. This is the original shape that we add.
   */
  public String shapeListToString() {
    StringBuilder string = new StringBuilder();
    string.append("Shape information:\n");
    shapeListCopy.putAll(shapeList);
    for (String key : shapeListCopy.keySet()) {
      string.append(shapeListCopy.get(key).toString());
    }
    return string.toString();
  }

  @Override
  public String snapShotInformation(String description){
    StringBuilder string = new StringBuilder();
    Timestamp timestamp = new Timestamp(System.currentTimeMillis());
    String id = timestamp.toString();
    string.append("Printing Snapshots: ");
    string.append("\nSnapshot ID: ").append(timestamp.toInstant());
    string.append("\nTimestamp: ").append(timestamp);
    string.append("\nDescription: ").append(description).append("\n");
    return string.toString() + shapeListToString();
  }

  @Override
  public void remove(String shapeID) {
    if (shapeID == null) {
      throw new IllegalArgumentException("Shape ID cannot be null.");
    }
    shapeList.remove(shapeID);
  }
}
