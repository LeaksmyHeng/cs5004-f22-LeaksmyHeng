package iterator;

import java.util.Iterator;

public class ShapeCollection implements Iterable<IShape> {
  private int size;
  private int start, end;
  IShape[] shapes;

  public ShapeCollection(int size) {
    shapes = new IShape[size];
    this.start = 0;
    this.end = size;
    this.size = size;
    for (int i = 0; i < size; i++) {
      shapes[i] = new SimpleCircle(i); // for this example
    }
  }

  @Override
  public Iterator<IShape> iterator() {
    return new ShapeIterator();
  }

  private class ShapeIterator implements Iterator<IShape> {
    private int counter;

    public ShapeIterator() {
      this.counter = 0;
    }

    @Override
    public boolean hasNext() {
      if (this.counter >= end) {
        return false;
      }
      return true;
    }

    @Override
    public IShape next() {
      IShape val = shapes[this.counter];
      this.counter++;
      return val;
    }
  }

    private class ReverseShapeIterator implements Iterator<IShape> {
      private int counter;

      public ReverseShapeIterator() {
        this.counter = end - 1;
      }

      @Override
      public boolean hasNext() {
        if (this.counter >= 0) {
          return true;
        }
        return false;
      }

      @Override
      public IShape next() {
        IShape val = shapes[this.counter];
        this.counter--;
        return val;
      }
    }

    public Iterator<IShape> reverse_iterator() {
      return new ReverseShapeIterator();
    }

    public static void main(String[] args) {
      ShapeCollection sc = new ShapeCollection(10); // Java will autobox for us
      Iterator<IShape> it = sc.iterator();
      while (it.hasNext()) {
        System.out.println(it.next().getArea());
      }

      Iterator<IShape> rit = sc.reverse_iterator();
      while (rit.hasNext()) {
        System.out.println(rit.next().getArea());
      }
    }
  }
