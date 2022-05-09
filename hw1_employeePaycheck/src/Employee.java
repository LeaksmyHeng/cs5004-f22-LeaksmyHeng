/**
* This class represents a single hourly employee which include their name, their id, hoursworked
* and pay rate.
*/
public class Employee {
  private String name;
  private String employeeID;
  private double hoursWorked;
  private double payRate;

  /**
   * Constructs an Employee object and initializes it to the given employeeName,
   * employeeID, and payRate.
   *
   * @param name  the name of the employee
   * @param employeeID    the ID of the employee
   * @param payRate       the employee's pay rate
   */
  public Employee(String name, String employeeID, double payRate) {
    this.name = name;
    this.employeeID = employeeID;
    this.hoursWorked = 0.0;
    this.payRate = payRate;
  }

  /**
   * Create addHoursWorked method.
   *
   * @return the added working hour
   */
  public double addHoursWorked(double addHoursWorked) {
    this.hoursWorked = this.hoursWorked + addHoursWorked;
    // if the add hours is below 0.0 then reset it to 0
    if (this.hoursWorked <= 0.0) {
      this.hoursWorked = resetHoursWorked();
    }
    return this.hoursWorked;
  }

  /**
   * Create a method that reset the hour work to 0 again.
   *
   * @return 0.0 to hourwork
   */
  public double resetHoursWorked() {
    return this.hoursWorked = 0.0;
  }

  /**
   * Get the working hours of the employee.
   *
   * @return the working hour of the employee
   */
  public double getHoursWorked() {
    return this.hoursWorked;
  }

  /**
   * Create a method to get weekly check.
   *
   * @return the new Paycheck object
   */
  public Paycheck getWeeklyCheck() {
    Paycheck paycheck = new Paycheck(this.payRate, this.hoursWorked);
    return paycheck;
  }

  /**
   * Create toString method for Employee class.
   *
   * @return employee's name, id and their payment after tax
   */
  @Override
  public String toString() {
    return "Name: " + name + "\n"
            + "ID: " + employeeID + "\n"
            + this.getWeeklyCheck().toString();
  }
}
