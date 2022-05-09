package employee;

import java.text.DecimalFormat;

/**
 * Create the SalariedPaycheck class that adhere to the IPaycheck interface.
 */
public class SalariedPaycheck implements IPaycheck {
  private double payRate;
  private double payInterval;

  private final double MINIMUM_PAYRATE = 0.00;

  /**
   * Create a constructor for SalariedPaycheck class.
   */
  public SalariedPaycheck(double payRate, double payInterval) {
    this.payRate = payRate;
    this.payInterval = payInterval;

    if (payRate < MINIMUM_PAYRATE) {
      throw new IllegalArgumentException("Pay rate cannot be less than 0");
    }
  }

  @Override
  public double getTotalPay() {
    double totalPay = MINIMUM_PAYRATE;
    int fullWeek = 52;
    int weekly = 1;
    if (this.payInterval == weekly) {
      totalPay = (this.payRate / fullWeek);
    }
    int BI_WEEKLY = 2;
    if (this.payInterval == BI_WEEKLY) {
      totalPay = (this.payRate / fullWeek) * BI_WEEKLY;
    }
    int QUAD_WEEKLY = 4;
    if (this.payInterval == QUAD_WEEKLY) {
      totalPay = (this.payRate / fullWeek) * QUAD_WEEKLY;
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
   * Create a two string method for Salaried Paycheck.
   */
  public String toString() {
    DecimalFormat dec = new DecimalFormat("$ 0.00");
    return  "Payment after taxes: " + dec.format(getPayAfterTaxes());
  }
}
