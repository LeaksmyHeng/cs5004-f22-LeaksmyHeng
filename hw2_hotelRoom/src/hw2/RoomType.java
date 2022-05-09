package hw2;

/**
 * Create an enum that shows the three categories of the rooms.
 */
public enum RoomType { SINGLE(1), DOUBLE(2), FAMILY(4);

  private int value;
  RoomType(int value) {
    this.value = value;
  }

  public int getValue() {
    return value;
  }
}
