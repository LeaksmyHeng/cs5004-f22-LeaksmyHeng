package employee;

/**
 * Create an interface for paycheck class.
 */
public interface IPaycheck {
  /**
   * A method to get the total pay.
   */
  double getTotalPay();

  /**
   * A method to get the paycheck after tax is deducted.
   */

  double getPayAfterTaxes();

  /**
   * A method to get the payrate.
   */
  double getPayRate();

  /**
   * Declare a one cent variable.
   */
  double oneCent = 0.01;

  /**
   * Declare a zero cent variable.
   */
  double zeroCent = 0.00;
}
