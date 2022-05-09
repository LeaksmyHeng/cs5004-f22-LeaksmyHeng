package shapelist;
import othershapes.IShape;

public interface IListShape {
  int count();
  int countAcc(); // Accumulator
  int countHelper(int accumulator);

  IListShape smallerThan(double area); // filter
  IListShape sortByAreaSize(); // sort
  IListShape insert(IShape shape);
}
