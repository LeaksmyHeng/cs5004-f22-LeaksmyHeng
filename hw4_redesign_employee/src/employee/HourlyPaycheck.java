package employee;

import java.text.DecimalFormat;

/**
 * Create the hourly paycheck class that adhere to the IPaycheck interface.
 */
public class HourlyPaycheck implements IPaycheck {
  private double payRate;
  private double hoursWorked;
  private static final float FULLTIME = 40.00F;
  private static final float PAYTHRESHOLD = 400.00F;
  private static final float NORMALTAXAFTERDEDUCT = 0.90F;
  private static final float HIGHERTAXAFTERDEDUCT = 0.85F;

  /**
   * Create a constructor for hourly work which take 2 parameters payRate and hoursWorked.
   */
  public HourlyPaycheck(double payRate, double hoursWorked) throws IllegalArgumentException {
    this.payRate = payRate;
    this.hoursWorked = hoursWorked;

    if (payRate < 0) {
      throw new IllegalArgumentException("Pay rate cannot be less than 0");
    }
  }

  /**
   * Create a method that is used to reset the hour work to 0.0.
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

  /**
   * Create a class to get the total number of hour work.
   */
  public double getHoursWorked() {
    return this.hoursWorked;
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

  @Override
  public double getPayAfterTaxes() {
    double getTotalPay = getTotalPay();
    double payAfterTax = 0.0;
    double payThreshold = 400;
    double maxTax = 0.85;
    double minTax = 0.90;
    if (getTotalPay < payThreshold) {
      double afterTaxMinimum = minTax;
      payAfterTax = afterTaxMinimum * getTotalPay;
    }
    else if (getTotalPay >= payThreshold) {
      double afterTaxMaximum = maxTax;
      payAfterTax = getTotalPay * afterTaxMaximum;
    }
    if ((zeroCent < payAfterTax) && (payAfterTax < oneCent)) {
      payAfterTax = oneCent;
    }
    return payAfterTax;
  }

  @Override
  public double getPayRate() {
    return this.payRate;
  }

  /**
   * Create a toString method for Hourly Paycheck class.
   */
  public String toString() {
    DecimalFormat dec = new DecimalFormat("$ 0.00");
    return  "Payment after taxes: " + dec.format(getPayAfterTaxes());
  }
}
