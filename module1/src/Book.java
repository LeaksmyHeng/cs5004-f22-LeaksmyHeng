/**
 * This class represents a book. A book has a title, an author and a price
 */
public class Book {
  private String title;
  private Person author;
  private float price;

  /**
   * Construct a Book object that has the
   * provided title, author and  price
   *
   * @param title the title to be given to this book
   * @param author the author to be given to this book
   * @param price the price to be assigned to this book
   */

  public Book(String title, Person author, float price) {
    this.title = title;
    this.author = author;
    this.price = price;
  }

  /**
   * Return the title of this book
   * @return the title of this book
   */
  public String getTitle() {
    return this.title;
  }

  /**
   * Return the price of this book
   * @return the price of this book
   */
  public float getPrice() {
    return this.price;
  }

  /**
   * Return the author of this object
   * @return the author of this object as a @link{Person}
   */
  public Person getAuthor() {

    return this.author;
  }

  /**
   * Return a formatted string that contains the information
   * of this object. The string should be in the following format:
   *
   * Title: [title of the book]
   * Author: [first-name last-name]
   * Price: [Price as a decimal number with two numbers after decimal]
   *
   * @return the formatted string as above
   */
  public String toString() {
    String str;

    str = "Title: "+ this.title + "\n" +
            "Author: "+this.author + "\n";
    str = str + String.format("Price: %.2f",price);

    return str;
  }


  /*
  * Compute and return the price of this book with the given discount (aw a
  * percentage
  *
  * @param discount the percentage discount to be applied
  * @return the discounted price of this book
  */
  public float salePrice(float discount) throws IllegalArgumentException{
    if (discount < 0) {
      throw new IllegalArgumentException("Discount cannot be negative");
    }
    return this.price - (this.price*discount) / 100;
  }

  /*
  * Checking if the books have the same author
  */
  /*
  // but this won't make sense cause we are comparing the method in person class
  public boolean sameAuthor() {
    this.author.getYearOfBirth() = other.author.getYearOfBirth();
    this.author.getLastName() = other.author.getLastName();
  }
  */
  public boolean sameAuthor(Book other) {
    return this.author.same(other.author);
  }

  public Book discountBook(float discount) {
    float discountedPrice;
    try {
      discountedPrice = this.salePrice(discount);
      return new Book(this.title, this.author, discountedPrice);
    }
    catch (IllegalArgumentException e) {
      // This will be executed only if an IllegalArgumentException is thrown by the above method call

    }
    //return new Book(this.title, this.author, discountedPrice);
  }
}