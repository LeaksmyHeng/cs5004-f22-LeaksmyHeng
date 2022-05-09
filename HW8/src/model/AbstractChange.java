package model;

/**
 * Create an abstract class which we will use in the IPhotoAlbum.
 * startTimeFrame is when the shape start to appear.
 * endTimeFrame is when the shape stop appearing.
 * The compare to method will help when we build the view - further description is below.
 */
public class AbstractChange implements IChange {
  private final IShape shape;

  public AbstractChange(IShape shape) {
    if (shape == null) {
      throw new IllegalArgumentException("Shape cannot be null.");
    }
    this.shape = shape;
  }

  @Override
  public IShape getShapeID() {
    return this.shape;
  }

  @Override
  public String getShapeName() {
    return this.shape.shapeName();
  }
}
