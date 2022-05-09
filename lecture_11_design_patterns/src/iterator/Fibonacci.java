package iterator;

import java.util.Iterator;

/**
 * Fib Rule: x(n) = x(n-1) + x(n-2)
 */
public class Fibonacci implements Iterable<Integer> {
  private class FibonacciIterator implements Iterator<Integer> {
    /** Previous and previous_previous elements */
    private int previousPrevious = 0, previous = 1;

    @Override
    public boolean hasNext() {
      return true;
    }

    @Override
    public Integer next() {
      int value = previousPrevious + previous;
      previousPrevious = previous;
      previous = value;
      return value;
    }

    @Override
    public void remove() {}
  }

  @Override
  public Iterator<Integer> iterator() {
    return new FibonacciIterator();
  }


  public static void main(String [] args ) {
    Fibonacci fibonacci = new Fibonacci();
    Iterator<Integer> fibIt = fibonacci.iterator();
    for( int i=0; i<10; i++) { // get first 10 fib #'s
      if (fibIt.hasNext()) // not really needed since always true, but good practice
        System.out.println(fibIt.next());
    }

    System.out.println("Alternate approach - use a for-each loop");

    for( int j : fibonacci ) {
      if (j > 100 ) break;
      System.out.println(j);
    }
  }
}
