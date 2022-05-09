package model;

import java.util.ArrayList;
import java.util.Map;

/**
 * Create the interface for the photo album that we will be implemented in the PhotoAlbum class.
 */
public interface IPhotoAlbum {

  /**
   * Create a method which allows us to add the shape to the canvas.
   */
  void addShape(String name, shapeType type, int x, int y, int r, int g, int b, int width, int height);

  /**
   * Create a method which allows us to change the position of the shape that we added in.
   */
  void changePosition(String shapeID, int toX, int toY);

  /**
   * Create a method which allows us to change the color of the shape that we have added in.
   */
  void changeColor(String shapeID, int toR, int toG, int toB);

  /**
   * Create a method which allows us to change the size of the shape that we added in.
   */
  void changeShapeSize(String shapeID, int toWidth, int toHeight);

  /**
   * Create a toString method.
   */
  String snapShotInformation();

  /**
   * Add a remove method.
   */
  void remove(String shapeId);

  /**
   * Method to snap the photo album at a certain time.
   */
  void snapshot(String description);

  /**
   * Create a method to get the top left of the X coordinate.
   */
  int getBotomLeftX();

  /**
   * Create a method to get the top left of the Y coordinate.
   */
  int getBotomLeftY();

  /**
   * Create a method to get the width of the canvas.
   */
  int getCanvasWidth();

  /**
   * Create a method to get the Height of the canvas.
   */
  int getCanvasHeight();

  /**
   * Setter for canvas width.
   */
  void setCanvasWidth(int width);

  /**
   * Setter for the canvas height.
   */
  void setCanvasHeight(int height);

  /**
   * Get the list of the shape.
   */
  Map<String, IShape> getShapeList();

  /**
   * Preview next snapshot.
   * */
  Map<String, IShape> getNext();

  /**
   * Preview the previous snapshot.
   */
  Map<String, IShape> getPrev();

  /**
   * The html command.
   */
  String htmlCommand();

  /**
   * Get snapshot list.
   */
  Map<String, Map<String, IShape>> getSnapShotList();

  /**
   * Get all the key of the snapshot as of string. This will be use in JOptionPane.
   */
  ArrayList<String> getSnapShotListKey();
}
