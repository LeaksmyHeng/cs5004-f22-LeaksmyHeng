package bank;

import java.text.DecimalFormat;

/**
 * Implement a CheckingAccount class.
 */
public class CheckingAccount extends AbstractAccount implements IAccount {
  private final double MINIMUM_BALANCE = 100.00;
  private final double PENALTY_FEE = 5.00;
  private boolean penaltyApply;

  /**
   * Create a construct for CheckingAccount by taking one argument: starterAmount. Initialize the
   * penaltyTransaction to 0.
   */
  public CheckingAccount(double starterAmount) {
    super(starterAmount);
    this.penaltyApply = false;
    if (starterAmount < MINIMUM_BALANCE) {
      this.penaltyApply = true;
    }
  }

  @Override
  public void deposit(double amount) {
    this.depositAmount(amount);
    if (this.getBalance() < MINIMUM_BALANCE) {
      this.penaltyApply = true;
    }
  }

  @Override
  public boolean withdraw(double amount) {
    double minimum = 0.00;
    if (amount > minimum) {
      if (amount <= this.getBalance()) {
        balance = this.balance - amount;
        if (this.getBalance() < MINIMUM_BALANCE) {
          this.penaltyApply = true;
        }
        return true;
      }
      return false;
    }
    return false;
  }

  @Override
  public double getBalance() {
    return this.balance;
  }

  @Override
  public void performMonthlyMaintenance() {
    if (this.penaltyApply) {
      this.balance = this.getBalance() - PENALTY_FEE;
    }
  }
}
