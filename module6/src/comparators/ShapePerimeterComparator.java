package comparators;

import java.util.Comparator;

import othershapes.IShape;

public class ShapePerimeterComparator implements Comparator<IShape> {
  public int compare(IShape shape1, IShape shape2) {
    // alternate approach
    return Double.compare(shape1.getPerimeter(), shape2.getPerimeter());
  }
}
