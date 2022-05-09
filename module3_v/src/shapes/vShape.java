package shapes;

/**
 * This interface contains all operations that all types of shapes should support.
 */
// Comparable<vShape> compare circle against ractange or sth like that
public interface vShape extends Comparable<vShape> {
  /**
  * Returns the distance of this shape from the origin. This distance is measured from
  * whatever reference position a shape is (e.g. a center for a circle).
  * @return the distance from the origin.
  */
  double distanceFromOrigin();

  /**
   * Returns the area of whatever shapes we specify.
   * @return the area of the shape.
   */
  double area();

  /**
   * Returns the perimeter of the shape we specify.
   * @return perimeter of the shape.
   */
  double perimeter();

  /**
   * Create and return a shpae of the same kind as this one, resized in area by the provided factor.
   * @param factor factor of resizing.
   * @return the resized Shape.
   */
  vShape resize(double factor);

  /**
   * Compares this shape with the one passed to it based on their areas.
   * if (this < s) return a negative number
   * if (this == s) return 0
   * if (this > s) return a positive number
   * @param s the other shape to be compared to
   * @return the result of the comparison
   */
  int compareTo(vShape s);
}
