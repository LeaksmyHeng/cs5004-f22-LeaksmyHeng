package shapelist;

import org.junit.Test;
import othershapes.IShape;
import othershapes.Circle;
import othershapes.Square;

import static org.junit.Assert.*;

public class IListShapeTest {
  private IShape sq, circle;
  private IListShape node1;
  private IListShape node2;
  private IListShape node3;

  public IListShapeTest() {
    sq = new Square(2);
    circle = new Circle(2);
    node1 = new ElementNode(sq, new EmptyNode());
    node2 = new ElementNode(circle, node1);
    node3 = new ElementNode(new Circle(3), node2);
  }
  @Test
  public void testCount() {
    assertEquals(3, node3.count());
    assertEquals(1, node1.count());
  }

  @Test
  public void testCountAcc() {
    assertEquals(3, node3.countAcc());
    assertEquals(1, node1.countAcc());
  }

  @Test
  public void testToString() {
    System.out.println(node3.toString());
  }

  @Test
  public void testSmallerThan() { // test the filter
    System.out.println(node3.smallerThan(20).toString());
  }

  @org.junit.Test
  public void sortByAreaSize() {
    System.out.println("Original list = " + node3.toString());
    IListShape sortedList = node3.sortByAreaSize();
    System.out.println("Sorted List = " + sortedList.toString());
  }

  @org.junit.Test
  public void insert() {
  }

}