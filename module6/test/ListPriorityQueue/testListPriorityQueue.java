package ListPriorityQueue;

import org.junit.Before;
import org.junit.Test;

import cs5004.collections.EmptyPriorityQueueException;
import cs5004.collections.ListPriorityQueue;
import cs5004.collections.PriorityNode;
import cs5004.collections.PriorityQueue;

/**
 * Create a test for ListPriorityQueue.
 */
public class testListPriorityQueue {
  ListPriorityQueue test;

  /**
   * Setting up the test.
   */
  @Before
  public void setUp() {
    PriorityQueue test = new ListPriorityQueue(new PriorityNode(1, "task1"));
    test.add(2, "Task 2");
    test.add(3, "Task 3");
    test.add(4, "Task 4");
    test.add(1, "Task 5");
    test.add(4, "Task 5");
  }

  @Test
  public void add() throws EmptyPriorityQueueException {
    System.out.println(test);
  }
}
