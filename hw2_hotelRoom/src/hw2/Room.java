package hw2;

/**
 * Create a class that represent various types of hotel room and its booking system.
 */
public class Room {
  private int maximumOccupancy;
  private int numberOfGuests;
  private double price;

  /**
   * Constructs a Room object and initializes its to the given
   * room type, and price. Number of guest is initialized to 0.
   *
   * @param roomType    the type of room that we specify in the enum part
   * @param price       the price of the room
   */
  public Room(RoomType roomType, double price) throws IllegalArgumentException {
    this.price = price;
    this.numberOfGuests = 0;
    this.maximumOccupancy = roomType.getValue();
    if (price < 0) {
      throw new IllegalArgumentException("Price must be positive.");
    }
  }

  /**
   * Create a method to check whether the room is available.
   */
  public boolean isAvailable() {
    // Room is available if the number of guests assigned to the room is 0.
    if (this.numberOfGuests == 0) {
      return true;
    }
    else if (this.numberOfGuests > 0) {
      return false;
    }
    return false;
  }

  /**
   * Create a method to check if the booking room by setting the room's
   * number of guests to the value of the parameter passed in.
   *
   * @param numberOfGuests number of guests that will be assigned to the room
   */
  public int bookRoom(int numberOfGuests) {
    // Room is booked if the room is available and the number of guests passed is greather than 0
    // but less than or equal to maximum occupancy.
    if (isAvailable() && numberOfGuests > 0 && numberOfGuests <= this.maximumOccupancy) {
      return this.numberOfGuests = numberOfGuests;
    }
    return this.numberOfGuests;
  }

  /**
   * Create a getter method to get the number of guest in the room.
   */
  public int getNumberOfGuests() {
    return this.numberOfGuests;
  }
}
