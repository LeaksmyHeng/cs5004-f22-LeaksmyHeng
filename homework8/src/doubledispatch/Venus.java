package doubledispatch;

/**
 * Creating a Venus class that implements IPlanet interface.
 */
public class Venus implements IPlanet {
  @Override
  public void accept(ISpaceExplorer explorer) {
    explorer.visit(this);
  }
}
