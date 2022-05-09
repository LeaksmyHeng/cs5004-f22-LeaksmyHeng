package employee;

/**
 * Create an Employee class that represents both hourly and salaried employee.
 */
public class Employee extends AbstractEmployee implements IEmployee {
  private IPaycheck paycheck;
  private static boolean isManager = false;

  /**
   * Create a constructor for Employee class. This constructor is for the Salaried Employee.
   */
  public Employee(String name, String id, double payRate, int payInterval, boolean isManager) {
    super(name, id, payRate, payInterval, isManager);
    paycheck = new SalariedPaycheck(this.getPayRate(), this.payInterval());
  }

  /**
   * Create a constructor for Employee Class. This constructor is for the Hourly Employee.
   */
  public Employee(String name, String id, double payRate, double hoursWorked) {
    super(name, id, payRate, hoursWorked);
    paycheck = new HourlyPaycheck(this.getPayRate(), this.getHoursWorked());
    boolean isManager = isManager();
    isManager = false;
  }

  @Override
  public IPaycheck getPaycheck() {
    return paycheck;
  }

  /**
   * Create a toString method for Employee class.
   */
  public String toString() {
    return "Name: " + this.getName() + "\n"
            + "ID: " + this.getId() + "\n"
            + this.getPaycheck().toString();
  }
}

