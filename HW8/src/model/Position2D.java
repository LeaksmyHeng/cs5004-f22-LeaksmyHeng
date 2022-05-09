package model;

/**
 * Point class that is used in shape class.
 */
public class Position2D {
  int x;
  int y;

  /**
   * Create the x, y constructor that will be used in shape class.
   */
  public Position2D(int x, int y) {
    this.x = x;
    this.y = y;
  }

  /**
   * A getY method. Y could be a based or height or one angle for the rectangle.
   */
  public int getY() {
    return this.y;
  }

  /**
   * A getX method.
   */
  public int getX() {
    return this.x;
  }
}

