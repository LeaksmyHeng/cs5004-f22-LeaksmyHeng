package cs5004.collections;

/**
 * Create an Empty PriorityQueue which will be implemented in the createEmpty().
 */
public class ListPriorityQueueEmpty implements PriorityQueue {
  @Override
  public Boolean isEmpty() {
    return true;
  }

  @Override
  public PriorityQueue add(Integer priority, String value) throws IllegalArgumentException {
    PriorityNode node = new PriorityNode(priority, value);
    return new ListPriorityQueue(node, this);
  }

  @Override
  public String peek() throws EmptyPriorityQueueException {
    throw new EmptyPriorityQueueException();
  }

  @Override
  public PriorityQueue pop() throws EmptyPriorityQueueException {
    throw new EmptyPriorityQueueException();
  }
}
