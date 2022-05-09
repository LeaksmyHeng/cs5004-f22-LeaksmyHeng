package design.patterns.visitor;

public interface ICar extends CarComponent {
  void diagnoseParts();
  void prepForSale();
  void addPart(CarComponent carComponent);
}
