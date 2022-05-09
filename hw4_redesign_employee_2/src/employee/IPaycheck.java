package employee;

/**
 * Create IPaycheck interface which will be used by both SalariedPaycheck and HourlyPaycheck.
 */
public interface IPaycheck {

  /**
   * Get the total pay of the employee.
   */
  double getTotalPay();

  /**
   * Get the Pay after tax.
   */
  double getPayAfterTaxes();

  /**
   * Get the pay rate.
   */
  double getPayRate();
}
