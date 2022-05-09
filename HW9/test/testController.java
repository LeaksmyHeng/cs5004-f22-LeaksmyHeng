import org.junit.Before;
import org.junit.Test;

import java.io.FileNotFoundException;
import java.io.FileReader;

import Utilities.photoAlbumBuilder;
import Utilities.photoAlbumBuilderImp;
import Utilities.photoAlbumReader;
import controller.Controller;
import model.IPhotoAlbum;
import view.graphicalView;
import view.htmlView;

import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertTrue;

/**
 * Test the controller.
 */
public class testController {
  IPhotoAlbum model;
  String filename;

  /**
   * Setting the test by having it point to building.txt.
   */
  @Before
  public void setUp() throws FileNotFoundException {
    filename = "buildings.txt";
    Readable inFile = new FileReader(filename);
    photoAlbumBuilder<IPhotoAlbum> builder = new photoAlbumBuilderImp();
    model = photoAlbumReader.parseFile(inFile, builder);
  }

  /**
   * Test that the photoAlbumMain.main take the correct argrument input.
   */
  @Test
  public void testTakingCorrectArgumentInput() throws FileNotFoundException {
    PhotoAlbumMain.main(new String[] {"-in buildings.txt -out output.html -v web"});
    PhotoAlbumMain.main(new String[] {"-in playground.txt -v graphical 800 800"});
    PhotoAlbumMain.main(new String[] {"-in teris_wallpaper.txt -v graphical"});
  }

  /**
   * Test that the controller.start() for graphical view work correctly by double check
   * the visible is equal to true and the viewtype is indeed graphically.
   */
  @Test
  public void testStartGraphical() {
    graphicalView view = new graphicalView(model);
    Controller controller = new Controller(model, view);
    controller.start();
    assertTrue(view.isVisible());
    assertEquals(view.getViewType(), "graphical");
  }

