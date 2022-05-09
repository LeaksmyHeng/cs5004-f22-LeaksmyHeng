import org.junit.Before;
import org.junit.Test;

import employee.Employee;

/**
 * This is a test for Employee class.
 */
public class testEmployee {
  Employee leaksmy;
  Employee daniel;
  Employee peter;
  Employee joyce;
  Employee rana;
  Employee pisey;

  /**
   * Set up test for Employee class.
   */
  @Before
  public void setUp() {
    leaksmy = new Employee("Leaksmy Heng", "E00001", 85000.00, 2, false);
    daniel = new Employee("Daniel Kelley", "E0002", 87000.00, 1, false);
    peter = new Employee("Peter Southland", "M0001", 115000.00, 2, true);
    joyce = new Employee("Joyce", "E0004", 32.25, 49);
    rana = new Employee("Rana", "E0005", 27.99, 40);
    pisey = new Employee("Pisey", "E0006", 31.00, 35);
  }

  /**
   * Test illegal argument for Employee class.
   */
  @Test(expected = IllegalArgumentException.class)
  public void illegalEmployeeNameID() {
    Employee illegal1 = new Employee("", "E0009", 31.00, 35);
    Employee illegal2 = new Employee("Italo", "", 32.99, 25);
    Employee illegal3 = new Employee("Me", "", 85000.00, 2, false);
    Employee illegal4 = new Employee("", "E0002", 87000.00, 1, false);
  }
}
