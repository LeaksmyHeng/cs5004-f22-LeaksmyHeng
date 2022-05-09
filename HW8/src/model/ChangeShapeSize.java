package model;

/**
 * Create a method to change the size of our shape.
 */
public class ChangeShapeSize extends AbstractChange {
  private final int fromWidth;
  private final int fromHeight;
  private final int toWidth;
  private final int toHeight;

  /**
   * Create a constructor of our ChangeShapeSize class.
   */
  public ChangeShapeSize(IShape shape, int toWidth, int toHeight) throws IllegalArgumentException {
    super(shape);
    // throw Illegal Argument if the width and height is less than 0.
    if (toWidth < 0 || toHeight < 0) {
      throw new IllegalArgumentException();
    }
    // we will not check for the same fromWidth and toWidth or fromHeight and toHeight as it will
    // be handled in the PhotoAlbum.
    this.fromWidth = shape.getWidth();
    this.toWidth = toWidth;
    this.fromHeight = shape.getHeight();
    this.toHeight = toHeight;
    shape.setHeight(toHeight);
    shape.setWidth(toWidth);
  }

  /**
   * Create a getter method to get the new width.
   */
  public int getToWidth() {
    return this.toWidth;
  }

  /**
   * Create a getter method to get the new Height.
   */
  public int getToHeight() {
    return this.toHeight;
  }

  /**
   * Create a getter method to get the old width.
   */
  public int getFromWidth() {
    return this.fromWidth;
  }

  /**
   * Create a getter method to get the old height.
   */
  public int getFromHeight() {
    return this.fromHeight;
  }

  /**
   * Create a toString method to print out how the size of the shape has change.
   */
  @Override
  public String toString() {
    return String.format("ShapeID: %s scales from (w: %d, h: %d) to (w: %d, h: %d)\n", this.getShapeID().shapeName(), getFromWidth(),
            getFromHeight(), getToWidth(), getToHeight());
  }
}
