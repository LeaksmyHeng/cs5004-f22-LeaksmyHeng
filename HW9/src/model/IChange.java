package model;

/**
 * Create an interface which we will use in the Abstract Change class.
 * This interface will allows us to get the shape, the start time and end time of our shape.
 */
public interface IChange {

  /**
   * This method will allows us to get the shapeID.
   */
  IShape getShapeID();

  /**
   * Get the name of the shape.
   */
  String getShapeName();
}
