import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

public class testBook {
  private Person pat;
  private  Book beaches;

  @Before
  public void setUp(){
    pat = new Person("Pat", "Conroy", 1948);
    beaches = new Book("Beaches", this.pat, 20);
  }


  @Test
  public void testSalePrice() {
    float discountPrice = beaches.salePrice(20);
    // taking 3 argument here as we specify the margin of error here.
    assertEquals(16.0f, discountPrice, 0.01);
  }

  @Test
  public void testSameAuthor() {
    Person anotherauthor1 = new Person("Patt", "Conroy", 1948);
    Book rosie = new Book("Rosie", anotherauthor1, 1950);
    Book gotitan = new Book("Go Titan", this.pat, 1948);
    assertTrue(beaches.sameAuthor(gotitan));
    assertFalse(beaches.sameAuthor(rosie));
  }

  @Test
  public void testDiscountedBook() {
    Book discountedBook = beaches.discountBook(20);
    assertTrue(beaches.sameAuthor(discountedBook));
    assertEquals(beaches.getTitle(), discountedBook.getTitle());
    assertEquals(16, discountedBook.getPrice(), 0.01);
  }

  @Test (expected =  IllegalArgumentException.class)
  public void testIllegalDiscount() {
    float discountedPrice;
    discountedPrice = beaches.salePrice(-20);
  }
}
