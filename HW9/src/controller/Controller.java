package controller;

import model.IPhotoAlbum;
import view.IView;

/**
 * Create a controller class that implement IController.
 */
public class Controller implements IController {
  private IPhotoAlbum model;
  private IView view;
  private String output;

  /**
   * The first constructor of the Controller class that takes only 2 argument: model and view.
   * This will be used in graphicalView.
   */
  public Controller(IPhotoAlbum model, IView view) {
    this.model = model;
    this.view = view;
  }

  /**
   * The second constructor of the controller class. This take 1 more argument on top of the arguments
   * above as it needs the output file name. This will be used in the html view.
   */
  public Controller(IPhotoAlbum model, IView view, String output) {
    this.model = model;
    this.view = view;
    this.output = output;
  }

  /**
   * The start method is used to execute the program cased on the view type.
   */
  public void start() {
    if (view.getViewType().equalsIgnoreCase("web")) {
      view.output(output, view.getView());
    }
    if (view.getViewType().equalsIgnoreCase("graphical")) {
      view.makeVisible();
    }
  }
}