  /**
   * Test that the controller.start() for html view is working correctly by checking the content
   * of the output and the viewtype.
   */
  @Test
  public void testStartHtml() {
    String fileoutput = "output.html";
    htmlView view = new htmlView(model, fileoutput);
    Controller controller = new Controller(model, view, fileoutput);
    controller.start();
    assertEquals(view.getViewType(), "web");
    String htmlView = view.getView();
    String editedhtmlView = htmlView.replaceAll("[[0-9]{4}-[0-9]{2}-[0-9]{2}]", "");
    assertEquals(editedhtmlView,
            "<!DOCTYPE html>\n" +
            "<html>\n" +
            "<body>\n" +
            "<div>\n" +
            "<h>T::.Z</h>\n" +
            "<h>Description: </h>\n" +
            "<svg width=\"\" height=\"\">\n" +
            "<rect id=\"background\" x=\"\" Y=\"\" width=\"\" height=\"\" fill=\"rgb(,,)\" visibility=\"visible\"></rect>\n" +
            "<rect id=\"B\" x=\"\" Y=\"\" width=\"\" height=\"\" fill=\"rgb(,,)\" visibility=\"visible\"></rect>\n" +
            "<rect id=\"B\" x=\"\" Y=\"\" width=\"\" height=\"\" fill=\"rgb(,,)\" visibility=\"visible\"></rect>\n" +
            "<rect id=\"B\" x=\"\" Y=\"\" width=\"\" height=\"\" fill=\"rgb(,,)\" visibility=\"visible\"></rect>\n" +
            "<rect id=\"B\" x=\"\" Y=\"\" width=\"\" height=\"\" fill=\"rgb(,,)\" visibility=\"visible\"></rect>\n" +
            "<rect id=\"window\" x=\"\" Y=\"\" width=\"\" height=\"\" fill=\"rgb(,,)\" visibility=\"visible\"></rect>\n" +
            "<rect id=\"window\" x=\"\" Y=\"\" width=\"\" height=\"\" fill=\"rgb(,,)\" visibility=\"visible\"></rect>\n" +
            "<rect id=\"window\" x=\"\" Y=\"\" width=\"\" height=\"\" fill=\"rgb(,,)\" visibility=\"visible\"></rect>\n" +
            "<rect id=\"window\" x=\"\" Y=\"\" width=\"\" height=\"\" fill=\"rgb(,,)\" visibility=\"visible\"></rect>\n" +
            "</svg>\n" +
            "</div>\n" +
            "<div>\n" +
            "<h>T::.Z</h>\n" +
            "<h>Description: </h>\n" +
            "<svg width=\"\" height=\"\">\n" +
            "<rect id=\"background\" x=\"\" Y=\"\" width=\"\" height=\"\" fill=\"rgb(,,)\" visibility=\"visible\"></rect>\n" +
            "<rect id=\"B\" x=\"\" Y=\"\" width=\"\" height=\"\" fill=\"rgb(,,)\" visibility=\"visible\"></rect>\n" +
            "<rect id=\"B\" x=\"\" Y=\"\" width=\"\" height=\"\" fill=\"rgb(,,)\" visibility=\"visible\"></rect>\n" +
            "<rect id=\"B\" x=\"\" Y=\"\" width=\"\" height=\"\" fill=\"rgb(,,)\" visibility=\"visible\"></rect>\n" +
            "<rect id=\"B\" x=\"\" Y=\"\" width=\"\" height=\"\" fill=\"rgb(,,)\" visibility=\"visible\"></rect>\n" +
            "<rect id=\"window\" x=\"\" Y=\"\" width=\"\" height=\"\" fill=\"rgb(,,)\" visibility=\"visible\"></rect>\n" +
            "<rect id=\"window\" x=\"\" Y=\"\" width=\"\" height=\"\" fill=\"rgb(,,)\" visibility=\"visible\"></rect>\n" +
            "<rect id=\"window\" x=\"\" Y=\"\" width=\"\" height=\"\" fill=\"rgb(,,)\" visibility=\"visible\"></rect>\n" +
            "<rect id=\"window\" x=\"\" Y=\"\" width=\"\" height=\"\" fill=\"rgb(,,)\" visibility=\"visible\"></rect>\n" +
            "<rect id=\"window\" x=\"\" Y=\"\" width=\"\" height=\"\" fill=\"rgb(,,)\" visibility=\"visible\"></rect>\n" +
            "<rect id=\"window\" x=\"\" Y=\"\" width=\"\" height=\"\" fill=\"rgb(,,)\" visibility=\"visible\"></rect>\n" +
            "<rect id=\"window\" x=\"\" Y=\"\" width=\"\" height=\"\" fill=\"rgb(,,)\" visibility=\"visible\"></rect>\n" +
            "<rect id=\"window\" x=\"\" Y=\"\" width=\"\" height=\"\" fill=\"rgb(,,)\" visibility=\"visible\"></rect>\n" +
            "</svg>\n" +
            "</div>\n" +
            "<div>\n" +
            "<h>T::.Z</h>\n" +
            "<h>Description:  Turn on the Lights!</h>\n" +
            "<svg width=\"\" height=\"\">\n" +
            "<rect id=\"background\" x=\"\" Y=\"\" width=\"\" height=\"\" fill=\"rgb(,,)\" visibility=\"visible\"></rect>\n" +
            "<rect id=\"B\" x=\"\" Y=\"\" width=\"\" height=\"\" fill=\"rgb(,,)\" visibility=\"visible\"></rect>\n" +
            "<rect id=\"B\" x=\"\" Y=\"\" width=\"\" height=\"\" fill=\"rgb(,,)\" visibility=\"visible\"></rect>\n" +
            "<rect id=\"B\" x=\"\" Y=\"\" width=\"\" height=\"\" fill=\"rgb(,,)\" visibility=\"visible\"></rect>\n" +
            "<rect id=\"B\" x=\"\" Y=\"\" width=\"\" height=\"\" fill=\"rgb(,,)\" visibility=\"visible\"></rect>\n" +
            "<rect id=\"window\" x=\"\" Y=\"\" width=\"\" height=\"\" fill=\"rgb(,,)\" visibility=\"visible\"></rect>\n" +
            "<rect id=\"window\" x=\"\" Y=\"\" width=\"\" height=\"\" fill=\"rgb(,,)\" visibility=\"visible\"></rect>\n" +
            "<rect id=\"window\" x=\"\" Y=\"\" width=\"\" height=\"\" fill=\"rgb(,,)\" visibility=\"visible\"></rect>\n" +
            "<rect id=\"window\" x=\"\" Y=\"\" width=\"\" height=\"\" fill=\"rgb(,,)\" visibility=\"visible\"></rect>\n" +
            "<rect id=\"window\" x=\"\" Y=\"\" width=\"\" height=\"\" fill=\"rgb(,,)\" visibility=\"visible\"></rect>\n" +
            "<rect id=\"window\" x=\"\" Y=\"\" width=\"\" height=\"\" fill=\"rgb(,,)\" visibility=\"visible\"></rect>\n" +
            "<rect id=\"window\" x=\"\" Y=\"\" width=\"\" height=\"\" fill=\"rgb(,,)\" visibility=\"visible\"></rect>\n" +
            "<rect id=\"window\" x=\"\" Y=\"\" width=\"\" height=\"\" fill=\"rgb(,,)\" visibility=\"visible\"></rect>\n" +
            "<rect id=\"window\" x=\"\" Y=\"\" width=\"\" height=\"\" fill=\"rgb(,,)\" visibility=\"visible\"></rect>\n" +
            "<rect id=\"window\" x=\"\" Y=\"\" width=\"\" height=\"\" fill=\"rgb(,,)\" visibility=\"visible\"></rect>\n" +
            "<rect id=\"window\" x=\"\" Y=\"\" width=\"\" height=\"\" fill=\"rgb(,,)\" visibility=\"visible\"></rect>\n" +
            "<rect id=\"window\" x=\"\" Y=\"\" width=\"\" height=\"\" fill=\"rgb(,,)\" visibility=\"visible\"></rect>\n" +
            "<rect id=\"window\" x=\"\" Y=\"\" width=\"\" height=\"\" fill=\"rgb(,,)\" visibility=\"visible\"></rect>\n" +
            "<rect id=\"window\" x=\"\" Y=\"\" width=\"\" height=\"\" fill=\"rgb(,,)\" visibility=\"visible\"></rect>\n" +
            "<rect id=\"window\" x=\"\" Y=\"\" width=\"\" height=\"\" fill=\"rgb(,,)\" visibility=\"visible\"></rect>\n" +
            "<rect id=\"window\" x=\"\" Y=\"\" width=\"\" height=\"\" fill=\"rgb(,,)\" visibility=\"visible\"></rect>\n" +
            "<ellipse id=\"moon\" cx=\"\" cy=\"\" rx=\"\" ry=\"\" fill=\"rgb(,,)\" visibility=\"visible\"></ellipse>\n" +
            "</svg>\n" +
            "</div>\n" +
            "</body>\n" +
            "</html>\n");
  }
}
