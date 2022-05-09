import org.junit.Test;

import model.PhotoAlbum;
import model.shapeType;

import static org.junit.Assert.assertEquals;

public class PhotoAlbumTest {
  PhotoAlbum testAlbum;
  PhotoAlbum ovalAlbum;
  PhotoAlbum rectangleAlbum;

  @Test
  public void testAddShape() {
    testAlbum = new PhotoAlbum(0, 0, 500, 500);
    testAlbum.addShape("Oval1", shapeType.OVAL, 10, 10, 10, 10, 10, 10, 10);
    testAlbum.addShape("Oval2", shapeType.OVAL, 15, 15, 15, 15, 15, 15, 15);
    testAlbum.addShape("Rect1", shapeType.RECTANGLE, 25, 25, 25, 25, 25, 25, 25);
    assertEquals("Shape information:\nName: Oval1\nType: Oval\n" +
            "Center: (10, 10), X radius: 10, Y radius: 10, Color: (10, 10, 10)\n" +
            "Name: Oval2\n" +
            "Type: Oval\n" +
            "Center: (15, 15), X radius: 15, Y radius: 15, Color: (15, 15, 15)\n" +
            "Name: Rect1\n" +
            "Type: Rectangle\n" +
            "Min corner: (25, 25), Width: 25, Height: 25, Color: (25, 25, 25)\n",
            testAlbum.shapeListToString());
  }

  @Test (expected = IllegalArgumentException.class)
  public void testChangetoTheSamePosition() {
    testAlbum = new PhotoAlbum(0, 0, 500, 100);
    testAlbum.addShape("Oval1", shapeType.OVAL, 10, 10,
            10, 10, 10, 10, 10);
    testAlbum.changePosition("Oval1", 10, 10);
  }

  @Test (expected = IllegalArgumentException.class)
  public void testChangePositionEndTimeGreaterThanStarterTime() {
    testAlbum = new PhotoAlbum(0, 0, 500, 100);
    testAlbum.addShape("Oval1", shapeType.OVAL, 10, 10,
            10, 10, 10, 10, 10);
    testAlbum.changePosition("Oval1", 10, 10);
  }

  @Test (expected = IllegalArgumentException.class)
  public void testRGBFailing() {
    testAlbum = new PhotoAlbum(0, 0, 500, 100);
    testAlbum.addShape("Oval1", shapeType.OVAL, 10, 10,
            -10, 10, 10, 10, 10);
  }

  @Test (expected = IllegalArgumentException.class)
  public void testRGBFailing2() {
    testAlbum = new PhotoAlbum(0, 0, 500, 100);
    testAlbum.addShape("Oval1", shapeType.OVAL, 10, 10,
            10, -10, 10, 10, 10);
  }

  @Test (expected = IllegalArgumentException.class)
  public void testRGBFailing3() {
    testAlbum = new PhotoAlbum(0, 0, 500, 100);
    testAlbum.addShape("Oval1", shapeType.OVAL, 10, 10,
            10, 10, -10, 10, 10);
  }

  @Test (expected = IllegalArgumentException.class)
  public void testIllegalWidth() {
    testAlbum = new PhotoAlbum(0, 0, 500, 100);
    testAlbum.addShape("Oval1", shapeType.OVAL, 10, 10,
            10, 10, 10, -10, 10);
  }

  @Test (expected = IllegalArgumentException.class)
  public void testIllegalHeight() {
    testAlbum = new PhotoAlbum(0, 0, 500, 100);
    testAlbum.addShape("Oval1", shapeType.OVAL, 10, 10,
            10, 10, 10, 10, -10);
  }

  @Test (expected = IllegalArgumentException.class)
  public void testShapeIDDoesNotExist() {
    testAlbum = new PhotoAlbum(0, 0, 500, 100);
    testAlbum.addShape("Oval1", shapeType.OVAL, 10, 10,
            10, 10, 10, 10, 10);
    testAlbum.changePosition("oval2", 10, 11);
  }

  @Test (expected = IllegalArgumentException.class)
  public void testChangetoSameColor() {
    testAlbum = new PhotoAlbum(0, 0, 500, 100);
    testAlbum.addShape("Oval1", shapeType.OVAL, 10, 10,
            10, 10, 10, 10, 10);
    testAlbum.changeColor("oval1", 10, 10, 10);
  }

