import org.junit.Before;
import org.junit.Test;

import question10.PropertyCategory;
import question10.SaleCondo;
import question10.SaleHouse;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class testProperty {
  private SaleCondo condo;
  private SaleHouse house;
  private SaleCondo condol;
  private SaleHouse housel;

  @Before
  public void setUp() {
    condo = new SaleCondo("Condo", 3, 3, PropertyCategory.STANDARD, 2000);
    house = new SaleHouse("House", 4, 4, PropertyCategory.STANDARD, 2050);
    condol = new SaleCondo("Condo", 5, 3, PropertyCategory.LUXURY, 2570);
    housel = new SaleHouse("House", 7, 4, PropertyCategory.LUXURY, 2050);
  }

  @Test
  public void testHouse() {
    assertEquals(house.calculatePrice(), 420000, 0.0f);
    assertEquals(condo.calculatePrice(), 240000, 0.0f);
  }

  @Test
  public void testLuxury() {
    assertEquals(housel.calculatePrice(), 470000, 0.0f);
    assertEquals(condol.calculatePrice(), 395000, 0.0f);
  }
}
