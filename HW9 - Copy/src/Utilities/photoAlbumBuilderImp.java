package Utilities;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import model.IPhotoAlbum;
import model.PhotoAlbum;
import model.shapeType;

/**
 * Create a photoAlbumBuilderImp that implement photoAlbumBuilder interface. This class is used
 * to populate the correct contents of a text file to the IPhotoAlbum model.
 * */
public class photoAlbumBuilderImp implements photoAlbumBuilder<IPhotoAlbum> {
  private IPhotoAlbum model = new PhotoAlbum(0, 0, 900, 900);
  private Map<String, String> map;
  private List<String> list;

  /**
   * The constructor for the class.
   */
  public photoAlbumBuilderImp() {
    this.map = new HashMap<>();
    this.list = new ArrayList<>();
  }

  /**
  * Build the final document.
  * */
  @Override
  public IPhotoAlbum build() {
    return model;
  }


  @Override
  public photoAlbumBuilder<IPhotoAlbum> addShape(String name, String type, int lx, int ly, int width, int height, int red, int green, int blue) {
    if (type.equalsIgnoreCase("rectangle")) {
      model.addShape(name, shapeType.RECTANGLE, lx, ly, red, green, blue, width, height);
      list.add(name);
      }
    else if (type.equalsIgnoreCase("oval")) {
      //System.out.println(name+ " " + " " + type + " " + lx + " " + ly + " " + width + " " + height + " " + red + " " + green + " " + blue);
      model.addShape(name, shapeType.OVAL, lx, ly, red, green, blue, width, height);
      list.add(name);
      }
    else {
      throw new IllegalArgumentException("Shape is not valid");
    }
    return this;
  }

  @Override
  public void snapshot(String description) {
    if (description == null || description.equals("")) {
      description = "";
    }
    model.snapshot(description);
  }

  @Override
  public void changePosition(String shapeID, int toX, int toY) {
    model.changePosition(shapeID, toX, toY);
  }

  @Override
  public void changeShapeSize(String shapeID, int toWidth, int toHeight) {
    model.changePosition(shapeID, toWidth, toHeight);
  }

  @Override
  public void changeColor(String shapeID, int toR, int toG, int toB) {
    model.changeColor(shapeID, toR, toG, toB);
  }

  @Override
  public void remove(String shapeId) {
    model.remove(shapeId);
  }
}
