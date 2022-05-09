package iterator;

import java.util.Iterator;

public class SquaresSequence implements  Iterable<Integer> { // int?

  private Integer start, end;

  public SquaresSequence(Integer start, Integer end) {
    this.start = start;
    this.end = end;
  }

  @Override
  public Iterator<Integer> iterator() {
    return new SequenceIterator(start, end);
  }

  private class SequenceIterator implements Iterator<Integer> {
    private Integer counter;
    private Integer end;

    private SequenceIterator(Integer start, Integer end) {
      counter = start;
      this.end = end;
    }

    @Override
    public boolean hasNext() {
      return counter.compareTo(end) <= 0;
    }

    @Override
    public Integer next() {
      Integer result = counter * counter;
      counter = counter + 1;
      return result;
    }
  }
  public static void main(String [] args ){
    SquaresSequence ss = new SquaresSequence(2, 30); // Java will autobox for us
    Iterator<Integer> it = ss.iterator();
    while(it.hasNext()) {
      System.out.println(it.next());
    }
  }
}

