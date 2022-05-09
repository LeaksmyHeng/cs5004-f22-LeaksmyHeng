package doubledispatch;

/**
 * TerrainExplorer class for explorer who exploring life on planets.
 */
public  class LifeExplorer implements ISpaceExplorer {
  @Override
  public void visit(Mercury mercury) {
    SimulationBuilder.addToLog("Landing on Mercury...exploring for life");
  }

  @Override
  public void visit(Mars mars) {
    SimulationBuilder.addToLog("Landing on Mars...exploring for life");
  }

  @Override
  public void visit(Venus venus) {
    SimulationBuilder.addToLog("Landing on Venus...exploring life");
  }
}
