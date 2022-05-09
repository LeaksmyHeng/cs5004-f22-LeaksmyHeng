import org.junit.Test;

import java.io.FileNotFoundException;
import java.io.FileReader;

import Utilities.photoAlbumBuilder;
import Utilities.photoAlbumBuilderImp;
import Utilities.photoAlbumReader;
import model.IPhotoAlbum;
import view.htmlView;

import static org.testng.AssertJUnit.assertEquals;

/**
 * Create a test for html view by comparing the body content.
 */
public class testhtmlView {

  /**
   * Create the test for html view to ensure that it parses all the body html correctly.
   */
  @Test
  public void htmlViewTest() throws FileNotFoundException {
    IPhotoAlbum model;
    String filename = "buildings.txt";
    Readable inFile = new FileReader(filename);

    photoAlbumBuilder<IPhotoAlbum> builder = new photoAlbumBuilderImp();
    model = photoAlbumReader.parseFile(inFile, builder);
    htmlView view = new htmlView(model, filename);
    String htmlViewString = view.getView();
    // removing the timestamp out cause we will never going to get the timestamp correct.
    // hence we only test the body of the html
    String editedhtmlView = htmlViewString.replaceAll("[[0-9]{4}-[0-9]{2}-[0-9]{2}]", "");
    assertEquals(editedhtmlView, "<!DOCTYPE html>\n" +
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

  @Test(expected = FileNotFoundException.class)
  public void htmlViewTestFail() throws FileNotFoundException {
    IPhotoAlbum model;
    String filename = "buildingsfail.txt";
    Readable inFile = new FileReader(filename);

    photoAlbumBuilder<IPhotoAlbum> builder = new photoAlbumBuilderImp();
    model = photoAlbumReader.parseFile(inFile, builder);
    htmlView view = new htmlView(model, filename);
  }
}
