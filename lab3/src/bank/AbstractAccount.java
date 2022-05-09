package bank;

import java.text.DecimalFormat;

/**
 * Create an abstract class for every bank account. The only attributes would be balance.
 */
public abstract class AbstractAccount implements IAccount {
  double balance;

  /**
   * Create an abstract constructor which take amount as an argument. The amount will check
   * the starter amount across bank type.
   */
  public AbstractAccount(double amount) throws IllegalArgumentException {
    if (amount < 0.01) {
      throw new IllegalArgumentException("Starter amount needs to be greater than 1 cent");
    }
    this.balance = amount;
  }

  protected double depositAmount(double amount) throws IllegalArgumentException {
    if (amount < 0) {
      throw new IllegalArgumentException("Deposit amount needs to be greater than 1 cent");
    }
    balance = this.getBalance() + amount;
    return balance;
  }

  /**
   * Create a toString method for both account: saving and checking.
   */
  public String toString() {
    DecimalFormat moneyFormat = new DecimalFormat("$0.00");
    return moneyFormat.format(this.getBalance());
  }
}
