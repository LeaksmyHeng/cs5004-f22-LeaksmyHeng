package question10;

public class SaleCondo extends AbstractSale implements IListing {
  public SaleCondo(String ID, Integer numberOfBedrooms, Integer numberOfBathrooms, PropertyCategory category, double sizeInSquareFeet) throws IllegalArgumentException {
    super(ID, numberOfBedrooms, numberOfBathrooms, category, sizeInSquareFeet);
  }

  @Override
  public double calculatePrice() {
    int pricePerBedroom = 50000;
    int pricePerBathroom = 30000;
    int perSquarethreshold = 2000;
    double housePrice;
    housePrice = pricePerBathroom*getNumberOfBathrooms() + pricePerBedroom*getNumberOfBedrooms();
    if (getSizeInSquareFeet() > perSquarethreshold) {
      int extraMoney = 5000;
      housePrice = housePrice + extraMoney;
      if (getCategory().equalsIgnoreCase("LUXURY")) {
        int luxuryExtra = 50000;
        housePrice = housePrice + luxuryExtra;
      }
    }
    return housePrice;
  }
}
