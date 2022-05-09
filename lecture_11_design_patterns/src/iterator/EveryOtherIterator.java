package iterator;

import java.util.Iterator;

public class EveryOtherIterator<T> implements Iterator<T> {

  private Iterator<T> source;

  public EveryOtherIterator(Iterator<T> source) { // take an iterator as a source, and skip
    this.source = source;
  }

  @Override
  public boolean hasNext() {
    return source.hasNext();  // composition and delegation again!
  }

  @Override
  public T next() {
    T retVal = source.next();
    if (source.hasNext()) { // skip if we can
      source.next();
    }
    return retVal;
  }

  public static void main(String[] args) {
    SquaresSequence ss = new SquaresSequence(2, 30); // Java will autobox for us
    EveryOtherIterator skippy = new EveryOtherIterator(ss.iterator());
    /*
    while (skippy.hasNext()) {
      System.out.println(skippy.next());
    }
    */

    System.out.println("Skippy 2 in full effect!");
    EveryOtherIterator skippy2 = new EveryOtherIterator(skippy);
    while (skippy2.hasNext()) {
      System.out.println(skippy2.next());
    }
  }
}

