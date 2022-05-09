package employee;

/**
 * Create a salariedy paycheck class.
 */
public class SalariedPaycheck extends AbstractPaycheck implements IPaycheck {

  /**
   * Create a constructor for SalariedPaycheck class.
   */
  public SalariedPaycheck(double payRate, int payInterval) {
    super(payRate, payInterval);
  }
}
