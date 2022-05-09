package design.patterns.visitor;

public class CarDiagnosticVisitor implements CarComponentVisitor {
  @Override
  public void visit(Engine engine) {
    if(engine.getOilLevel() < 85) {
      System.out.println("Low oil for " + engine.getName() );
    }
    else {
      System.out.println("Oil level for " + engine.getName() + " is good" );
    }
  }

  @Override
  public void visit(Transmission transmission) {
    if(transmission.getOilLevel() < 85) {
      System.out.println("Low transmission fluid");
    }
    else {
      System.out.println("Transmission fluid level is OK" );
    }
  }

  @Override
  public void visit(BrakeSystem breaks) {
    if(breaks.getFluidLevel() < 85) {
      System.out.println("Low break fluid" );
    }
    else {
      System.out.println("Break fluid level OK " );
    }

    if(!breaks.getAbsStatus()) {
      System.out.println("WARNING: Anti-Lock Break System is OFF!" );
    }

  }

  @Override
  public void visit(LaneWarningSystem laneSensor) {
    if (laneSensor.areSensorsActive() ) {
      System.out.println("Lande Warning sensors OK");
    } else {
      System.out.println("Lane Warning Sensors MALFUNCTION");
    }

  }
}
