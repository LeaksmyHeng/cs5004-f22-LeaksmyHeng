package shapes;
import java.util.Arrays;

public class Square extends AbstractShape implements IShape {
  private double length;

  public Square(double length) {
    super(0,0);
    this.length = length;
  }

  @Override
  public double getPerimeter() {
    return 4 * this.length;
  }

  @Override
  public String toString() { return "Square with length of " + this.length; }

  @Override
  public double getArea() {
    return this.length * this.length;
  }
  public static void main(String [] args) {
    IShape shape = new Circle(2);
    System.out.println(shape.getArea());
    shape = new Square(2);
    System.out.println(shape.getArea());
    Circle [] circles = {new Circle(18), new Circle(11), new Circle(2)};
    System.out.println(Arrays.toString(circles));
    Arrays.sort(circles);
    System.out.println(Arrays.toString(circles));
  }

  @Override
  public int compareTo(AbstractShape o) {
    return 0;
  }
}
