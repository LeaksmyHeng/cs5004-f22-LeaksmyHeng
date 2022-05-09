import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import cs5004.collections.EmptyPriorityQueueException;
import cs5004.collections.ListPriorityQueue;
import cs5004.collections.PriorityQueue;
import org.junit.Test;

/**
 * Create a test for ListPriorityQueue.
 */
public class testlistpriorityqueue {

  /**
   * Test the isEmpty, add, pop, and peek.
   */
  @Test
  public void testAddAndPeek() throws EmptyPriorityQueueException {
    PriorityQueue test1;
    test1 = ListPriorityQueue.createEmpty();
    test1 = test1.add(10, "Task 10");
    assertEquals(test1.peek(), "Task 10");
    test1 = test1.add(9, "Task 09");
    test1 = test1.add(8, "Task 08");
    test1 = test1.add(7, "Task 07");
    test1 = test1.add(3, "Task 03");
    test1 = test1.add(4, "Task 04");
    test1 = test1.add(6, "Task 06");
    assertFalse(test1.isEmpty());
    assertEquals(test1.peek(), "Task 10");
    assertEquals(test1.pop().peek(), "Task 09");
    // test pop and peek return a new ListPriorityQueue
    assertEquals(test1.peek(), "Task 10");
    assertEquals(test1.pop().pop().peek(), "Task 08");
  }

  /**
   * Test for createEmpty.
   */
  @Test
  public void testPriority() throws EmptyPriorityQueueException {
    PriorityQueue test2 = ListPriorityQueue.createEmpty();
    assertNotNull(test2);
    assertTrue(test2.isEmpty());
    test2 = test2.add(1, "Task 01");
    test2 = test2.pop();
    assertNotNull(test2);
  }

  /**
   * Test priority threshold.
   */
  @Test (expected = IllegalArgumentException.class)
  public void testPriorityOutOfBound1() {
    PriorityQueue test2 = ListPriorityQueue.createEmpty();
    test2.add(11, "Test 11");
    assertTrue(test2.isEmpty());
  }

  /**
   * Test priority threshold.
   */
  @Test (expected = IllegalArgumentException.class)
  public void testPriorityOutOfBound2() {
    PriorityQueue test3 = ListPriorityQueue.createEmpty();
    test3.add(-1, "Test 0");
    assertTrue(test3.isEmpty());
  }

  /**
   * Test Equal for isEmpty.
   */
  @Test
  public void testIsEqual() {
    PriorityQueue test3 = ListPriorityQueue.createEmpty();
    PriorityQueue test4 = ListPriorityQueue.createEmpty();
    assertEquals(test4, test3);
    test3 = test3.add(1, "Add new");
    assertNotEquals(test3, test4);
  }

  /**
   * Test throw EmptyPriorityQueueException on peek.
   */
  @Test (expected = EmptyPriorityQueueException.class)
  public void testPeekIllegal() throws EmptyPriorityQueueException {
    PriorityQueue test3 = ListPriorityQueue.createEmpty();
    test3.peek();
  }

  /**
   * Test throw EmptyPriorityQueueException on pop.
   */
  @Test (expected = EmptyPriorityQueueException.class)
  public void testPopIllegal() throws EmptyPriorityQueueException {
    PriorityQueue test3 = ListPriorityQueue.createEmpty();
    test3.pop();
  }
}
