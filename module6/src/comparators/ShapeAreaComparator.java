package comparators;

import java.util.Comparator;

import othershapes.IShape;

public class ShapeAreaComparator implements Comparator<IShape> {
    @Override
    public int compare(IShape shape1, IShape shape2) {
      if (shape1.getArea() == shape2.getArea())
        return 0;
      else if (shape1.getArea() > shape2.getArea())
        return 1;
      else
        return -1;
    }
}
