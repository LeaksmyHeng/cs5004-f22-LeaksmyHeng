package Controller;

import java.util.List;

import model.IPhotoAlbum;
import model.IShape;

public class Controller {
  private IController control;
  private List<IShape> shapes;
  private IPhotoAlbum model;

  public Controller(IPhotoAlbum model, IController control) {
    if (model == null || control == null) {
      throw new IllegalStateException();
    }
    this.model = model;
    this.control = control;
  }
}


