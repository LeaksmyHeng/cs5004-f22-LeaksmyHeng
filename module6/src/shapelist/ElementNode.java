package shapelist;

import othershapes.IShape;

public class ElementNode implements IListShape {
  private final IShape data;
  private final IListShape rest;

  public ElementNode(IShape data, IListShape rest) {
    if(data == null) {
      throw new IllegalArgumentException("Can't be null data");
    }
    if(rest == null) {
      throw new IllegalArgumentException("Rest can't be null");
    }
    this.data = data;
    this.rest = rest;
  }

  @Override
  public int count() {
    return 1 + rest.count();
  }

  @Override
  public int countAcc() {
    return rest.countHelper(1);
  }

  @Override
  public int countHelper(int accumulator) {
    return rest.countHelper(1 + accumulator);
  }

  @Override
  public String toString() {
    return "(" + this.data.toString() + ")" + this.rest.toString();
  }

  @Override
  public IListShape smallerThan(double area) {
    if(this.data.getArea() < area) {
      return new ElementNode(this.data, this.rest.smallerThan(area));
    }
    return this.rest.smallerThan(area); // otherwise return rest of list w/o us
  }

  @Override
  public IListShape sortByAreaSize() {
    IListShape sorted = this.rest.sortByAreaSize();
    return sorted.insert(this.data);
  }

  @Override
  public IListShape insert(IShape shape) {
    if(shape.getArea() < this.data.getArea()) {
      return new ElementNode(shape, this); // if area is smaller than us
    }
    return new ElementNode(this.data, this.rest.insert(shape));
  }
}
