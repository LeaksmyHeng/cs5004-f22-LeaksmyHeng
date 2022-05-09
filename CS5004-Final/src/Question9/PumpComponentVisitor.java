package Question9;

import java.util.LinkedHashMap;
import java.util.Map;

public class PumpComponentVisitor implements IPumpComponentVisitor {
  // Default pipe to 50
  Map<String, String> log = new LinkedHashMap<String, String>();
  Motor motor = new Motor(true);

  @Override
  public void visit(Pipe pipe) {
    if (pipe.getSealPct() < 70) {
      log.put("Drill Status", " Malfunction drill broken\n");
      log.put("Motor Status", " Pump malfunctioning -> turning off the motor.\n");
      log.put("Intake Status", " Intake malfunctioning -> closing valve.\n");
      log.put("Pipe Status", " Pipe < 70. Need to replace soon.\n");
    }
    else if (pipe.getSealPct() < 100 & pipe.getSealPct() >= 70) {
      log.put("Motor Status", " On.\n");
      log.put("Intake Status", " Open.\n");
      log.put("Pipe Status", " Pipe in between 100 & 75. Need to replace soon.\n");
    }
    else {
      log.put("Pipe Status", " Healthy\n");
    }
  }

  @Override
  public void visit(IntakeValve intakeValve) {
    log.put("Intake Status", " Intake malfunctioning -> closing valve.\n");
  }

  @Override
  public void visit(Motor motor) {
    log.put("Motor Status", " Pump malfunctioning -> turning off the motor.\n");
  }

  @Override
  public void visit(Drill drill) {
    if (drill.getStatus().toString().equalsIgnoreCase("broken")) {
      log.put("Drill Status", " Malfunction drill broken\n");
      log.put("Motor Status", " Pump malfunctioning -> turning off the motor.\n");
      log.put("Intake Status", " Intake malfunctioning -> closing valve.\n");
      log.put("Pipe Status", " Pipe in between 100 & 75. Need to replace soon.\n");

    }
    else {
      log.put("Drill Status", " Operational\n");
      log.put("Motor Status", " On.\n");
      log.put("Intake Status", " Open.\n");
      log.put("Pipe Status", " Pipe in between 100 & 75. Need to replace soon.\n");
    }
  }


  @Override
  public Map<String, String> getLog() {
    return log;
  }
}
