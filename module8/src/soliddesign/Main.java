package soliddesign;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import othershapes.*;

public class Main {

  public static void singleDispatch() {
    Canvas canvas = new ScrollCanvas();
    List<IShape> shapes = new ArrayList<>();
    shapes.add( new Circle(2));
    shapes.add(new Square(3));
    for (IShape shape : shapes) {
      canvas.place(shape);
    }
    // canvas.place(new Circle(2));
  }

  public static void doubleDispatch() {
    Canvas canvas = new FramedCanvas();
    List<IShape> shapes = new ArrayList<>();
    shapes.add( new Circle(2));
    shapes.add(new Square(3));
    Iterator<IShape> iterator = shapes.iterator();
    /*
    for (IShape shape : shapes) {
      shape.placedBy(canvas);
    }
     */
    while(iterator.hasNext()) {
      iterator.next().placedBy(canvas);
    }
    // canvas.place(new Circle(2));
  }

  public static void showIterator() {
    Collection<String> cities = new ArrayList<>();
    cities.add("New York");
    cities.add("Beijing");
    cities.add("Mumbai");
    cities.add("London");
    cities.add("Nairobi");

    Iterator<String> iterator = cities.iterator();
    Iterator<String> otherIterator = cities.iterator(); // can have > 1

    otherIterator.next();
    otherIterator.next();
    while(iterator.hasNext()) {
      System.out.print(iterator.next().toUpperCase() + " - ");
    }
    System.out.println("\n\nNow show where the other iterator is at: ");
    System.out.println(otherIterator.next());
  }
  public static void main(String [] args) {
    System.out.println("Single Dispatch");
    singleDispatch();
    System.out.println("\nNow Double Dispatch");
    doubleDispatch();
    showIterator();
  }
}
