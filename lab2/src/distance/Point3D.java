package distance;

import java.util.Objects;

/**
 * Design and implement the basic element to tract and compute simple
 * displacement vectors in 3D space.
 */
public class Point3D {
  private int x;
  private int y;
  private int z;

  /**
   * Create a default constructor for Point3D.
   */
  public Point3D() {
    this.x = this.y = this.z = 0;
  }

  /**
   * Create a constructor for Point3D.
   */
  public Point3D(int x, int y, int z) {
    this.x = x;
    this.y = y;
    this.z = z;
  }

  /**
   * Create a getter method to get value x.
   */
  public int getX() {
    return this.x;
  }

  /**
   * Create a getter method to get value y.
   */
  public int getY() {
    return this.y;
  }

  /**
   * Create a getter method to get value z.
   */
  public int getZ() {
    return this.z;
  }

  /**
   * Create a method to calculate the distance from one point to another.
   */
  public double distanceTo(Point3D other) {
    double displacement = Math.pow(other.x - this.x, 2)
            + Math.pow(other.y - this.y, 2)
            + Math.pow(other.z - this.z, 2);
    return Math.sqrt(displacement);
  }

  /**
   * Create a method that is used to compare a Point3D instance to other Point3D object.
   */
  public boolean equals(Object other) {
    if (this == other) {
      return true;
    }
    if (this.getClass() == other.getClass()) {
      Point3D o = (Point3D) other;
      if (this.x == o.x && this.y == o.y && this.z == o.z) {
        return true;
      }
    }
    return false;
  }

  /**
   * Create a hashCode after creating the equals method above.
   */
  public int hashCode() {
    return Objects.hash(x, y, z);
  }
}
