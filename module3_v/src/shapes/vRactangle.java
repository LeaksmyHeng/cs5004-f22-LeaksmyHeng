package shapes;

public class vRactangle extends vAbstractShape{
  private double width, height;

  public vRactangle(double x, double y, double width, double height) {
    super(new vPoint2D(x, y));
    this.width = width;
    this.height = height;
  }

  public String toString() {
    return String.format("Ractange: LL corner (%.3f, %.3f) width %.3f height %.3f",
            this.reference.getX(), this.reference.getY(), this.width, this.height);
  }

  @Override
  public double area() {
    double area = this.width * this.height;
    return area;
  }

  @Override
  public double perimeter() {
    return 2 * this.width + 2 * height;
  }

  @Override
  public vShape resize(double factor) {
    double sqrtFactor = Math.sqrt(factor);
    return new vRactangle(reference.getX(), reference.getY(),
            sqrtFactor * this.width, sqrtFactor * this.height);
  }


}
