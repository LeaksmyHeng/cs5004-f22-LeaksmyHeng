package Question9;

import java.util.LinkedList;
import java.util.List;

public class MarsVisitorMain {
  public static void main(String[] args) {
    Pump pump = new Pump();
    IPumpComponentVisitor drone = new PumpComponentVisitor();
    pump.inspectParts(drone);
    System.out.println("=> Status of Anti-matter Pump #1:");
    System.out.println(drone.getLog());

    drone = new PumpComponentVisitor(); // make a new drone for next inspection
    pump.inspectParts(drone);
    System.out.println("==> Status of Anti-matter Pump #1 (again):");
    System.out.println(drone.getLog());

    List<IPumpComponent> parts = new LinkedList<>();
    parts.add(new Drill(Drill.Status.GOOD));
    parts.add(new Pipe(70));
    parts.add(new Motor(true));
    parts.add(new IntakeValve(true));

    drone = new PumpComponentVisitor(); // build a new drone, new status, etc.
    pump = new Pump(parts);
    pump.inspectParts(drone);
    System.out.println("===> Status of Anti-matter Pump #2:");
    System.out.println(drone.getLog());

    List<IPumpComponent> parts1 = new LinkedList<>();
    parts1.add(new Drill(Drill.Status.GOOD));
    parts1.add(new Pipe(125));
    parts1.add(new Motor(true));
    parts1.add(new IntakeValve(true));

    drone = new PumpComponentVisitor(); // build a new drone, new status, etc.
    pump = new Pump(parts1);
    pump.inspectParts(drone);
    System.out.println("===> Status of Anti-matter Pump #3:");
    System.out.println(drone.getLog());

  }
}


