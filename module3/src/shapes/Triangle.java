package shapes;

public class Triangle extends AbstractShape implements IShape {
  private double height, base;

  /**
   * Create a constructor for Triangle class.
   */
  public Triangle(double height, double base, int a, int b) {
    super(a, b);
    this.height = height;
    this.base = base;
  }

  @Override
  public double getArea() {
    return 0.5 * this.base * this.height;
  }

  @Override
  public double getPerimeter() {
    return (this.getX() + this.getY() + Math.sqrt(this.getX() * this.getX()
            + this.getY() * this.getY()));
  }

  public String toString() {
    return "Triangle has height, base, a and b of " + this.height + " "
            + this.base + " " + this.getX() + this.getY();
  }

}
