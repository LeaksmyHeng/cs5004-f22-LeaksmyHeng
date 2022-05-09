package design.patterns.visitor;

public class CarSalesVisitor implements CarComponentVisitor {
  @Override
  public void visit(Engine engine) {
    System.out.println("Checklist: Selling car with engine: " + engine.getName());
  }

  @Override
  public void visit(Transmission transmission) {
    System.out.println("Checklist: top off transmission fluid! " );
  }

  @Override
  public void visit(BrakeSystem breaks) {
    System.out.println("Checklist: top off brake fluid! " );

    if(!breaks.getAbsStatus()) {
      System.out.println("WARNING: Anti-Lock Break System is OFF! Turn on before customer pick-up" );
    }

  }

  @Override
  public void visit(LaneWarningSystem laneSensor) {
    if (laneSensor.areSensorsActive() ) {
      System.out.println("Lande Warning sensors OK");
    } else {
      System.out.println("Lane Warning Sensors MALFUNCTION. Fix this before customer delivery");
    }

  }
}

