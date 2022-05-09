package shapes;

public class vPoint2D {
  private double x;
  private double y;

  public vPoint2D(double x, double y) {
    this.x = x;
    this.y = y;
  }

  public double getX() {
    return this.x;
  }

  public double getY() {
    return this.y;
  }

  public double distToOrigin() {
    return Math.sqrt(x * x + y * y);
  }
}
