import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

/**
 * This is a test for Paycheck class.
 */
public class PaycheckTest {
  private Paycheck leaksmy;
  private Paycheck daniel;
  private Paycheck peter;
  private Paycheck mark;

  /**
   * Setting up the Paycheck test.
   */
  @Before
  public void setUp() {
    leaksmy = new Paycheck(34.2, 50);
    daniel = new Paycheck(35.4, 42);
    peter = new Paycheck(42.9, 39);
    mark = new Paycheck(50, 2);
  }

  /**
   * Creating test for getting total pay.
   */
  @Test
  public void testGetTotalPay() {
    assertEquals(1881.0f, leaksmy.getTotalPay(), 0.01);
    assertEquals(1673.1f, peter.getTotalPay(), 0.01);
    assertEquals(1522.2f, daniel.getTotalPay(), 0.01);
  }

  /**
   * Creating test for getPayAfterTaxes.
   */
  @Test
  public void testGetPayAfterTaxes() {
    assertEquals(1598.85f, leaksmy.getPayAfterTaxes(), 0.01);
    assertEquals(1422.135f, peter.getPayAfterTaxes(), 0.01);
    assertEquals(1293.87f,daniel.getPayAfterTaxes(), 0.01);
    assertEquals(90.0f, mark.getPayAfterTaxes(), 0.01);
  }

  /**
   * Creat toString test for Paycheck class.
   */
  @Test
  public void testToString() {
    String expectedLeaksmy = "Payment after taxes: $ 1598.85";
    String expectedDaniel = "Payment after taxes: $ 1293.87";
    assertEquals(expectedLeaksmy, leaksmy.toString());
    assertEquals(expectedDaniel, daniel.toString());
  }
}
