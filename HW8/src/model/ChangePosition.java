package model;

public class ChangePosition extends AbstractChange {
  private final int fromX;
  private final int toX;
  private final int fromY;
  private final int toY;

  public ChangePosition(IShape shape, int toX, int toY) {
    super(shape);
    this.fromX = shape.getX();
    this.toX = toX;
    this.fromY = shape.getY();
    this.toY = toY;
    shape.setX(toX);
    shape.setY(toY);
  }

  public int getFromX() {
    return this.fromX;
  }

  public int getFromY() {
    return this.fromY;
  }

  public int getToX() {
    return this.toX;
  }

  public int getToY() {
    return this.toY;
  }

  @Override
  public String toString() {
    return String.format("ShapeID: %s moves from (%d, %d) to (%d, %d)\n",
            this.getShapeID().shapeName(), getFromX(), getFromY(), getToX(), getToY());
  }
}
