import org.junit.Test;

import model.PhotoAlbum;
import model.shapeType;

import static org.junit.Assert.assertEquals;

public class testPhotoAlbum {
  PhotoAlbum testAlbum;
  PhotoAlbum ovalAlbum;
  PhotoAlbum rectangleAlbum;

  @Test
  public void testAddShape() {
    testAlbum = new PhotoAlbum(0, 0, 500, 500);
    testAlbum.addShape("Oval1", shapeType.OVAL, 10, 10, 10, 10, 10, 10, 10);
    testAlbum.addShape("Oval2", shapeType.OVAL, 15, 15, 15, 15, 15, 15, 15);
    testAlbum.addShape("Rect1", shapeType.RECTANGLE, 25, 25, 25, 25, 25, 25, 25);
    testAlbum.snapshot("Snapshot 1");
    //System.out.println(testAlbum.snapShotInformation());
    testAlbum.addShape("Rect2", shapeType.RECTANGLE, 25, 25, 25, 25, 25, 25, 25);
    assertEquals("Shape information:\n" +
            "Name: Oval1\n" +
            "Type: Oval\n" +
            "Center: (10, 10), X radius: 10, Y radius: 10, Color: (10, 10, 10)\n" +
            "Name: Oval2\n" +
            "Type: Oval\n" +
            "Center: (15, 15), X radius: 15, Y radius: 15, Color: (15, 15, 15)\n" +
            "Name: Rect1\n" +
            "Type: Rectangle\n" +
            "Min corner: (25, 25), Width: 25, Height: 25, Color: (25, 25, 25)\n" +
            "Name: Rect2\n" +
            "Type: Rectangle\n" +
            "Min corner: (25, 25), Width: 25, Height: 25, Color: (25, 25, 25)\n",
            testAlbum.shapeListToString());
    testAlbum.remove("Rect1");
    testAlbum.snapshot(null);
    //System.out.println(testAlbum.snapShotInformation());
  }

  @Test (expected = IllegalArgumentException.class)
  public void testIllegalRemoveNoneExistedID() {
    testAlbum = new PhotoAlbum(0, 0, 500, 1000);
    testAlbum.addShape("Oval1", shapeType.OVAL, 10, 10,
            10, 10, 10, 10, 10);
    testAlbum.remove("Oval2");
  }

  @Test
  public void ovalAlbum () {
    ovalAlbum = new PhotoAlbum(-3, -3, 100, 100);
    ovalAlbum.addShape("O1", shapeType.OVAL,
            8, 0, 10, 11, 12, 4, 4);
    ovalAlbum.addShape("O2", shapeType.OVAL,
            0, 0, 15, 16, 17, 2, 3);
    ovalAlbum.addShape("O3", shapeType.OVAL,
            -3, 2, 15, 16, 17, 2, 2);
    ovalAlbum.snapshot("Album before alter anything");
    assertEquals("Shape information:\n" +
            "Name: O1\n" +
            "Type: Oval\n" +
            "Center: (8, 0), X radius: 4, Y radius: 4, Color: (10, 11, 12)\n" +
            "Name: O2\n" +
            "Type: Oval\n" +
            "Center: (0, 0), X radius: 2, Y radius: 3, Color: (15, 16, 17)\n" +
            "Name: O3\n" +
            "Type: Oval\n" +
            "Center: (-3, 2), X radius: 2, Y radius: 2, Color: (15, 16, 17)\n",
            ovalAlbum.shapeListToString());
    ovalAlbum.changePosition("O1", 10, 20);
    ovalAlbum.changePosition("O2", 20, 25);
    ovalAlbum.changePosition("O3", 1, 2);
    ovalAlbum.snapshot("Change Position snapshot");
    assertEquals(2, ovalAlbum.numberOfSnapShot());
    ovalAlbum.changeColor("O1", 100, 120, 130);
    ovalAlbum.changeShapeSize("O1", 12, 15);
    ovalAlbum.changeShapeSize("O2", 15, 9);
    ovalAlbum.changeColor("O3", 0, 0, 0);
    ovalAlbum.snapshot("Change color and shape size");
    assertEquals(3, ovalAlbum.numberOfSnapShot());
    assertEquals("Shape information:\n" +
            "Name: O1\n" +
            "Type: Oval\n" +
            "Center: (10, 20), X radius: 12, Y radius: 15, Color: (100, 120, 130)\n" +
            "Name: O2\n" +
            "Type: Oval\n" +
            "Center: (20, 25), X radius: 15, Y radius: 9, Color: (15, 16, 17)\n" +
            "Name: O3\n" +
            "Type: Oval\n" +
            "Center: (1, 2), X radius: 2, Y radius: 2, Color: (0, 0, 0)\n",
            ovalAlbum.shapeListToString());
    ovalAlbum.remove("O1");
    assertEquals("Shape information:\n" +
                    "Name: O2\n" +
                    "Type: Oval\n" +
                    "Center: (20, 25), X radius: 15, Y radius: 9, Color: (15, 16, 17)\n" +
                    "Name: O3\n" +
                    "Type: Oval\n" +
                    "Center: (1, 2), X radius: 2, Y radius: 2, Color: (0, 0, 0)\n",
            ovalAlbum.shapeListToString());
    //System.out.println(ovalAlbum.snapShotInformation());
    //System.out.println(ovalAlbum.shapeListToString());
  }

