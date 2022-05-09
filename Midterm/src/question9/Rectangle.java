package question9;

public class Rectangle {
  private int x;
  private int y;
  private int width;
  private int height;

  public Rectangle(int x, int y, int width, int height) throws IllegalArgumentException {
    if (width < 0 || height < 0) {
      throw new IllegalArgumentException("Negative number are not allow for width and height.");
    }
    this.x = x;
    this.y = y;
    this.width = width;
    this.height = height;
  }

  /**
   * Create a getter for x y width and height.
   */
  public int getX() {
    return this.x;
  }

  public int getY() {
    return this.y;
  }

  public int getWidth() {
    return this.width;
  }

  public int getHeight() {
    return this.height;
  }

  public boolean overlap(Rectangle other) {
    return (this.getX() < (other.getX() + other.getWidth())) && ((getX() + getWidth()) > other.getX())
            && ((getY() + getHeight()) > other.getY()) && (getY() < (other.getY() + other.getHeight()));
  }

  public String toString() {
    return "x:" + getX() + ", y:" + getY() + ", w:" + getWidth() + ", h:" + getHeight();
  }
}
