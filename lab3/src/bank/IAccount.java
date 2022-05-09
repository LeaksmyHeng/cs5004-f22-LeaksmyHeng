package bank;

/**
 * Create an Interface which will be used by Saving and Checking account.
 */
public interface IAccount {
  /**
   * Create a deposit method for the bank.
   */
  void deposit(double amount);

  /**
   * Create a withdrawal method for the bank.
   */
  boolean withdraw(double amount);

  /**
   * Create a getter method to get balance of both Saving and Checking Account.
   */
  double getBalance();

  /**
   * Create a monthly maintenance fee for both Saving and Checking Account. The behaviour of the two
   * various:
   * Checking: deduct $5 if the balance is lower than $100 at any time during month.
   * Saving: deduct $14 if the number of withdraw per the month is greater than 6.
   */
  void performMonthlyMaintenance();
}
