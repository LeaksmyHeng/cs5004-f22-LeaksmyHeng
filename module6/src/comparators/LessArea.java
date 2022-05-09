package comparators;

import java.util.function.Predicate;

import othershapes.IShape;

public class LessArea implements Predicate<IShape>{
  private final double area;

  public LessArea(double area) {
    this.area = area;
  }

  @Override
  public boolean test(IShape shape) {
    return shape.getArea() < area;
  }
}
