package hw2;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

/**
 * Create a test for Recipient class.
 */
public class RecipientTest {
  private Recipient leaksmy;
  private Recipient daniel;

  /**
   * Setting up a test for Recipient.
   */
  @Before
  public void setUp() {
    leaksmy = new Recipient("Leaksmy", "Heng", "Leaksmy_Heng@email.com");
    daniel = new Recipient("Daniel", "Kelley", "Daniel_Kelley@yahoo.com");
  }

  /**
   * Test IllegalArgumentException when firstName is empty.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testFirstNameEmptyString() {
    Recipient joyce = new Recipient("", "Emery", "jy@gmail.com");
  }

  /**
   * Test IllegalArgumentException when LastName is empty.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testLastNameEmptyString() {
    Recipient mark = new Recipient("Mark", "", "mark_kelley@yahoo.com");
  }

  /**
   * Test IllegalArgumentException when email is empty.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testEmailEmptyString() {
    Recipient mark = new Recipient("Mark", "Kelley", "");
  }

  /**
   * Test toString method.
   */
  @Test
  public void testToString() {
    assertEquals("Leaksmy Heng Email:Leaksmy_Heng@email.com", leaksmy.toString());
    assertEquals("Daniel Kelley Email:Daniel_Kelley@yahoo.com", daniel.toString());
  }
}
