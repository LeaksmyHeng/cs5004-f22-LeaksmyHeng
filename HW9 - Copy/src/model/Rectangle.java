package model;

public class Rectangle extends AbstractShape {
  /**
   * Create a constructor for the AbstractShape class.
   *
   * @param x: x coordinate of the shape. This is the lower left x coordinate.
   * @param y: y coordinate of the shape. This is the lower left y coordinate.
   * @param width: width of the rectangle.
   * @param height: height of the rectangle.
   * @param r: the red color that we put into the RGB format.
   * @param g: the green color that we put into the RGB format.
   * @param b: the blue color that we put into the RBG format.
   * @param name: the given name for our shape.
   */
  public Rectangle(int x, int y, int width, int height, int r, int g, int b, String name)
          throws IllegalArgumentException {
    super(x, y, width, height, r, g, b, name);
  }

  @Override
  public shapeType shapeType() {
    return shapeType.RECTANGLE;
  }

  @Override
  public IShape copy() {
    return new Rectangle(this.getX(), this.getY(), this.getWidth(), this.getHeight(), this.getR(),
            this.getG(), this.getB(), this.shapeName());
  }

  /**
   * Create a toString method for Rectangle.
   */
  @Override
  public String toString() {
    return String.format("Name: %s\nType: Rectangle\nMin corner: (%d, %d), Width: %d, "
                    + "Height: %d, Color: (%d, %d, %d)\n",
            this.shapeName(), this.getX(), this.getY(), this.getWidth(), this.getHeight(),
            this.getR(), this.getG(), this.getB());
  }
}
