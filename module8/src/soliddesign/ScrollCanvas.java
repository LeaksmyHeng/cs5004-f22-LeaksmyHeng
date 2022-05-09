package soliddesign;

import othershapes.Circle;
import othershapes.IShape;
import othershapes.Square;

public class ScrollCanvas implements Canvas {
  @Override
  public void place(Circle circle) {
    System.out.println("SCROLLING circle with bounding box of area " + circle.getArea());
  }

  @Override
  public void place(Square square) {
    System.out.println("SCROLLING square with bounding box of area " + square.getArea());
  }

  @Override
  public void place(IShape shape) {
    System.out.println("SCROLLING unknown shape with bounding box of area " + shape.getArea());
  }
}
