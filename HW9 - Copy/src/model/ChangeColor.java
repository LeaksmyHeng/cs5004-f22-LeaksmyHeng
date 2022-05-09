package model;

/**
 * Create an abstract class to change the color of the shape.
 */
public class ChangeColor extends AbstractChange {
  private final int toR;
  private final int toG;
  private final int toB;
  private final int fromR;
  private final int fromG;
  private final int fromB;

  /**
   * Create a constructor for ChangeColor.
   * We didn't change the toB and fromB and the rest because this will be handled in the PhotoAlbum
   * level before we call this method.
   */
  public ChangeColor(IShape shape, int toB, int toG, int toR)
          throws IllegalArgumentException {
    super(shape);
    this.toB = toB;
    this.toG = toG;
    this.toR = toR;
    this.fromB = shape.getB();
    this.fromG = shape.getG();
    this.fromR = shape.getR();
    shape.setColor(toR, toG, toB);

    // Check if the new RGB is within the range of 0 and 255
    if (toB < 0 || toG < 0 || toR < 0) {
      throw new IllegalArgumentException("RGB cannot be less than 0.");
    }
    if (toB > 255 || toG > 255 || toR > 255) {
      throw new IllegalArgumentException("RGB cannot be greater than 0.");
    }
  }

  /**
   * Create a getter method to get the Red color that we change to.
   */
  public int getToR() {
    return this.toR;
  }

  /**
   * Create a getter method to get the Green color that we change to.
   */
  public int getToG() {
    return this.toG;
  }
  /**
   * Create a getter method to get the Blue color that we change to.
   */
  public int getToB() {
    return this.toB;
  }

  /**
   * Create a getter method to get the Red color that we changed from.
   * */
  public int getFromR() {
    return this.fromR;
  }

  /**
   * Create a getter method to get the Green color that we changed from.
   * */
  public int getFromG() {
    return this.fromG;
  }

  /**
   * Create a getter method to get the Blue color that we changed from.
   * */
  public int getFromB() {
    return this.fromB;
  }

  /**
   * Create a toString method that tell us what is the color that we changed to.
   */
  @Override
  public String toString() {
    return String.format("ShapeID: %s changes color from (%d,%d,%d) to (%d,%d,%d)\n",
            this.getShapeID().shapeName(), getFromR(), getFromG(), getFromB(),
            getToR(), getToG(), getToB());
  }
}
