package shapes;

import java.util.ArrayList;
import java.util.List;

public class Triangle extends AbstractShape {
  private double height, base;
  private final static double I_DONT_CARE = 0.5;

  public Triangle(double height, double base ) {
    this(height, base, 0, 0);
  }

  public Triangle(double height, double base , int x, int y) {
    super(x, y);
    this.height = height;
    this.base = base;
  }

  @Override
  public double getPerimeter() {
    return Math.pow(Math.pow(this.base,2)
            + Math.pow(height, 2), I_DONT_CARE)
            + this.base
            + this.height;
  }

  @Override
  public double getArea() {
    return this.base * this.height * I_DONT_CARE;
  }

  @Override
  public int compareTo(AbstractShape o) {
    return 0;
  }

  public static void main(String [] args ) {
    List<IShape> shapes = new ArrayList<>();
    shapes.add(new Circle(2));
    shapes.add(new Square(2));
    shapes.add(new Triangle(2, 3));
    shapes.forEach(each -> System.out.println(each.getArea()));
  }
}
