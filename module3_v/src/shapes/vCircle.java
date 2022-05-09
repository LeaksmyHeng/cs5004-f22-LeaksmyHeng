package shapes;

/**
 * This class represents a circle. It offers all operations andated by the vShape interface.
 */
public class vCircle extends vAbstractShape {
  private double radius;

  /**
   * Construct a circle object using the given center and radius.
   * @param x x coordinate of the center of this circle.
   * @param y y coordinate of the center of this circle.
   * @param radius the radius of this circle.
   */
  public vCircle(double x, double y, double radius) {
    //this.reference = new vPoint2D(x, y);
    super(new vPoint2D(x, y));
    this.radius = radius;
  }

  /**
   * Construct a circle object with the given radius. It is centered at (0, 0).
   * @param radius the radius of this circle.
   */
  public vCircle(double radius) {
    super(new vPoint2D(0, 0));
    this.radius = radius;
  }

  /**
   * Create a toString method to list all the field we have available.
   */
  public String toString() {
    return String.format("Circle: center (%.3f, %.3f, %.3f) radius %.3f",
            this.reference.getX(), this.reference.getY(), this.radius);
  }

  @Override
  public double area() {
    double area = Math.PI * this.radius * this.radius;
    return area;
  }

  @Override
  public double perimeter() {
    return 2 * Math.PI * radius;
  }

  @Override
  public vShape resize(double factor) {
    return new vCircle(reference.getX(), reference.getY(), Math.sqrt(factor) * radius);
  }
}
