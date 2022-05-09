package hw2;

import java.util.Objects;

/**
 * This is a Recipient class which include first name, last name and the email address.
 */
public class Recipient {
  private String firstName;
  private String lastName;
  private String email;

  /**
   * Construct a Recipient object that has the provided first name, last name and email address.
   *
   * @param firstName     recipient's first name
   * @param lastName      recipient's last name
   * @param email         recipient's email
   */
  public Recipient(String firstName, String lastName, String email)
          throws IllegalArgumentException {
    this.firstName = firstName;
    this.lastName = lastName;
    this.email = email;

    // Raise Illegal ArgumentException if any of the 3 parameters are null or empty string.
    if (firstName == null || firstName == "") {
      throw new IllegalArgumentException("First name cannot be null");
    }
    if (lastName == null || lastName == "") {
      throw new IllegalArgumentException("Last name cannot be null");
    }
    if (email == null || email == "") {
      throw new IllegalArgumentException("Email address cannot be null");
    }
  }

  /**
   * Create a toString method for Recipient class.
   */
  public String toString() {
    return this.firstName + " " + this.lastName + " Email:" + this.email;
  }

  /**
   * Create a method that is used to compare a recipient instance to another recipient object.
   */
  public boolean equals(Object other) {
    if (this == other) {
      return true;
    }
    if (this.getClass() == other.getClass()) {
      Recipient o = (Recipient) other;
      if (Objects.equals(this.firstName, o.firstName)
              && Objects.equals(this.lastName, o.lastName)
              && Objects.equals(this.email, o.email)) {
        return true;
      }
    }
    return false;
  }
}
