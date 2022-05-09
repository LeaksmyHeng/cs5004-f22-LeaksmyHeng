package stock;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

/**
 * This is a test for Stock class.
 */
public class StockTest {
  private Stock msft;
  private Stock nflx;
  private Stock tsla;

  /**
   * Set up the Stock test.
   */
  @Before
  public void setUp() {
    msft = new Stock("MSFT", "Microsoft", 847.25);
    nflx = new Stock("NFLX", "Netflix", 383.47);
    tsla = new Stock("TSLA", "Tesla", 847.98);
  }

  /**
   * Create a test for the getSymbol getter.
   */
  @Test
  public void testGetSymbol() {
    assertEquals("MSFT", msft.getSymbol());
    assertEquals("NFLX", nflx.getSymbol());
    assertEquals("TSLA", tsla.getSymbol());
  }

  /**
   * Create a test for the getName getter.
   */
  @Test
  public void testGetName() {
    assertEquals("Microsoft", msft.getName());
    assertEquals("Netflix", nflx.getName());
    assertEquals("Tesla", tsla.getName());
  }

  /**
   * Create a test to get the basic cost.
   */
  @Test
  public void testGetCostBasis() {
    assertEquals(847.25, msft.getCostBasis(), 0.01);
    assertEquals(383.47, nflx.getCostBasis(), 0.01);
    assertEquals(847.98, tsla.getCostBasis(), 0.01);
  }

  /**
   * Create a test to set the basic cost and get it.
   */
  @Test
  public void testSetCostBasis() {
    double netflix = nflx.setCostBasis(384.19);
    double microsoft = msft.setCostBasis(839.67);
    double tesla = tsla.setCostBasis(875.5);
    assertEquals(384.19, nflx.getCostBasis(), 0.01);
    assertEquals(839.67, msft.getCostBasis(), 0.01);
    assertEquals(875.5, tsla.getCostBasis(), 0.01);
  }

  /**
   * Create a setter and getter test for setCurrentPrice.
   */
  @Test
  public void testSetCurrentPrice() {
    double netflix = nflx.setCurrentPrice(384.19);
    double microsoft = msft.setCurrentPrice(839.67);
    double tesla = tsla.setCurrentPrice(875.5);
    assertEquals(384.19, nflx.getCurrentPrice(), 0.01);
    assertEquals(839.67, msft.getCurrentPrice(), 0.01);
    assertEquals(875.5, tsla.getCurrentPrice(), 0.01);
  }

  /**
   * Create a test for getChangePercent.
   */
  @Test
  public void testGetChangePercent() {
    nflx.setCurrentPrice(384.19);
    msft.setCurrentPrice(839.67);
    tsla.setCurrentPrice(875.5);
    nflx.setCostBasis(315.26);
    msft.setCostBasis(840.99);
    assertEquals(-0.001572, msft.getChangePercent(), 0.01);
    assertEquals(0.218644, nflx.getChangePercent(), 0.01);
    assertEquals(0.0314, tsla.getChangePercent(), 0.01);
  }

  /**
   * Test the toString method.
   */
  @Test
  public void testToString() {
    nflx.setCurrentPrice(384.19);
    msft.setCurrentPrice(839.67);
    tsla.setCurrentPrice(875.5);
    nflx.setCostBasis(315.26);
    msft.setCostBasis(840.99);
    String expectedNetflix = "Netflix Current Price: $ 384.19" + "\n" + " Gain/Loss: 21.86%";
    String expectedMicrosoft = "Microsoft Current Price: $ 839.67" + "\n" + " Gain/Loss: -0.16%";
    String expectedTesla = "Tesla Current Price: $ 875.50" + "\n" + " Gain/Loss: 3.25%";
    assertEquals(expectedNetflix, nflx.toString());
    assertEquals(expectedMicrosoft, msft.toString());
    assertEquals(expectedTesla, tsla.toString());
  }
}