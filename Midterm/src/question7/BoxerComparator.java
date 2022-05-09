package question7;

import java.util.Comparator;

public class BoxerComparator implements Comparator<Boxer> {
  @Override
  public int compare(Boxer b1, Boxer b2) {
    return Double.compare(b1.getWeight(), b2.getWeight());
  }
}
