package privateconstructors;

public abstract class AbstractShape implements IShape, Comparable<AbstractShape>{
  private Point centerPoint;

  public AbstractShape(int x, int y) {
    this.centerPoint = new Point(x,y);
  }

  protected int getX() {return this.centerPoint.getX();}
  protected int getY() {return this.centerPoint.getY();}

}
