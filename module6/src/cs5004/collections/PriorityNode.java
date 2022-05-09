package cs5004.collections;

/**
 * Create a PriorityNode class.
 */
public class PriorityNode {
  private int priority;
  private String value;

  /**
   * Create a constructor for priority node.
   */
  public PriorityNode(int priority, String value) throws IllegalArgumentException {
    if (priority > 10 || priority < 1) {
      throw new IllegalArgumentException("Priority Node cannot be less than 1 or more than 10");
    }
    this.priority = priority;
    this.value = value;
  }

  /**
   * Create a getter method to get priority.
   */
  public int getPriority() {
    return this.priority;
  }

  /**
   * Create a getter method to get value.
   */
  public String getValue() {
    return this.value;
  }

  /**
   * Create a setter method for setPriority.
   */
  public int setPriority(int priority) {
    return this.priority = priority;
  }

  /**
   * Create a setter method for setValue.
   */
  public String setValue(String value) {
    return this.value = value;
  }
}
