package decorators;

import shapes.IShape;
import shapes.Circle;

public class ShapeDecorator implements IShape {
  protected IShape target;

  public ShapeDecorator(IShape target) {
    this.target = target;
  }

  public double getArea() {
    return 0;
  }

  @Override
  public double getPerimeter() {
    return 0;
  }

  public String toString() {
    return target.toString();
  }

  public static void main(String [] args) {
    IShape shape = new AsterickDecorator(new PlusDecorator(new Circle(2)));
    System.out.println(shape);
  }
}

class PlusDecorator extends ShapeDecorator {
  public PlusDecorator(IShape target) {
    super(target);
  }

  public String toString() {
    return "+++" + target + "+++";
  }
}

class AsterickDecorator extends ShapeDecorator {
  public  AsterickDecorator(IShape target) {
    super(target);
  }
  public String toString() {
    return "***" + target + "***";
  }
}