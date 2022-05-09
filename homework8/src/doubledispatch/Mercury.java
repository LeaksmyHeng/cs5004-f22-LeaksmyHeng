package doubledispatch;

/**
 * Creating a Mercury class that implements IPlanet interface.
 */
public class Mercury implements IPlanet {
  @Override
  public void accept(ISpaceExplorer explorer) {
    explorer.visit(this);
  }
}
