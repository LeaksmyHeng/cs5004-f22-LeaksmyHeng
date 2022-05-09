import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class testPerson {
  private Person pat;

  @Before
  public void setUp(){
    pat = new Person("Pat", "Conroy", 1948);
  }

  @Test
  public void testGetFirstName(){
    // Return boolean true or false (2 parameters: expected = actual result)
    // for float, use assertDelta
    assertEquals("Pat", pat.getFirstName());
  }

  @Test
  public void testToString() {
    assertEquals("Pat Conroy", pat.toString());
  }

  @Test
  public void testSame(){
    Person benlerner = new Person("Ben", "Lerner", 1982);
    Person benaffleck = new Person("Ben", "Affleck", 1982);
    Person timlerner = new Person ("Tim", "Lerner", 1982);
    Person leaksmyheng = new Person("Leaksmy", "Heng", 1998);
    Person identicaltwin = new Person("Leaksmy", "Heng", 1998);

    assertFalse(benlerner.same(timlerner));
    assertFalse(leaksmyheng.same(benaffleck));
    assertFalse(identicaltwin.same(timlerner));
    assertTrue(leaksmyheng.same(identicaltwin));
  }

}
