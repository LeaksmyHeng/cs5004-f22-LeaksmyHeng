package registration;

/**
 * Create a Person class.
 */
public class Person {
  private String name;
  private String address;

  /**
   * Create a constructor for a Person class.
   */
  public Person(String name, String address) {
    this.name = name;
    this.address = address;
  }

  /**
   * Create a getName for Person.
   */
  public String getName() {
    return this.name;
  }

  /**
   * Create a getAddress for Person.
   */
  public String getAddress() {
    return this.address;
  }

  /**
   * Create a toString for Person.
   */
  @Override
  public String toString() {
    return name + ", " + address;
  }

  /**
   * Overide equals method for person class.
   */
  @Override
  public boolean equals(Object other) {
    if (this == other) {
      return true;
    }
    if (this.getClass() == other.getClass()) {
      Person o = (Person) other;
      return this.name.equals(o.name) && this.address.equals(o.address);
    }
    return false;
  }
}