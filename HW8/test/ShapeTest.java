import org.junit.Before;
import org.junit.Test;

import model.IShape;
import model.Oval;
import model.Rectangle;

import static org.junit.Assert.assertEquals;

/**
 * Create a test for Shapes and its Model for transforming it to a canvas.
 */
public class ShapeTest {
  private Rectangle a;
  private Oval o;

  /**
   * Set up a test for Shape.
   */
  @Before
  public void setUp() {
    a = new Rectangle(5, 5, 2, 8, 10, 11, 12, "rectangle1");
    o = new Oval(-2, 8, 10, 11, 12, 19, 25, "Oval1");
  }

  /**
   * Testing toString method of the shapes and this will cover all of the getter methods.
   */
  @Test
  public void testToString() {
    assertEquals("Name: rectangle1\nType: Rectangle\nMin corner: (5, 5), " +
            "Width: 2, Height: 8, Color: (10, 11, 12)\n", a.toString());
    assertEquals("Name: Oval1\nType: Oval\n" +
            "Center: (-2, 8), X radius: 10, Y radius: 11, Color: (12, 19, 25)\n", o.toString());
  }

  /**
   * Test copy method.
   */
  @Test
  public void testCopy() {
    IShape copyA = a.copy();
    IShape copyO = o.copy();
    assertEquals(copyA.getB(), 12);
    assertEquals(copyO.getG(), 19);
    assertEquals(copyA.toString(), a.toString());
    assertEquals(copyO.toString(), o.toString());
  }

  /**
   * Test Illegal RGB Color.
   */
  @Test (expected = IllegalArgumentException.class)
  public void testIllegalR() {
    Rectangle b = new Rectangle(5, 5, 2, 8, -10, 11, 12, "rec1");
  }

  /**
   * Test Illegal RGB Color.
   */
  @Test (expected = IllegalArgumentException.class)
  public void testIllegalG() {
    Rectangle b = new Rectangle(5, 5, 2, 8, 10, -11, 12, "rec1");
  }

  /**
   * Test Illegal RGB Color.
   */
  @Test (expected = IllegalArgumentException.class)
  public void testIllegalB() {
    Rectangle b = new Rectangle(5, 5, 2, 8, 10, 11, 256, "rec1");
  }

  /**
   * Test Illegalname - null name.
   */
  @Test (expected = IllegalArgumentException.class)
  public void testIllegalNullName() {
    Rectangle b = new Rectangle(5, 5, 2, 8, 10, 11, 254, null);
  }

  /**
   * Test Illegalname - empty string name.
   */
  @Test (expected = IllegalArgumentException.class)
  public void testIllegalEmptyStringName() {
    Rectangle b = new Rectangle(5, 5, 2, 8, 10, 11, 255, "");
  }

  /**
   * Test Illegalwidth.
   */
  @Test (expected = IllegalArgumentException.class)
  public void testIllegalIllegalWidth() {
    Rectangle b = new Rectangle(5, 5, -2, 8, 10, 11, 255, "width");
  }

  /**
   * Test Illegal height.
   */
  @Test (expected = IllegalArgumentException.class)
  public void testIllegalIllegalHeight() {
    Rectangle b = new Rectangle(0, -5, 2, -8, 10, 11, 255, "width");
  }
}
