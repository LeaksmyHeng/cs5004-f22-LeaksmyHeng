package hw2;

/**
 * This class is used to create a mail item.
 */
public class MailItem {
  private int width;
  private int height;
  private int depth;
  private Recipient recipient;

  /**
   * Constructs a mailItem object. The constructors take 4 parameters including width, height,
   * depth and recipient.
   */
  public MailItem(int width, int height, int depth, Recipient recipient)
          throws IllegalArgumentException {
    this.width =  width;
    this.height = height;
    this.depth = depth;
    this.recipient = recipient;

    if (width < 1 || height < 1 || depth < 1) {
      throw new IllegalArgumentException("Width, height and depth cannot be less than 1");
    }

    if (recipient == null) {
      throw new IllegalArgumentException("Mail items must have a recipient.");
    }
  }

  /**
   * Create a getRecipient method that would show us who the recipient is.
   */
  public Recipient getRecipient() {
    return recipient;
  }

  /**
   * Create a getter method to retrieve MailItem's width.
   */
  public int getWidth() {
    return this.width;
  }

  /**
   * Create a getter method to retrieve MailItem's height.
   */
  public int getHeight() {
    return this.height;
  }

  /**
   * Create a getter method to retrieve MailItem's depth.
   */
  public int getDepth() {
    return this.depth;
  }
}
