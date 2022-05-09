import org.junit.Before;
import org.junit.Test;

import question9.Rectangle;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class testRectangle {
  private Rectangle rect1;
  private Rectangle rect2;

  @Before
  public void setUp() {
    rect1 = new Rectangle(2, 3, 4, 5);
    rect2 = new Rectangle(-3,-4,6,9);
  }

  @Test
  public void testToString() {
    assertEquals("x:2, y:3, w:4, h:5", rect1.toString());
    assertEquals("x:-3, y:-4, w:6, h:9", rect2.toString());
  }

  @Test
  public void testOverlap() {
    Rectangle rect3 = new Rectangle(2,5,8,9);
    Rectangle rect4 = new Rectangle(5,-1,4,5);
    Rectangle rect5 = new Rectangle(1,2,2,2);
    Rectangle rect6 = new Rectangle(-2,-1,4,6);
    Rectangle rect7 = new Rectangle(200,500,800,900);
    assertTrue(rect1.overlap(rect3));
    assertTrue(rect1.overlap(rect4));
    assertTrue(rect1.overlap(rect5));
    assertFalse(rect1.overlap(rect6));
    assertFalse(rect1.overlap(rect7));
  }

  @Test (expected = IllegalArgumentException.class)
  public void testIllegal() {
    Rectangle rect3 = new Rectangle(2,5,-8,9);
  }

  @Test (expected = IllegalArgumentException.class)
  public void testIllegal1() {
    Rectangle rect3 = new Rectangle(2,5,8,-9);
  }

}
