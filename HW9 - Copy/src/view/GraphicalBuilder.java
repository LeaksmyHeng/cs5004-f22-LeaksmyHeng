package view;

import java.awt.*;
import java.util.Map;
import java.util.Objects;

import javax.swing.*;

import model.IPhotoAlbum;
import model.IShape;

/**
 * Create a GraphicalBuilder class that will be used to build the interactive view.
 */
public class GraphicalBuilder extends JPanel {
  private final IPhotoAlbum model;
  private int index = 0;

  /**
   * Create the constructor for the graphicalBuilder class by taking 1 argument which is the
   * IPhotoAlbum model.
   */
  public GraphicalBuilder(IPhotoAlbum model) {
    super();
    this.model = model;
    // This index will be used to get to the next snapshot or previous snapshot. The default index is 0.
    this.index = 0;
  }

  /**
   * create another constructor for GraphicalBuilder and in here we take 2 argument, model and index.
   * The index is used to get to the next or previous snapshot or any of the index in snapshotList key.
   */
  public GraphicalBuilder(IPhotoAlbum model, int index) {
    super();
    this.model = model;
    this.index = index;
  }

  /**
   * Overriding the paintComponent method so that we could loop through a certain snapshot (whatever
   * snapshot that we identify in the index) to get the information of the shapes in that certain snapshot.
   */
  public void paintComponent(Graphics shape) {
      super.paintComponent(shape);
      Graphics2D shape2D = (Graphics2D) shape;
      String snapShotKey = "";

      if (model.getSnapShotList().size() > 0) {
        snapShotKey = model.getSnapShotList().keySet().toArray()[index].toString();
        Map<String, IShape> shapes = model.getSnapShotList().get(snapShotKey);
        for (String shapeKey : shapes.keySet()) {
          shape2D.setColor(new Color(shapes.get(shapeKey).getR(), shapes.get(shapeKey).getG(), shapes.get(shapeKey).getB()));
          if (Objects.equals(shapes.get(shapeKey).shapeType().toString(), "RECTANGLE")) {
            shape2D.fillRect(shapes.get(shapeKey).getX(), shapes.get(shapeKey).getY(), shapes.get(shapeKey).getWidth(), shapes.get(shapeKey).getHeight());
            shape2D.drawRect(shapes.get(shapeKey).getX(), shapes.get(shapeKey).getY(), shapes.get(shapeKey).getWidth(), shapes.get(shapeKey).getHeight());
          }
          if (Objects.equals(shapes.get(shapeKey).shapeType().toString(), "OVAL")) {
            shape2D.fillOval(shapes.get(shapeKey).getX(), shapes.get(shapeKey).getY(), shapes.get(shapeKey).getWidth(), shapes.get(shapeKey).getHeight());
            shape2D.drawOval(shapes.get(shapeKey).getX(), shapes.get(shapeKey).getY(), shapes.get(shapeKey).getWidth(), shapes.get(shapeKey).getHeight());
          }
        }
      }
  }

  public void setIndex(int index) {
    this.index = index;
  }
}
