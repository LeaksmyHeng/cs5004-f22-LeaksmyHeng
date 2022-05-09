package question10;

public class SaleHouse extends AbstractSale implements IListing {

  public SaleHouse(String ID, Integer numberOfBedrooms, Integer numberOfBathrooms, PropertyCategory category, double sizeInSquareFeet) throws IllegalArgumentException {
    super(ID, numberOfBedrooms, numberOfBathrooms, category, sizeInSquareFeet);
  }
}
