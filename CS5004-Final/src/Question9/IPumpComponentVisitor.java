package Question9;

import java.util.Map;

public interface IPumpComponentVisitor {
  void visit(Drill drill);
  void visit(Motor motor);
  void visit(Pipe pipe);
  void visit(IntakeValve intakeValve);
  Map<String, String> getLog();
}
