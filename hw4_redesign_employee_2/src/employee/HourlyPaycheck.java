package employee;

/**
 * Create an Hourly paycheck class.
 */
public class HourlyPaycheck extends AbstractPaycheck implements IPaycheck {
  private static final float FULLTIME = 40.00F;

  /**
   * Create a constructor for hourly work which take 2 parameters payRate and hoursWorked.
   */
  public HourlyPaycheck(double payRate, double hoursWorked) {
    super(payRate, hoursWorked);
  }

  @Override
  public double getTotalPay() {
    double totalPay = 0.0;
    if (this.getHoursWorked() > FULLTIME) {
      totalPay = (this.getHoursWorked() - FULLTIME) * 1.5 * getPayRate() + FULLTIME * getPayRate();
    }
    else if (this.getHoursWorked() <= FULLTIME) {
      totalPay = getPayRate() * this.getHoursWorked();
    }
    return totalPay;
  }
}
