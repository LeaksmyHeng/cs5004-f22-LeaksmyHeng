package othershapes;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import comparators.LessArea;
import comparators.ShapeAreaComparator;
import soliddesign.Canvas;

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
  public double getArea() {
    return this.length * this.length;
  }

  @Override
  public String toString() { return "Square with length of " + this.length; }

  @Override
  public void placedBy(Canvas canvas) {
    canvas.place(this);
  }

  public static void main(String [] args) {
    IShape shape = new Circle(2);
    System.out.println(shape.getArea());
    shape = new Square(2);
    System.out.println(shape.getArea());
    Circle[] circles = {new Circle(18), new Circle(11), new Circle(2)};
    System.out.println(Arrays.toString(circles));

    System.out.println("\n---- Use our Comparator to sort the Array ----");
    Arrays.sort(circles, new ShapeAreaComparator());
    System.out.println(Arrays.toString(circles));

    System.out.println("\n---- Using our Predicate ---");
    LessArea predicate = new LessArea(20);
    List<IShape> shapeList = new ArrayList<>();
    for (Circle circle :
            circles ) {
      shapeList.add(circle); // 2nd step. Add to list

      if(predicate.test(circle)) {  // if( circle.getArea() < 20) // blah
        System.out.println(circle);
      }
    }
    shapeList.add(new Square(2));

    System.out.println("\n---- Using List comparator & predicate for filter HOF ----");
    // List<IShape> result = shapeList.stream().filter(predicate).collect(Collectors.toList());
    List<IShape> result = shapeList.stream().filter(iShape -> iShape.getArea() < 20).collect(Collectors.toList());

    System.out.println(result.toString());

    System.out.println("\n---- Using List Map and Reduce to get a single value ----");

    // map and reduce. First map the shapes 1-1 to their areas
    List<Double> areas = shapeList.stream()
            .map(s->s.getArea())
            .collect(Collectors.toList());
    // Now we have a list of areas (Double). Add them together to get a single value
    Double total = areas.stream().reduce(0.0, (one, two) -> one + two);
    System.out.println("Total =  " + total);
  }

}
