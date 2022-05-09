package distance;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import org.junit.Before;
import org.junit.Test;

/**
 * This is a test for Point3D class.
 */
public class testPoint3D {
  private Point3D point1;
  private Point3D point2;
  private Point3D point3;
  private Point3D point4;

  /**
   * Setting up the Point3D test.
   */
  @Before
  public void setUp() {
    point1 = new Point3D( 3, 4, 5);
    point2 = new Point3D(-1, -5, 7);
    point3 = new Point3D(-9, 9, 0);
    point4 = new Point3D();
  }

  /**
   * Create a test for the getter method.
   */
  @Test
  public void testGetXGetYGetZ() {
    assertEquals(3, point1.getX());
    assertEquals(-1, point2.getX());
    assertEquals(-9, point3.getX());
    assertEquals(4, point1.getY());
    assertEquals(-5, point2.getY());
    assertEquals(9, point3.getY());
    assertEquals(5, point1.getZ());
    assertEquals(7, point2.getZ());
    assertEquals(0, point3.getZ());
    assertEquals(0, point4.getX());
    assertEquals(0, point4.getY());
    assertEquals(0, point4.getZ());
  }

  /**
   * Create a test for distanceTo method.
   */
  @Test
  public void testDistanceTo() {
    Point3D otherPointer1 = new Point3D(3, 4, 5);
    Point3D otherPointer2 = new Point3D(2, 5, 7);
    Point3D otherPointer3 = new Point3D(-1, 5, -2);
    assertEquals(0.0f, point1.distanceTo(otherPointer1), 0.01);
    assertEquals(10.44f, point2.distanceTo(otherPointer2),0.01);
    assertEquals(9.16f, point3.distanceTo(otherPointer3),0.01);
  }

  /**
   * Create a test for equals method.
   */
  @Test
  public void testNotEqual() {
    Point3D localPoint3D = new Point3D(3, 4, 0);
    assertNotEquals(localPoint3D, point1);
  }

  /**
   * Create a test for equals method.
   */
  @Test
  public void testEqual() {
    Point3D localPoint3D = new Point3D(3, 4, 5);
    assertEquals(localPoint3D, point1);
  }
}
