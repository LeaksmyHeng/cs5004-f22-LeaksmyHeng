package distance;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * Create a test for Physic class.
 */
public class testPhysics {

  /**
   * Test velocity method.
   */
  @Test
  public void testVelocity() {
    Point3D point1 = new Point3D( 3, 4, 5);
    Point3D point2 = new Point3D(-1, -5, 7);
    Point3D point3 = new Point3D(2, 5, 7);
    assertEquals(5.22f, Physics.velocity(point3, point2, 2.0), 0.01);
    assertEquals(0.0f, Physics.velocity(point1, point1, 2.1), 0.01);
    assertEquals(2.44f, Physics.velocity(point1, point3, 1), 0.01);
  }

  /**
   * Test velocity method with negative elapsed time.
   */
  @Test (expected = IllegalArgumentException.class)
  public void testIllegalVelocity() {
    Point3D point1 = new Point3D();
    Point3D point2 = new Point3D(-1, -5, 7);
    Physics.velocity(point1, point2, -0.01);
  }

  /**
   * Test velocity method with 0 elapsed time.
   */
  @Test (expected = IllegalArgumentException.class)
  public void testIllegalVelocity2() {
    Point3D point1 = new Point3D();
    Point3D point2 = new Point3D(1, 5, 7);
    Physics.velocity(point1, point2, 0.0);
  }
}
