package doubledispatch;

/**
 * Create an interface class called ISpaceExplorer.
 */
public interface ISpaceExplorer {
  /**
   * Visit class to check if explorer visit Mercury.
   */
  void visit(Mercury mercury);

  /**
   * Visit class to check if explorer visit Mars.
   */
  void visit(Mars mars);

  /**
   * Visit class to check if explorer visit Venus.
   */
  void visit(Venus venus);

  /**
   * If explorer visit other planets besides Mars, Venus or Mercury then default to Unknown Planet.
   */
  default void visit(IPlanet aPlanet) {
    SimulationBuilder.addToLog("Visiting an unknown planet");
  }
}
