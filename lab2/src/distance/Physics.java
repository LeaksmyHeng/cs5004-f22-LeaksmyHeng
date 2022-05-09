package distance;

/**
 * Create a class called Physics. This class is a utility service class and only provide 1 method.
 */
public class Physics {

  /**
   * Create a public class called velocity to calculate a unitless velocity given two Point3D
   * and an elapsed time.
   */
  public static double velocity(Point3D one, Point3D two, double elapsedTime)
          throws IllegalArgumentException {
    if (elapsedTime <= 0.0) {
      throw new IllegalArgumentException("Elapsed time for velocity cannot be "
              + "less than or equal to 0");
    }
    return two.distanceTo(one) / elapsedTime;
  }

  /**
   * Main method is used to calcuate distance and velocity.
   */
  public static void main(String [] args) {
    try {
      Point3D one = new Point3D();
      Point3D two = new Point3D(1,1,1);
      System.out.println("Displacement = " + one.distanceTo(two));
      double velocity = Physics.velocity(one, two, 0);
      System.out.println("Prof. Keith is on the move! His Velocity =" + velocity);
      velocity = Physics.velocity(one, two, 5);
      System.out.println("Velocity =" + velocity);
    }
    catch (IllegalArgumentException e) {
      System.out.println("Encountered an error: " + e.getMessage());
    }
  }
}
