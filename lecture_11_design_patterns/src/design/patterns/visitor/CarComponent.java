package design.patterns.visitor;

public interface CarComponent {
  void accept(CarComponentVisitor visitor);
}