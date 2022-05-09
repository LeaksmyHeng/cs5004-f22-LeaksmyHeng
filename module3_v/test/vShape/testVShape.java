package vShape;

import org.junit.Before;
import org.junit.Test;

import shapes.Circle;
import shapes.vCircle;
import shapes.vRactangle;
import shapes.vShape;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class testVShape {

  vShape circle1, circle2, circle3, rect1, rect2;

  @Before
  public void setUp() {
    circle1 = new vCircle(3, 4, 5);
    circle2 = new vCircle(10.32, 10.43, 10);
    circle3 = new vCircle(20);

    rect1 = new vRactangle(5, 6, 2.5, 2);
    rect2 = new vRactangle(2, 3, 10, 10);
  }

  @Test
  public void testArea() {
    assertEquals(Math.PI*25, circle1.area(), 0.001);
    assertEquals(Math.PI*100, circle2.area(), 0.001);
    assertEquals(Math.PI*400, circle3.area(), 0.001);
    assertEquals(5, rect1.area(), 0.001);
    assertEquals(100, rect2.area(), 0.001);
  }

  @Test
  public void testResizes() {
    vShape resizedCircle1, resizedCircle2, resizedCircle3, resizedRect1, resizedRect2;
    resizedCircle1 = circle1.resize(2.5);
    resizedCircle2 = circle2.resize(0);
    resizedCircle3 = circle3.resize(10);
    resizedRect1 = rect1.resize(12.5);
    resizedRect2 = rect2.resize(0.001);

    assertEquals(2.5*circle1.area(), resizedCircle1.area(), 0.001);
    assertEquals(0*circle2.area(), resizedCircle2.area(), 0.001);
    assertEquals(10*circle3.area(), resizedCircle3.area(), 0.001);
    assertEquals(12.5*rect1.area(), resizedRect1.area(), 0.001);
    assertEquals(0.001*rect2.area(), resizedRect2.area(), 0.001);
  }

  @Test
  public void testCompareTo() {
    assertEquals(1, circle1.compareTo(rect1));
    assertEquals(-1, circle1.compareTo(circle2));
    assertEquals(0, circle1.compareTo(circle1));
  }
}
