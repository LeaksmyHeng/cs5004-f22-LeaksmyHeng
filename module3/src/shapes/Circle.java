package shapes;

import java.util.Objects;

public class Circle extends AbstractShape implements IShape {
  private double radius;
  private Color color;

  public Circle(double radius) throws IllegalArgumentException {
    super(0, 0);
    if(radius < 0) {
      throw new IllegalArgumentException("Radius cannot be negative!");
    }
    this.radius = radius;
    this.color = Color.RED;
  }

  public Circle(double radius, int x, int y, Color color){ // overload
    super(x, y);
    if(radius < 0) {
      throw new IllegalArgumentException("Radius cannot be negative!");
    }
    this.radius = radius;
    // this.x = x;
    // this.y = y;
    this.color = color;
  }

  public double getArea() {
    return Math.PI * Math.pow(this.radius, 2);
  }

  public double getPerimeter() {
    return Math.PI * 2 * this.radius;
  }

  @Override
  public String toString() {
    return "Circle with radius:" + this.radius + " x:" + this.getY()
            + " y:" + this.getX() + " color:" + this.color.toString();
  }

  @Override
  public boolean equals(Object other) {
    if(this == other) {
      return true;
    }
    if(this.getClass() == other.getClass()) {
      Circle o = (Circle)other; // Cast object to Circle
      if((Double.compare(this.radius,o.radius) == 0) && (this.color.equals(o.color))
        && (this.getX() == o.getX()) && (this.getY() == o.getY())) {
        return true;
      }
    }
    return false;
  }
  @Override
  public int hashCode() {
    return Objects.hash(this.getX(), this.getY(), radius, color);
  }

}

