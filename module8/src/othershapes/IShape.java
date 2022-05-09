package othershapes;

import soliddesign.Canvas;
public interface IShape {
  double getPerimeter();
  double getArea();
  default void placedBy(Canvas canvas) {

    System.out.println("Not sure how to place myself");
  }
}
