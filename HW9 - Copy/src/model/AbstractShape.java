package model;

import java.awt.*;

/**
 * Create the AbstractShape class that implement IShape interface.
 */
public class AbstractShape extends Position2D implements IShape {
  private Position2D pos;
  private Color color;
  private int width;
  private int height;
  private String shapeName;
  private shapeType type;

  /**
   * Create a constructor for the AbstractShape class.
   */
  public AbstractShape(int x, int y, int width, int height, int r, int g, int b, String name)
          throws IllegalArgumentException {
    super(x, y);
    this.width = width;
    this.height = height;
    this.shapeName = name;
    this.color = new Color(r, g, b);

    if (width < 0 || height < 0) {
      throw new IllegalArgumentException("Width and Height cannot be negative.");
    }
    if (name == null || name.equals("")) {
      throw new IllegalArgumentException("Shape name cannot be null");
    }
    if (r < 0 || g < 0 || b < 0) {
      throw new IllegalArgumentException("RGB color cannot be less than 0");
    }
    if (r > 255 || g > 255 || b > 255) {
      throw new IllegalArgumentException("RBG Color cannot be more than 255");
    }
  }


  @Override
  public int getX() {
    return this.x;
  }

  @Override
  public int getY() {
    return this.y;
  }

  @Override
  public int getWidth() {
    return this.width;
  }

  @Override
  public int getHeight() {
    return this.height;
  }

  @Override
  public int getR() {
    return this.color.getRed();
  }

  @Override
  public int getG() {
    return this.color.getGreen();
  }

  @Override
  public int getB() {
    return this.color.getBlue();
  }

  @Override
  public String shapeName() {
    return this.shapeName;
  }

  @Override
  public void setX(int x) {
    this.x = x;
  }

  @Override
  public void setY(int y) {
    this.y = y;
  }

  @Override
  public void setWidth(int width) {
    this.width = width;
  }

  @Override
  public void setHeight(int height) {
    this.height = height;
  }

  @Override
  public void setColor(int r, int g, int b) {
    this.color = new Color(r, g, b);
  }

  /**
   * All the methods below will be overwritten in each of the shape class: Rectangle and Oval class.
   */
  @Override
  public shapeType shapeType() {
    return null;
  }

  @Override
  public IShape copy() {
    return null;
  }
}
