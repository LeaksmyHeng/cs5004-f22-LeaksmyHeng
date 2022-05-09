package doubledispatch;

/**
 * Creating a Mars class that implements IPlanet interface.
 */
public class Mars implements IPlanet {
  @Override
  public void accept(ISpaceExplorer explorer) {
    explorer.visit(this);
  }
}
