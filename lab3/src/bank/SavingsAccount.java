package bank;

import java.text.DecimalFormat;

/**
 * Create a SavingAccount class which implement every method under IAccount.
 */
public class SavingsAccount extends AbstractAccount implements IAccount {
  private int numberOfWithdraw;
  private double penaltyTransaction;
  private double withdrawAmount;

  /**
   * Create a constructor for SavingAccounts which take starterAmount as the parameter.
   * Initialze numberOfWithdraw and penaltyTransaction to 0.
   */
  public SavingsAccount(double starterAmount) {
    super(starterAmount);
    this.numberOfWithdraw = 0;
    this.penaltyTransaction = 0.00;
    this.withdrawAmount = 0.00;
  }

  @Override
  public void deposit(double amount) {
    this.depositAmount(amount);
  }

  @Override
  public boolean withdraw(double amount) {
    this.numberOfWithdraw = this.numberOfWithdraw + 1;
    int totalWithdrawPerMonth = 6;
    double penaltyFee = 14.00;

    if (amount > withdrawAmount) {
      if ((amount <= this.getBalance()) && (numberOfWithdraw <= totalWithdrawPerMonth)) {
        balance = this.getBalance() - amount;
        return true;
      }
      else if ((amount <= this.getBalance()) && (numberOfWithdraw > totalWithdrawPerMonth)) {
        this.penaltyTransaction = penaltyFee;
        balance = this.getBalance() - amount;
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
    balance = this.getBalance() - this.penaltyTransaction;
    this.penaltyTransaction = 0.00;
  }
}
