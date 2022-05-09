package shapes;

public class Triangle extends AbstractShape implements IShape {
  private double height;
  private double base;
  private double a;
  private double b;

  /**
   * Create a constructor for Triangle class.
   */
  public Triangle(int height, int base, int a, int b) {
    super(0, 0);
    this.height = height;
    this.base = base;
    this.a = a;
    this.b = b;
  }

  @Override
  public double getArea() {
    return 1/2 * this.base * this.height;
  }

  @Override
  public double getPerimeter() {
    return a + b + Math.sqrt((a * a) + (b * b));
  }

  public String toString() {
    return String.format("Triangle has height, base, a, b of: %.3f, %.3f, %.3f, %.3f respectively",
            this.height, this.base, this.a, this.b);
  }
}
