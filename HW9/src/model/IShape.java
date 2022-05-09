package model;

/**
 * Create an interface for IShape.
 */
public interface IShape {

  /**
   * Get X coordinate for shape.
   */
  int getX();

  /**
   * Get Y coordicate for shape.
   */
  int getY();

  /**
   * Get width of the shape.
   */
  int getWidth();

  /**
   * Get Height of the shape.
   */
  int getHeight();

  /**
   * Get Red color for shape - we are using RGB color.
   */
  int getR();

  /**
   * Get Green color for shape - we are using RGB color.
   */
  int getG();

  /**
   * Get Blue color for shape - we are using RBG color.
   */
  int getB();

  /**
   * Get the Shape type.
   */
  shapeType shapeType();

  /**
   * Get the shape name.
   */
  String shapeName();

  /**
   * Set X coordicate of the shape.
   */
  void setX(int x);

  /**
   * Set Y coordicate of the shape.
   */
  void setY(int y);

  /**
   * Set width of the shape - for resizing purposes.
   */
  void setWidth(int width);

  /**
   * Set height of the shape - for resizing purposes.
   */
  void setHeight(int height);

  /**
   * Set color of the shape - for re-coloring purposes.
   */
  void setColor(int r, int g, int b);

  /**
   * Method to copy the Shape.
   */
  IShape copy();
}
