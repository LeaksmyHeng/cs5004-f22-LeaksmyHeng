package Question8;

import java.time.Year;
import java.util.ArrayList;
import java.util.List;

public class Pair<X, Y> {
  private final X first;
  private final Y second;

  public Pair(X first, Y second) {
    this.first = first;
    this.second = second;
  }

  public X getfirst() {
    return this.first;
  }

  public Y getsecond() {
    return this.second;
  }

  public static <X,Y> Pair<X,Y> create(X first, Y second) {
    return new Pair<>(first, second);
  }

  public static <X,Y> List<Pair<X,Y>> createListOfPairs(List<X> xs, List<Y> ys){
    List<Pair<X, Y>> result = new ArrayList<>();
    if (xs.size() > ys.size() || xs.size() < ys.size()) {
      throw new IllegalArgumentException("The size of xs and ys are not the same.");
    }
    else {
      // same size of xs and ys
      for (int i = 0; i < xs.size(); i++) {
        result.add(Pair.create(xs.get(i), ys.get(i)));
      }
      return result;
    }
  }
}
