package model;

/**
 * Enum class that listed all the shape that we support.
 */
public enum shapeType {
  OVAL("O"),
  RECTANGLE("R");

  String name;
  shapeType(String name) {
    this.name = name;
  }

  public String getName() {
    return this.name;
  }
}
