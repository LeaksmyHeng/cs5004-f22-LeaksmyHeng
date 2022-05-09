package employee;

/**
 * Create an abstract class for every employee type.
 */
public abstract class AbstractEmployee implements IEmployee {
  private String name;
  private String id;
  private double payRate;
  private int payInterval;
  private double hoursWorked;
  private boolean isManager;

  /**
   * Create a constructor for salaried employee.
   */
  public AbstractEmployee(String name, String id, double payRate, int payInterval,
                          boolean isManager) throws IllegalArgumentException {
    this.name = name;
    this.id = id;
    this.payRate = payRate;
    this.payInterval = payInterval;
    this.isManager = isManager;

    if (name == null || id == null || name.length() == 0 || id.length() == 0) {
      throw new IllegalArgumentException("Name or ID cannot be null in salaried employee.");
    }
  }

  /**
   * Create a constructor for hourly employee.
   */
  public AbstractEmployee(String name, String id, double payRate, double hoursWorked)
          throws IllegalArgumentException {
    this.name = name;
    this.id = id;
    this.payRate = payRate;
    this.hoursWorked = hoursWorked;

    double payRateZero = 0.0;
    double hoursWoredZero = 0.0;
    if (name == null || id == null || name == "" || id == "") {
      throw new IllegalArgumentException("Name or ID cannot be null in hourly employee.");
    }
    if (payRate < payRateZero || hoursWorked <= hoursWoredZero) {
      throw new IllegalArgumentException("Hourworks and payrate cannot be negative.");
    }
  }

  public boolean isManager() {
    return this.isManager;
  }

  /**
   * Create a getter method to receive the employee name.
   */
  public String getName() {
    return this.name;
  }

  /**
   * Create a getter method to retrieve employee id.
   */
  public String getId() {
    return this.id;
  }

  /**
   * Create a getter method to retrieve the payrate.
   */
  public double getPayRate() {
    return this.payRate;
  }

  /**
   * Create a getter method to retrieve the payInterval.
   */
  public int payInterval() {
    return this.payInterval;
  }

  /**
   * Create a getter method to retrieve the hourwork.
   */
  public double getHoursWorked() {
    return this.hoursWorked;
  }
}
