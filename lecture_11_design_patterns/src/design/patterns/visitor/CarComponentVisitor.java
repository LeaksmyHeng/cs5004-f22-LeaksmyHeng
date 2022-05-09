package design.patterns.visitor;

public interface CarComponentVisitor {
  void visit(Engine engine);
  void visit (Transmission transmission);
  void visit (BrakeSystem breaks);
  void visit(LaneWarningSystem warningSystem);
}
