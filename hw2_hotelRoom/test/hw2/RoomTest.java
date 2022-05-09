package hw2;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

/**
 * This is a test for Room class.
 */
public class RoomTest {
  private Room leaksmy;
  private Room daniel;
  private Room keang;
  private Room peter;
  private Room mark;

  /**
   * Setting up the Room test.
   */
  @Before
  public void setUp() {
    leaksmy = new Room(RoomType.DOUBLE, 59.7);
    daniel = new Room(RoomType.FAMILY, 75);
    keang = new Room(RoomType.SINGLE, 45.5);
    peter = new Room(RoomType.SINGLE, 40.9);
    mark = new Room(RoomType.FAMILY, 55.5);
  }

  /**
   * Create a test for isAvailable method.
   */
  @Test
  public void testIsAvailable_testBookRoom() {
    leaksmy.bookRoom(2);    // book successfully
    daniel.bookRoom(5);    // book unsuccessfully
    keang.bookRoom(3);      // book unsuccessfully
    peter.bookRoom(1);      // book successfully
    mark.bookRoom(4);       // book successfully
    assertFalse(leaksmy.isAvailable());
    assertTrue(daniel.isAvailable());
    assertTrue(keang.isAvailable());
    assertFalse(peter.isAvailable());
    assertFalse(mark.isAvailable());
  }

  /**
   * Create a test for getNumberofGuests method.
   */
  @Test
  public void testGetNumberOfGuests() {
    leaksmy.bookRoom(2);    // book successfully
    daniel.bookRoom(5);    // book unsuccessfully
    keang.bookRoom(3);      // book unsuccessfully
    peter.bookRoom(1);      // book successfully
    mark.bookRoom(4);       // book successfully
    assertEquals(2, leaksmy.getNumberOfGuests());
    assertEquals(0, daniel.getNumberOfGuests());
    assertEquals(0, keang.getNumberOfGuests());
    assertEquals(1, peter.getNumberOfGuests());
    assertEquals(4, mark.getNumberOfGuests());
  }

  /**
   * Test illegal exception thrown.
   */
  @Test (expected = IllegalArgumentException.class)
  public void testIllegalPrice() {
    daniel = new Room(RoomType.FAMILY, -0.01);
  }

  /**
   * Test RoomType to see if it gives the correct maximum occupancy.
   */
  @Test
  public void testRoomType() {
    assertEquals(1, RoomType.SINGLE.getValue());
    assertEquals(2, RoomType.DOUBLE.getValue());
    assertEquals(4, RoomType.FAMILY.getValue());
  }
}
