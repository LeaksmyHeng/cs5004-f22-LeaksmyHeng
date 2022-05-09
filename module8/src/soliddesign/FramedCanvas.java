package soliddesign;

import othershapes.Circle;
import othershapes.IShape;
import othershapes.Square;

public class FramedCanvas implements Canvas {
  @Override
  public void place(Circle circle) {
    System.out.println("Framing circle with bounding box of area " + circle.getArea());
  }

  @Override
  public void place(Square square) {
    System.out.println("Framing square with bounding box of area " + square.getArea());
  }

  @Override
  public void place(IShape shape) {
    System.out.println("Framing unknown shape with bounding box of area " + shape.getArea());
  }
}
