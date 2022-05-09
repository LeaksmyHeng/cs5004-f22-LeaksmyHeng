package hw2;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import org.junit.Before;
import org.junit.Test;

/**
 * This is a test for Locker class.
 */
public class LockerTest {
  private Locker leaksmy;
  private Locker daniel;

  /**
   * Setting up the Locker test.
   */
  @Before
  public void setUp() {
    leaksmy = new Locker(5, 6 , 7);
    daniel = new Locker(8, 9, 10);
  }

  /**
   * Create a test for the Illegal maxWidth.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testIllegalMaxWidth() {
    Locker mark = new Locker(-2, 100, 1000);
  }

  /**
   * Create a test for the Illegal maxWidth.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testIllegalMaxHeight() {
    Locker mark = new Locker(1, -100, 1000);
  }

  /**
   * Create a test for the Illegal maxWidth.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testIllegalMaxDepth() {
    Locker mark = new Locker(200, 100, 0);
  }

  /**
   * Create a test for getMailItem.
   */
  @Test
  public void testGetMailItem() {
    Recipient r_leaksmy = new Recipient("Leaksmy", "Heng", "Leaksmy_Heng@gmail.com");
    MailItem m_leaksmy = new MailItem(3, 3, 3, r_leaksmy);
    Recipient r_daniel = new Recipient("Daniel", "Kelley", "Daneil_Kelley@gmail.com");
    MailItem m_daniel = new MailItem(2, 2, 2, r_daniel);
    leaksmy.addMail(m_leaksmy);
    daniel.addMail(m_daniel);
    assertEquals(m_leaksmy, leaksmy.getMailItem());
  }

  /**
   * Test pickupMail null because the width, height and depth is greater than
   * maxWidth, maxHeight and maxDepth.
   */
  @Test
  public void testPickUpMailNull() {
    Recipient r_leaksmy = new Recipient("Leaksmy", "Heng", "Leaksmy_Heng@gmail.com");
    MailItem m_leaksmy = new MailItem(100, 3, 3, r_leaksmy);
    Recipient r_daniel = new Recipient("Daniel", "Kelley", "Daniel_kelley@gmail.com");
    MailItem m_daniel = new MailItem(5, 500, 5, r_daniel);
    leaksmy.addMail(m_leaksmy);
    daniel.addMail(m_daniel);
    assertEquals(null, leaksmy.pickupMail(r_leaksmy));
    assertEquals(null, daniel.pickupMail(r_daniel));
  }

  /**
   * Test pickupMail with different recipient.
   */
  @Test
  public void testPickUpMailDifferentRecipient() {
    Recipient r_leaksmy = new Recipient("Leaksmy", "Heng", "Leaksmy_Heng@gmail.com");
    Recipient d_leaksmy = new Recipient("Leaksmy", "Haeng", "Leaksmy_Heng@gmail.com");
    MailItem m_leaksmy = new MailItem(100, 3, 3, d_leaksmy);
    leaksmy.addMail(m_leaksmy);
    assertNotEquals(m_leaksmy, leaksmy.getMailItem());
    assertEquals(null, leaksmy.pickupMail(r_leaksmy));
  }
}
