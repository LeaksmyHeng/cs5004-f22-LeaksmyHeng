package doubledispatch;

/**
 * Create interface for IPlanet.
 */
public interface IPlanet {

  /**
   * Check if explorer accept to explore certain planet.
   */
  void accept(ISpaceExplorer explorer);
}