  @Test (expected = IllegalArgumentException.class)
  public void testChangeWithNonExistedID() {
    testAlbum = new PhotoAlbum(0, 0, 500, 100);
    testAlbum.addShape("Oval1", shapeType.OVAL, 10, 10,
            10, 10, 10, 10, 10);
    testAlbum.changeColor("Oval2", 11, 10, 10);
  }

  @Test (expected = IllegalArgumentException.class)
  public void testChangeColorWithNullID() {
    testAlbum = new PhotoAlbum(0, 0, 500, 100);
    testAlbum.addShape("Oval1", shapeType.OVAL, 10, 10,
            10, 10, 10, 10, 10);
    testAlbum.changeColor(null, 11, 10, 10);
  }

  @Test (expected = IllegalArgumentException.class)
  public void testIllegalAddSameName() {
    testAlbum = new PhotoAlbum(0, 0, 500, 1000);
    testAlbum.addShape("Oval1", shapeType.OVAL, 10, 10,
            10, 10, 10, 10, 10);
    testAlbum.addShape("Oval1", shapeType.OVAL, 10, 10,
            10, 10, 10, 100, 100);
  }

  @Test (expected = IllegalArgumentException.class)
  public void testChangeColorGreaterThanRGBR() {
    testAlbum = new PhotoAlbum(0, 0, 500, 100);
    testAlbum.addShape("Oval1", shapeType.OVAL, 10, 10,
            10, 10, 10, 10, 10);
    testAlbum.changeColor("Oval1", 256, 10, 10);
  }

  @Test (expected = IllegalArgumentException.class)
  public void testChangeColorGreaterThanRGBG() {
    testAlbum = new PhotoAlbum(0, 0, 500, 100);
    testAlbum.addShape("Oval1", shapeType.OVAL, 10, 10,
            10, 25, 10, 10, 10);
    testAlbum.changeColor("Oval1", 11, -2, 10);
  }

  @Test (expected = IllegalArgumentException.class)
  public void testChangeColorGreaterThanRGBB() {
    testAlbum = new PhotoAlbum(0, 0, 500, 100);
    testAlbum.addShape("Oval1", shapeType.OVAL, 10, 10,
            10, 255, 10, 10, 10);
    testAlbum.changeColor("Oval1", 11, -10, 10);
  }

  @Test (expected = IllegalArgumentException.class)
  public void testChangeShapeSizeNullID() {
    testAlbum = new PhotoAlbum(0, 0, 500, 100);
    testAlbum.addShape("Oval1", shapeType.OVAL, 10,
            10, 10, 255, 10, 10, 10);
    testAlbum.changeShapeSize(null, 1, 10);
  }

  @Test (expected = IllegalArgumentException.class)
  public void testChangeShapeNonExistedID() {
    testAlbum = new PhotoAlbum(0, 0, 500, 100);
    testAlbum.addShape("Oval1", shapeType.OVAL, 10,
            10, 10, 255, 10, 10, 10);
    testAlbum.changeShapeSize("oval2", 1, 10);
  }

  @Test (expected = IllegalArgumentException.class)
  public void testChangeShapeSizeNegativeWidth() {
    testAlbum = new PhotoAlbum(0, 0, 500, 100);
    testAlbum.addShape("Oval1", shapeType.OVAL,
            10, 10, 10, 255, 10, 10, 10);
    testAlbum.changeShapeSize("oval1", -1, 10);
  }

  @Test (expected = IllegalArgumentException.class)
  public void testChangeShapeSizeNegativeHeight() {
    testAlbum = new PhotoAlbum(0, 0, 500, 100);
    testAlbum.addShape("Oval1", shapeType.OVAL,
            10, 10, 10, 255, 10, 10, 10);
    testAlbum.changeShapeSize("oval1", 1, -10);
  }

  @Test
  public void testAddImageOutSideOfXCanvasCooridnate() {
    testAlbum = new PhotoAlbum(0, 0, 500, 100);
    testAlbum.addShape("R1", shapeType.RECTANGLE,
            -10, 10, 10, 255, 10, 10, 10);
  }

  @Test
  public void testAddImageOutSideOfYCanvasCooridnate() {
    testAlbum = new PhotoAlbum(0, 0, 500, 100);
    testAlbum.addShape("R1", shapeType.RECTANGLE,
            10, -1, 10, 255, 10, 10, 10);
  }

