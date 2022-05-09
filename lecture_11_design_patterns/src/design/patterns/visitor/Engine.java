package design.patterns.visitor;

class Engine implements CarComponent {
  private final String name;
  private final int oilLevel;

  public Engine(final String name, final int oilLevel) {
    this.name = name;
    this.oilLevel = oilLevel;
  }

  public String getName() { return this.name; }
  public int getOilLevel() { return this.oilLevel; }

  @Override
  public void accept(CarComponentVisitor visitor) {
    visitor.visit(this); // ask the visitor to visit us and do it's thing
  }
}

class Transmission implements CarComponent {
  private final int fluidLevel;

  public Transmission(final int fluidLevel) {
    this.fluidLevel = fluidLevel;
  }

  public int getOilLevel() { return this.fluidLevel; }

  @Override
  public void accept(CarComponentVisitor visitor) {
    visitor.visit(this); // ask the visitor to visit us and do it's thing
  }
}

class BrakeSystem implements CarComponent {
  private final int fluidLevel;
  private boolean absStatus;

  public BrakeSystem(final int fluidLevel, boolean absStatus) {
    this.fluidLevel = fluidLevel;
    this.absStatus = absStatus;
  }

  public int getFluidLevel() { return this.fluidLevel; }
  public boolean getAbsStatus() {return absStatus;}

  @Override
  public void accept(CarComponentVisitor visitor) {
    visitor.visit(this); // ask the visitor to visit us and do it's thing
  }
}

class LaneWarningSystem implements CarComponent {
  private boolean sensorsActive;

  public LaneWarningSystem(boolean sensorsActive) {
    this.sensorsActive = sensorsActive;
  }

  public boolean areSensorsActive() { return this.sensorsActive; }

  @Override
  public void accept(CarComponentVisitor visitor) {
    visitor.visit(this); // ask the visitor to visit us and do it's thing
  }
}
