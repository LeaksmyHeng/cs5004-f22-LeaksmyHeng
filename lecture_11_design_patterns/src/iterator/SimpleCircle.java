package iterator;

public class SimpleCircle implements IShape {
  private double radius;

  public SimpleCircle(double radius) {
    this.radius = radius;
  }

  @Override
  public double getArea() {
    return Math.PI * this.radius;
  }
}
