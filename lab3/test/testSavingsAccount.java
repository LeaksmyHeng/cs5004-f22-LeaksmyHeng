import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import bank.SavingsAccount;
import org.junit.Before;
import org.junit.Test;

/**
 * This is a test for Saving Account.
 */
public class testSavingsAccount {
  SavingsAccount leaksmy;
  SavingsAccount daniel;
  SavingsAccount peter;

  /**
   * Set up test for SavingsAccount.
   */
  @Before
  public void setUp() {
    leaksmy = new SavingsAccount(100);
    daniel = new SavingsAccount(20.00);
    peter = new SavingsAccount(0.011);
  }

  /**
   * Create test for get balance.
   */
  @Test
  public void testCreateSavingAccount() {
    assertEquals(100.00, leaksmy.getBalance(), 0.01);
    assertEquals(20.00, daniel.getBalance(), 0.01);
    assertEquals(0.011, peter.getBalance(), 0.01);
  }

  /**
   * Create Illegal argument for Starting a Saving Account.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testIllegalStarterAmount() {
    SavingsAccount badSavingAmount = new SavingsAccount(0.005);
  }

  /**
   * Create Illegal argument for Starting a Saving Account.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testIllegalStarterAmount2() {
    SavingsAccount badSavingAmount = new SavingsAccount(0.00999);
  }

  /**
   * Create Illegal argument for Starting a Saving Account.
   */
  @Test
  public void testIllegalWithdraw() {
    assertFalse(leaksmy.withdraw(-10.00));
    assertTrue(leaksmy.withdraw(10.00));
  }

  /**
   * Create a withdrawal test.
   */
  @Test
  public void testWithdraw() {
    assertTrue(leaksmy.withdraw(10.00));
    assertFalse(peter.withdraw(10.00));
    assertFalse(daniel.withdraw(50.00));
    assertFalse(leaksmy.withdraw(-50.00));
    assertEquals(90.00, leaksmy.getBalance(), 0.01);
    assertEquals(0.011, peter.getBalance(), 0.01);
    assertEquals(20.00, daniel.getBalance(), 0.01);
    assertEquals("$20.00", daniel.toString());
  }

  /**
   * Create a withdrawal test that will charge penalty fee to you.
   */
  @Test
  public void testWithdrawPenalty() {
    assertTrue(leaksmy.withdraw(10.00));
    assertTrue(leaksmy.withdraw(10.00));
    assertTrue(leaksmy.withdraw(10.00));
    assertTrue(leaksmy.withdraw(10.00));
    assertTrue(leaksmy.withdraw(10.00));
    assertTrue(leaksmy.withdraw(10.00));
    assertTrue(leaksmy.withdraw(10.00));
    assertEquals(30.00, leaksmy.getBalance(), 0.01);
    leaksmy.performMonthlyMaintenance();
    assertEquals(16.00, leaksmy.getBalance(), 0.01);
    assertEquals("$16.00", leaksmy.toString());
  }

  /**
   * Create a withdrawal test that will charge penalty fee to you and make your balance negative.
   */
  @Test
  public void testWithdrawPenaltyUntilNegative() {
    assertTrue(daniel.withdraw(3.00));
    assertTrue(daniel.withdraw(2.00));
    assertTrue(daniel.withdraw(3.00));
    assertTrue(daniel.withdraw(2.00));
    assertTrue(daniel.withdraw(3.00));
    assertTrue(daniel.withdraw(2.00));
    assertTrue(daniel.withdraw(4.00));
    assertFalse(daniel.withdraw(-0.001));
    assertEquals(1.00, daniel.getBalance(), 0.01);
    daniel.performMonthlyMaintenance();
    assertEquals(-13.00, daniel.getBalance(), 0.01);
    assertEquals("-$13.00", daniel.toString());
  }
}
