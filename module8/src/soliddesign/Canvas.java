package soliddesign;
import othershapes.*;

// Interface to illustrate double-dispatch
public interface Canvas {
  void place(Circle circle);
  void place(Square square);
  void place(IShape shape);
}
