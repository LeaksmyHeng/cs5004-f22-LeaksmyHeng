package hw2;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

/**
 * Create a test for MailItem class.
 */
public class MailItemTest {
  private MailItem leaksmy;
  private MailItem daniel;

  /**
   * Setting up test for MailItem.
   */
  @Before
  public void setUp() {
    leaksmy = new MailItem(2, 3, 5, new Recipient("Leaksmy", "Heng", "Leaksmy_Heng@yahoo.com"));
    daniel = new MailItem(1, 2, 3, new Recipient("Daniel", "Kelley", "Daniel_Kelley@gmail.com"));
  }

  /**
   * Test IllegalArgumentException for width.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testIllegalWidth() {
    MailItem joyce = new MailItem(0, 1,2, new Recipient("Joy", "Kelley", "jy@yahoo.com"));
  }

  /**
   * Test IllegalArgumentException for height.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testIllegalHeight() {
    MailItem joyce = new MailItem(1, 0,2, new Recipient("Joy", "Kelley", "jy@yahoo.com"));
  }

  /**
   * Test IllegalArgumentException for depth.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testIllegalDepth() {
    MailItem joyce = new MailItem(1, 2,0, new Recipient("Joy", "Kelley", "jy@yahoo.com"));
  }

  /**
   * Test IllegalArgumentException for recipient.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testIllegalRecipientEmail() {
    MailItem joyce = new MailItem(1, 2,7, new Recipient("Joyce", "Kelley", ""));
  }

  /**
   * Test IllegalArgumentException for recipient.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testIllegalRecipientFirstName() {
    MailItem joyce = new MailItem(1, 2,4,
            new Recipient("", "Kelley", "JY@email.com"));
  }

  /**
   * Test IllegalArgumentException for recipient.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testIllegalRecipientLastName() {
    MailItem joyce = new MailItem(1, 2,5,
            new Recipient("Kelley", "", "JY@email.com"));
  }

  /**
   * Test getRecipient method.
   */
  @Test
  public void testGetRecipient() {
    assertEquals("Leaksmy Heng Email:Leaksmy_Heng@yahoo.com", leaksmy.getRecipient().toString());
    assertEquals("Daniel Kelley Email:Daniel_Kelley@gmail.com", daniel.getRecipient().toString());
  }

  /**
   * Test all getters function including getHeight, getDepth, and getWidth.
   */
  @Test
  public void testGetWidthGetHeightGetDepth() {
    assertEquals(2, leaksmy.getWidth());
    assertEquals(3, leaksmy.getHeight());
    assertEquals(5, leaksmy.getDepth());
    assertEquals(1, daniel.getWidth());
    assertEquals(2, daniel.getHeight());
    assertEquals(3, daniel.getDepth());
  }
}
