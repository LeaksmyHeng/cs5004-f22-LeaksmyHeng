package model;

/**
 * Create an Oval class that extends from Abstract shape. Abstract shape implement ishape.
 */
public class Oval extends AbstractShape {

  /**
   * Create a constructor for the AbstractShape class.
   *
   * @param x: x coordinate of the oval - this is the center point.
   * @param y: y coordinate of the oval - this is the center point.
   * @param width: width for oval would be its x radius.
   * @param height: height for oval would be its y radius.
   * @param r: Red color - RGB.
   * @param g: green color - RGB.
   * @param b: blue color - RGB.
   * @param name: name of the shape that we gave.
   */
  public Oval(int x, int y, int width, int height, int r, int g, int b, String name)
          throws IllegalArgumentException {
    super(x, y, width, height, r, g, b, name);
  }

  @Override
  public IShape copy() {
    return new Oval(this.getX(), this.getY(), this.getWidth(), this.getHeight(), this.getR(),
            this.getG(), this.getB(), this.shapeName());
  }

  @Override
  public shapeType shapeType() {
    return shapeType.OVAL;
  }

  @Override
  public String toString() {
    return String.format("Name: %s\nType: Oval\nCenter: (%d, %d), X radius: %d, "
                    + "Y radius: %d, Color: (%d, %d, %d)\n",
            this.shapeName(), this.getX(), this.getY(), this.getWidth(), this.getHeight(),
            this.getR(), this.getG(), this.getB());
  }
}