  @Test
  public void testAddShapeBiggerThanCanvasCooridnate1() {
    testAlbum = new PhotoAlbum(0, 0, 50, 10);
    testAlbum.addShape("R1", shapeType.RECTANGLE,
            10, 10, 10, 255, 10, 50, 50);
  }

  @Test
  public void testAddShapeBiggerThanCanvasCooridnate2() {
    testAlbum = new PhotoAlbum(0, 0, 50, 10);
    testAlbum.addShape("R1", shapeType.RECTANGLE,
            0, 0, 10, 255, 10, 10, 60);
  }


  @Test
  public void testResizeShapeBiggerThanCanvasCooridnate1() {
    testAlbum = new PhotoAlbum(0, 0, 50, 10);
    testAlbum.addShape("Rec1", shapeType.RECTANGLE,
            0, 0, 10, 255, 10, 10, 10);
    testAlbum.changeShapeSize("Rec1", 100, 100);
  }

  @Test
  public void testResizeShapeBiggerThanCanvasCooridnate2() {
    testAlbum = new PhotoAlbum(0, 0, 50, 10);
    testAlbum.addShape("Rec1", shapeType.RECTANGLE,
            0, 0, 10, 255, 10, 10, 10);
    testAlbum.changeShapeSize("Rec1", 150, 100);
  }

  @Test
  public void testAddShapeOval() {
    ovalAlbum = new PhotoAlbum(-3, -3, 100, 100);
    ovalAlbum.addShape("O1", shapeType.OVAL,
            8, 0, 10, 11, 12, 4, 4); // this is oval out of bound
    ovalAlbum.addShape("O2", shapeType.OVAL,
            0, 0, 15, 16, 17, 2, 3);
    ovalAlbum.addShape("O3", shapeType.OVAL,
            -3, 2, 15, 16, 17, 2, 2); // this is another oval out of bound
    ovalAlbum.addShape("O3", shapeType.OVAL,
            -2, 0, 15, 16, 17, 1, 1);
    assertEquals(ovalAlbum.shapeListToString(), "Shape information:\n" +
            "Name: O2\nType: Oval\n" +
            "Center: (0, 0), X radius: 2, Y radius: 3, Color: (15, 16, 17)\n" +
            "Name: O3\nType: Oval\n" +
            "Center: (-2, 0), X radius: 1, Y radius: 1, Color: (15, 16, 17)\n");
    ovalAlbum.changePosition("O3", 20, 20);
    ovalAlbum.changeShapeSize("O3", 5, 5);
    ovalAlbum.changeColor("O3", 111, 145, 100);
    System.out.println(ovalAlbum.shapeListToString());
  }

  @Test
  public void testRectangleAlbum() {
    rectangleAlbum = new PhotoAlbum(-10, -10, 25, 25);
    rectangleAlbum.addShape("R1", shapeType.RECTANGLE, -10, -10, 2, 5, 100, 2, 5);
    rectangleAlbum.addShape("R2", shapeType.RECTANGLE, 0, 0, 100, 200, 222, 10, 10);
    rectangleAlbum.addShape("R3", shapeType.RECTANGLE, 5, 5, 125, 125, 125, 5, 10);
    rectangleAlbum.addShape("R4", shapeType.RECTANGLE, 13, 0, 125, 125, 125, 2, 1);
    rectangleAlbum.addShape("IR3", shapeType.RECTANGLE, 5, 5, 125, 125, 125, 5, 20);
    rectangleAlbum.changePosition("R4", 0, 13);
    rectangleAlbum.changePosition("R1", 5, -10);
    rectangleAlbum.changeShapeSize("R1", 15, 5);
    rectangleAlbum.changeShapeSize("R4", 5, 5);
    assertEquals("Shape information:\n" +
            "Name: R1\nType: Rectangle\n" +
            "Min corner: (5, -10), Width: 2, Height: 5, Color: (2, 5, 100)\n" +
            "Name: R2\nType: Rectangle\n" +
            "Min corner: (0, 0), Width: 10, Height: 10, Color: (100, 200, 222)\n" +
            "Name: R3\nType: Rectangle\n" +
            "Min corner: (5, 5), Width: 5, Height: 10, Color: (125, 125, 125)\n" +
            "Name: R4\nType: Rectangle\n" +
            "Min corner: (0, 13), Width: 2, Height: 1, Color: (125, 125, 125)\n",
            rectangleAlbum.shapeListToString());
    rectangleAlbum.remove("R4");
  }
}
