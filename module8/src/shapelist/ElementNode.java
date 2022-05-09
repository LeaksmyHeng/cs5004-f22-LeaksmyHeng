package shapelist;

import othershapes.IShape;

public class ElementNode implements IListShape {
  private final IShape data;
  private final IListShape rest;

  public ElementNode(IShape data, IListShape rest) {
    if(data == null) {
      throw new IllegalArgumentException("Data can't be null");
    }
    if(rest == null) {
      throw new IllegalArgumentException("Rest can't be null");
    }
    this.data = data;
    this.rest = rest;
  }

  @Override
  public int count() { // traditional recursion
    return 1 + this.rest.count();
  }

  @Override
  public String toString() {
    return "(" + this.data.toString() + ")" + this.rest.toString();
  }

  @Override
  public int countAcc() {
    return this.rest.countHelper(1);
  }

  @Override
  public int countHelper(int accumulator) {
    return this.rest.countHelper(1 + accumulator);
  }

  @Override
  public IListShape smallerThan(double area) { // filter method
    if(this.data.getArea() < area) { // we fit the criteria for inclusion
      return new ElementNode(this.data, this.rest.smallerThan(area));
    }
    return this.rest.smallerThan(area);
  }

  @Override
  public IListShape sortByAreaSize() {
    IListShape sorted = this.rest.sortByAreaSize();
    return sorted.insert(this.data);
  }

  @Override
  public IListShape insert(IShape shape) { // insertion sort
    if(shape.getArea() < this.data.getArea()) {
      return new ElementNode(shape,this);
    }
    return new ElementNode(this.data, this.rest.insert(shape));
  }
}
