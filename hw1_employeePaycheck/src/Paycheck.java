import java.text.DecimalFormat;

/**
* This class calculates employee pay for the week.
* It includes an employee's rate and the hours worked.
*/
public class Paycheck {
  private double payRate;
  private double workingHours;
  private final int fullPay = 400;

  /**
   * Constructs a Paycheck object and initializes it to the given payRate and workingHours.
   *
   * @param payRate       the pay rate
   * @param workingHours  the working hour
   */
  public Paycheck(double payRate, double workingHours) {
    this.payRate = payRate;
    this.workingHours = workingHours;
  }

  /**
   * Create a method to calculate the total payment per week.
   *
   * @return total payment per week
   */
  public double getTotalPay() {
    double totalPay = 0.0;
    double fullTime = 40.0;
    if (this.workingHours > fullTime) {
      // (workingHours - fullTime) will give us the overtime that we need to pay out
      totalPay = (this.workingHours - fullTime) * 1.5 * this.payRate + fullTime * this.payRate;
    }
    else if (this.workingHours <= fullTime) {
      totalPay = this.payRate * this.workingHours;
    }
    return totalPay;
  }

  /**
   * Create a method to calculate the total payment after tax.
   *
   * @return total payment after tax
   */
  public double getPayAfterTaxes() {
    double getTotalPay = getTotalPay();
    double payAfterTax = 0.0;

    if (getTotalPay < fullPay) {
      // deduct 10% from the overall pay
      payAfterTax = 0.9 * getTotalPay;
    }
    else if (getTotalPay >= 400) {
      // deduct 15% from the overall pay
      payAfterTax = getTotalPay * 0.85;
    }
    if ((0.0 < payAfterTax) && (payAfterTax < 0.01)) {
      payAfterTax = 0.01;
    }
    return payAfterTax;
  }

  /**
   * Create a toString method for Paycheck class.
   *
   * @return String represent payment after tax
   * */
  @Override
  public String toString() {
    // $ ###.##
    DecimalFormat dec = new DecimalFormat("$ 0.00");
    return  "Payment after taxes: " + dec.format(getPayAfterTaxes());
  }
}
