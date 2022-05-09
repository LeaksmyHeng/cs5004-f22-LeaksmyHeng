package cs5004.collections;

import java.util.Objects;

/**
 * Create a List Priority Queue class that implement PriorityQueue interface.
 */
public class ListPriorityQueue implements PriorityQueue {
  private PriorityNode node;
  private PriorityQueue rest;

  /**
   * Create a constructor for ListPriorityQueue.
   */
  public ListPriorityQueue(PriorityNode node, PriorityQueue rest) {
    this.node = node;
    this.rest = rest;
  }

  /**
   * Create a constructor for ListPriorityQueue.
   */
  public ListPriorityQueue(PriorityNode node) {
    this.node = node;
    this.rest = null;
  }

  /**
   * Create a static method for createEmpty.
   */
  public static PriorityQueue createEmpty() {
    return new ListPriorityQueueEmpty();
  }

  @Override
  public Boolean isEmpty() {
    return false;
  }

  @Override
  public PriorityQueue add(Integer priority, String value) throws IllegalArgumentException {
    if (priority > 10 || priority < 1) {
      throw new IllegalArgumentException("Add: Priority can't be less than 1 or more than 10.");
    }
    else if (value == null) {
      throw new IllegalArgumentException("Add: value can't be null.");
    }
    else {
      ListPriorityQueue newList;
      PriorityNode temp = new PriorityNode(priority, value);
      if (priority >= node.getPriority()) {
        newList = new ListPriorityQueue(temp, this);
        return newList;

      }
      else {
        this.rest = this.rest.add(priority, value);
        return this;
      }
    }
  }

  @Override
  public String peek() throws EmptyPriorityQueueException {
    if (isEmpty()) {
      throw new EmptyPriorityQueueException();
    }
    else {
      return node.getValue();
    }
  }

  @Override
  public PriorityQueue pop() throws EmptyPriorityQueueException {
    if (isEmpty()) {
      throw new EmptyPriorityQueueException();
    }
    if (this.rest == null) {
      return new ListPriorityQueueEmpty();
    }
    else {
      this.rest = this.rest.pop();
      return this;
    }
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
      if (this.rest != null && o.rest != null) {
        return Objects.equals(this.node.getValue(), o.node.getValue())
                && this.node.getPriority() == o.node.getPriority()
                && this.rest.equals(((ListPriorityQueue) other).rest);
      }
      else if (this.rest == null && o.rest == null) {
        return Objects.equals(this.node.getValue(), o.node.getValue())
                && this.node.getPriority() == o.node.getPriority();
      }
      return false;
    }
    return false;
  }

  /**
   * Create a hashcode.
   */
  public int hashCode() {
    return Objects.hash(node.getPriority(), node.getValue(), rest);
  }

  /**
   * Create a toString method.
   */
  public String toString() {
    return "Priority: " + this.node.getPriority()
            + " Value: " + this.node.getValue()
            + " Next: " + rest;
  }
}
