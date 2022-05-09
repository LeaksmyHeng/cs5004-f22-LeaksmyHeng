package shapes;

import java.awt.geom.Point2D;

public abstract class vAbstractShape {
  // next need to make circle and ractangle the child class of this. by doing extend vAbstractShape
  // instead of implement Shape.
  // protected could be access by the child class but not the outsider.
  protected vPoint2D reference;

  public vAbstractShape(vPoint2D reference) {
    this.reference = reference;
  }

  @Override
  public double distanceFromOrigin() {
    return this.reference.distToOrigin();
  }


  @Override
  public int compareTo(vShape s) {
    double areaThis = this.area();
    double areaOther = s.area();

    if (areaThis > areaOther) {
      return -1;
    }
    else if (areaThis < areaOther) {
      return 1;
    }
    return 0;
  }
}
