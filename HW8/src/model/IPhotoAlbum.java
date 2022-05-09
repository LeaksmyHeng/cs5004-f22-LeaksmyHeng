package model;

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
  String snapShotInformation(String description);

  /**
   * Add a remove method.
   */
  void remove(String shapeId);

  /**
   * Create a method that list all the shapes that we have added to the canvas.
   */
  Map<String, IShape> getShapeList();

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
   * Restart the photo album by reverting it to its original stage.
   */
  void restart();
}
