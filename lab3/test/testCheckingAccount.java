import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import bank.CheckingAccount;
import org.junit.Before;
import org.junit.Test;

/**
 * This is a test for Checking Account.
 */
public class testCheckingAccount {
  CheckingAccount leaksmy;
  CheckingAccount daniel;
  CheckingAccount peter;

  /**
   * Setting up test for Checking Account.
   */
  @Before
  public void setUp() {
    leaksmy = new CheckingAccount(200.00);
    daniel = new CheckingAccount(100.00);
    peter = new CheckingAccount(50.00);
  }

  /**
   * Create a test for the get balance.
   */
  @Test
  public void testGetBalance() {
    assertEquals(200.00, leaksmy.getBalance(), 0.01);
    assertEquals(100.00, daniel.getBalance(), 0.01);
    assertEquals(50.00, peter.getBalance(), 0.01);
  }

  /**
   * Create Illegal argument for Starting a Saving Account.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testIllegalStarterAmount() {
    CheckingAccount badSavingAmount = new CheckingAccount(0.005);
  }

  /**
   * Create Illegal argument for Starting a Saving Account.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testIllegalStarterAmount2() {
    CheckingAccount badSavingAmount = new CheckingAccount(0.00999);
  }

  /**
   * Create a withdrawal test.
   */
  @Test
  public void testWithdraw() {
    assertTrue(leaksmy.withdraw(10.00));
    assertFalse(peter.withdraw(190.00));
    assertFalse(daniel.withdraw(150.00));
    leaksmy.deposit(10.00);
    assertFalse(leaksmy.withdraw(-120.00));
    assertEquals(200.00, leaksmy.getBalance(), 0.01);
    assertEquals(50.00, peter.getBalance(), 0.01);
    assertEquals("$200.00", leaksmy.toString());
  }

  /**
   * Create a withdrawal with penalty test.
   */
  @Test
  public void testWithdrawWithPenalty() {
    assertTrue(leaksmy.withdraw(110.00));
    leaksmy.deposit(100.00);
    assertEquals(190.00, leaksmy.getBalance(), 0.01);
    leaksmy.performMonthlyMaintenance();
    assertEquals(185.00, leaksmy.getBalance(), 0.01);
    assertTrue(leaksmy.withdraw(185.00));
    leaksmy.performMonthlyMaintenance();
    assertEquals("-$5.00", leaksmy.toString());
  }
}
