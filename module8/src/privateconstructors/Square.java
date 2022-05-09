package privateconstructors;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.function.Function;

public class Square extends AbstractShape implements IShape {
  private double length;

  private Square(double length) {
    super(0,0);
    this.length = length;
  }

  public static IShape create(double value) { return new Square(value); }

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
    // create our map of factory methods
    Map<String, Function<Double, IShape>> factoryMethods = new HashMap<>();
    factoryMethods.put("SQUARE", Square::create);
    factoryMethods.put("CIRCLE", Circle::create);

    String [] shapesToCreate = {"Circle", "circle", "SQUARE", "square", "CiRclE", "Triangle"};
    double value = 1.5;
    for (String string : shapesToCreate ) {
      try {
        Function<Double, IShape> function = factoryMethods.get(string.toUpperCase());
        IShape shape = function.apply( value );
        value = value + 1;
        System.out.println("Created " + shape );
      }
      catch(Exception e) {
        System.out.println("Could not find appropriate factory method for " + string);
      }
    }
  }

  @Override
  public int compareTo(AbstractShape o) {
    return 0;
  }
}
