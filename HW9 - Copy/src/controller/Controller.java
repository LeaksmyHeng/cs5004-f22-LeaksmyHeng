package controller;

import model.IPhotoAlbum;
import view.IView;

public class Controller implements IController {
  private IPhotoAlbum model;
  private IView view;
  private String output;

  public Controller(IPhotoAlbum model, IView view) {
    this.model = model;
    this.view = view;
  }

  public Controller(IPhotoAlbum model, IView view, String output) {
    this.model = model;
    this.view = view;
    this.output = output;
  }

  public void start() {
    if (view.getViewType().equalsIgnoreCase("web")) {
      view.output(output, view.getView());
    }
    if (view.getViewType().equalsIgnoreCase("graphical")) {
      view.makeVisible();
    }
  }
}