  @Test
  public void rectangleAlbum () {
    rectangleAlbum = new PhotoAlbum(-3, -3, 100, 100);
    rectangleAlbum.addShape("R1", shapeType.RECTANGLE,
            8, 0, 10, 11, 12, 4, 4);
    rectangleAlbum.addShape("R2", shapeType.RECTANGLE,
            0, 0, 15, 16, 17, 2, 3);
    rectangleAlbum.addShape("R3", shapeType.RECTANGLE,
            -3, 2, 15, 16, 17, 2, 2);
    rectangleAlbum.snapshot("Album before alter anything");

    assertEquals("Shape information:\n" +
                    "Name: R1\n" +
                    "Type: Rectangle\n" +
                    "Min corner: (8, 0), Width: 4, Height: 4, Color: (10, 11, 12)\n" +
                    "Name: R2\n" +
                    "Type: Rectangle\n" +
                    "Min corner: (0, 0), Width: 2, Height: 3, Color: (15, 16, 17)\n" +
                    "Name: R3\n" +
                    "Type: Rectangle\n" +
                    "Min corner: (-3, 2), Width: 2, Height: 2, Color: (15, 16, 17)\n",
            rectangleAlbum.shapeListToString());
    rectangleAlbum.changePosition("R1", 10, 20);
    rectangleAlbum.changePosition("R2", 20, 25);
    rectangleAlbum.changePosition("R3", 1, 2);

    rectangleAlbum.snapshot("Change Position snapshot");
    //System.out.println(rectangleAlbum.snapShotInformation());

    assertEquals(2, rectangleAlbum.numberOfSnapShot());
    rectangleAlbum.changeColor("R1", 100, 120, 130);
    rectangleAlbum.changeShapeSize("R1", 12, 15);
    rectangleAlbum.changeShapeSize("R2", 15, 9);
    rectangleAlbum.changeColor("R3", 0, 0, 0);

    rectangleAlbum.snapshot("Change color and shape size");
    assertEquals(3, rectangleAlbum.numberOfSnapShot());
    assertEquals("Shape information:\n" +
                    "Name: R1\n" +
                    "Type: Rectangle\n" +
                    "Min corner: (10, 20), Width: 12, Height: 15, Color: (100, 120, 130)\n" +
                    "Name: R2\n" +
                    "Type: Rectangle\n" +
                    "Min corner: (20, 25), Width: 15, Height: 9, Color: (15, 16, 17)\n" +
                    "Name: R3\n" +
                    "Type: Rectangle\n" +
                    "Min corner: (1, 2), Width: 2, Height: 2, Color: (0, 0, 0)\n",
            rectangleAlbum.shapeListToString());
    rectangleAlbum.remove("R1");
    rectangleAlbum.snapshot("Remove R1");
    assertEquals("Shape information:\n" +
                    "Name: R2\n" +
                    "Type: Rectangle\n" +
                    "Min corner: (20, 25), Width: 15, Height: 9, Color: (15, 16, 17)\n" +
                    "Name: R3\n" +
                    "Type: Rectangle\n" +
                    "Min corner: (1, 2), Width: 2, Height: 2, Color: (0, 0, 0)\n",
            rectangleAlbum.shapeListToString());
  }
}
