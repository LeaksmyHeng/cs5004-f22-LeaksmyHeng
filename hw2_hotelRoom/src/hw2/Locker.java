package hw2;

/**
 * Create a Locker class with include 2 methods addMail and pickupMail.
 */
public class Locker {
  private int maxWidth;
  private int maxHeight;
  private int maxDepth;
  private MailItem mailItem;

  /**
   * Create a constructor for Locker class which take 3 parameters:
   * maxWidth, maxHeight and maxDepth. Throw IllegalArumentException if any of the
   * parameters are less than 1.
   */
  public Locker(int maxWidth, int maxHeight, int maxDepth) throws IllegalArgumentException {
    this.maxWidth = maxWidth;
    this.maxHeight = maxHeight;
    this.maxDepth = maxDepth;
    this.mailItem = null;

    if (maxWidth < 1 || maxHeight < 1 || maxDepth < 1) {
      throw new IllegalArgumentException("maxWidth, maxHeight or maxDepth can't be less than 1");
    }
  }


  /**
   * Create void addMail method with take 1 parameter mailItem.
   */
  public void addMail(MailItem mailItem) {
    if (this.mailItem == null && mailItem.getWidth() <= this.maxWidth
            && mailItem.getHeight() <= this.maxHeight
            && mailItem.getDepth() <= this.maxDepth) {
      this.mailItem = mailItem;
    }
  }

  /**
   * Create a pickupMail method which take 1 parameter: a recipient. This method will
   * return the mailItem.
   */
  public MailItem pickupMail(Recipient recipient) {
    if (this.mailItem != null) {
      Recipient other_recipient = this.mailItem.getRecipient();
      if (recipient.equals(other_recipient)) {
        MailItem mailItemInit = mailItem;
        mailItem = null;
        return mailItemInit;
      }
      else if (!recipient.equals(other_recipient)) {
        return null;
      }
    }
    return null;
  }

  /**
   * Create a getter for getMailItem.
   */
  public MailItem getMailItem() {
    return this.mailItem;
  }
}
