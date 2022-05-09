package employee;

/**
 * Create an interface for employee class.
 */
public interface IEmployee {
  /**
   * Check whether the employee is a manager.
   */
  boolean isManager();

  /**
   * Create a method to check employee's paycheck.
   */
  IPaycheck getPaycheck();
}
