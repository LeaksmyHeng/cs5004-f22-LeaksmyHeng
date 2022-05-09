package cs5004.collections;

import java.util.Objects;

/**
 * Create a ListPriorityQueue that will implement the PriorityQueue interface.
 */
public class ListPriorityQueue implements PriorityQueue {
  private int priority;
  private String value;
  private PriorityQueue rest;

  /**
   * Create a constructor for our ListPriorityQueue.
   */
  public ListPriorityQueue(int priority, String value)
          throws IllegalArgumentException {
    if (priority > 10 || priority < 0) {
      throw new IllegalArgumentException("Priority cannot be less than 1 or more than 10");
    }
    this.priority = priority;
    this.value = value;
    this.rest = new ListPriorityQueueEmpty();
  }

  /**
   * Another constructor that take rest as another argument.
   */
  public ListPriorityQueue(int priority, String value, PriorityQueue rest)
          throws IllegalArgumentException {
    if (priority > 10 || priority < 0) {
      throw new IllegalArgumentException("Priority cannot be less than 1 or more than 10");
    }
    this.priority = priority;
    this.value = value;
    this.rest = rest;
  }

  /**
   * Create a static method for createEmpty.
   */
  public static PriorityQueue createEmpty() {
    return new ListPriorityQueueEmpty();
  }

  /**
   * Create a static method for createEmpty.
   */
  @Override
  public Boolean isEmpty() {
    return false;
  }

  @Override
  public PriorityQueue add(Integer priority, String value) throws IllegalArgumentException {
    if (priority > 10 || priority < 1) {
      throw new IllegalArgumentException("Priority can't be less than 1 or greater than 10");
    }
    ListPriorityQueue newList;
    if (priority > getPriority()) {
      newList = new ListPriorityQueue(priority, value,
              new ListPriorityQueue(getPriority(), getValue(), getRest()));
      return newList;
    }
    else {
      newList = new ListPriorityQueue(getPriority(), getValue(), this.rest.add(priority, value));
      return newList;
    }
  }

  @Override
  public String peek() throws EmptyPriorityQueueException {
    if (isEmpty()) {
      throw new EmptyPriorityQueueException();
    }
    return this.getValue();
  }

  @Override
  public PriorityQueue pop() throws EmptyPriorityQueueException {
    if (isEmpty()) {
      throw new EmptyPriorityQueueException();
    }
    if (this.rest.isEmpty()) {
      return new ListPriorityQueueEmpty();
    }
    else {
      ListPriorityQueue newList = (ListPriorityQueue) rest;
      return newList;
    }
  }

  /**
   * Create a getValue method for our Node.
   */
  public String getValue() {
    return this.value;
  }

  /**
   * Create a get priority for our node.
   */
  public int getPriority() {
    return this.priority;
  }

  /**
   * Create a get Next getter.
   */
  public PriorityQueue getRest() {
    return this.rest;
  }

  /**
   * Create an equals method to compare 2 ListPriorityQueue object.
   */
  @Override
  public boolean equals(Object other) {
    if (this == other) {
      return true;
    }
    if (this.getClass() == other.getClass()) {
      ListPriorityQueue o = (ListPriorityQueue) other;
      if (o.isEmpty() && this.isEmpty()) {
        return true;
      }
      else if (this.rest.isEmpty() && ((ListPriorityQueue) other).rest.isEmpty()) {
        return Objects.equals(this.value, ((ListPriorityQueue) other).value)
                && this.priority == ((ListPriorityQueue) other).priority;
      }
      else if (this.rest == null && o.rest == null) {
        return  Objects.equals(this.getValue(), o.getValue())
                && this.getPriority() == o.getPriority();
      }
      else if (this.rest != null && o.rest != null) {
        return Objects.equals(this.getValue(), o.getValue())
                && this.getPriority() == o.getPriority()
                && Objects.equals(this.rest, o.rest);
      }
      return false;
    }
    return false;
  }

  /**
   * Create a hashcode.
   */
  public int hashCode() {
    return Objects.hash(getPriority(), getValue(), getRest());
  }

  /**
   * Create a toString method.
   */
  public String toString() {
    return "Priority: " + this.getPriority()
            + " Value: " + this.getValue()
            + " Next: " + this.getRest().toString();
  }
}
