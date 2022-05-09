package shapelist;

import othershapes.IShape;

public class EmptyNode implements IListShape {
  @Override
  public int count() {
    return 0;
  }

  @Override
  public int countAcc() {
    return countHelper(0);
  }

  @Override
  public int countHelper(int accumulator) {
    return accumulator;
  }

  @Override
  public IListShape smallerThan(double area) {
    return new EmptyNode();
  }

  @Override
  public IListShape sortByAreaSize() {
    return new EmptyNode();
  }

  @Override
  public IListShape insert(IShape shape) {
    return new ElementNode(shape, this);
  }

  @Override
  public String toString() {
    return "";
  }
}
