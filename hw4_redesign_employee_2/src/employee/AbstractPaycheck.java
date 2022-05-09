package employee;

import java.text.DecimalFormat;

/**
 * Create an abstract class for both SalariedPaycheck and HourlyPaycheck. The abstract class
 * implement the IPaycheck interface.
 */
public abstract class AbstractPaycheck implements IPaycheck {
  private double payRate;
  private int payInterval;
  private double hoursWorked;
  private final double MINIMUM_VALUE = 0.0;

  /**
   * Create the constructor for SalariedPaycheck.
   */
  public AbstractPaycheck(double payRate, int payInterval) throws IllegalArgumentException {
    this.payRate = payRate;

    if (payRate < MINIMUM_VALUE) {
      throw new IllegalArgumentException("Payrate cannot be less than 0.");
    }
    if (payInterval == 1 || payInterval == 2 || payInterval == 4) {
      this.payInterval = payInterval;
    }
    else {
      throw new IllegalArgumentException("Pay interval is out of scope.");
    }
  }

  /**
   * Create the constructor for HourlyPaycheck.
   */
  public AbstractPaycheck(double payRate, double hoursWorked) {
    this.payRate = payRate;
    this.hoursWorked = hoursWorked;

    if (payRate < MINIMUM_VALUE || hoursWorked < MINIMUM_VALUE) {
      throw new IllegalArgumentException("Pay rate or hours worked cannot be less than 0.");
    }
  }

  /**
   * A getter method to get the pay rate.
   */
  public double getPayRate() {
    return this.payRate;
  }

  /**
   * Create a method to calculate the Total pay for the salaried employee as we will overide the
   * hourly employee in the HourlyPaycheck class.
   */
  public double getTotalPay() {
    double totalPay = MINIMUM_VALUE;
    int fullWeek = 52;
    int weekly = 1;
    int biWeekly = 2;
    int quadWeekly = 4;
    if (this.payInterval == weekly) {
      totalPay = (this.payRate / fullWeek);
    }
    if (this.payInterval == biWeekly) {
      totalPay = (this.payRate / fullWeek) * biWeekly;
    }
    if (this.payInterval == quadWeekly) {
      totalPay = (this.payRate / fullWeek) * quadWeekly;
    }
    return totalPay;
  }

  /**
   * Create a method to calculate the paycheck after tax.
   */
  public double getPayAfterTaxes() {
    double getTotalPay = getTotalPay();
    double payAfterTax = 0.0;
    double payThreshold = 400;
    double maxTax = 0.85;
    double minTax = 0.90;
    double zeroCent = 0.00;
    double oneCent = 0.01;
    if (getTotalPay < payThreshold) {
      payAfterTax = minTax * getTotalPay;
    }
    else if (getTotalPay >= payThreshold) {
      payAfterTax = getTotalPay * maxTax;
    }
    if ((zeroCent < payAfterTax) && (payAfterTax < oneCent)) {
      payAfterTax = oneCent;
    }
    return payAfterTax;
  }

  /**
   * Create a toString method.
   */
  public String toString() {
    DecimalFormat dec = new DecimalFormat("$ 0.00");
    return  "Payment after taxes: " + dec.format(getPayAfterTaxes());
  }

  /**
   * Create a getter method to get hourworked.
   */
  public double getHoursWorked() {
    return this.hoursWorked;
  }

  /**
   * Reset hour work to 0 for employee who work hourly.
   */
  public double resetHoursWorked() {
    return this.hoursWorked = 0.0;
  }

  /**
   * Create a method that is used to add hour worked.
   */
  public double addHoursWorked(double hoursWorked) {
    this.hoursWorked = this.hoursWorked + hoursWorked;
    // if the add hours is below 0.0 then reset it to 0
    if (this.hoursWorked <= 0.0) {
      this.hoursWorked = resetHoursWorked();
    }
    return this.hoursWorked;
  }
}
