package question10;

public class AbstractSale implements IListing {
  private String id;
  private Integer numberOfBedrooms;
  private Integer numberOfBathrooms;
  private String category;
  private double sizeInSquareFeet;

  public AbstractSale(String ID, Integer numberOfBedrooms, Integer numberOfBathrooms, PropertyCategory category, double sizeInSquareFeet) throws IllegalArgumentException {
    if (numberOfBathrooms < 0 || numberOfBedrooms < 0 || sizeInSquareFeet < 0.0) {
      throw new IllegalArgumentException("Number of bathroom, bathroom and size can't be less than 0");
    }
    this.id = ID;
    this.numberOfBathrooms = numberOfBathrooms;
    this.numberOfBedrooms = numberOfBedrooms;
    this.sizeInSquareFeet = sizeInSquareFeet;
    this.category = String.valueOf(category);
  }

  public String getId() {
    return this.id;
  }

  public Integer getNumberOfBedrooms() {
    return this.numberOfBedrooms;
  }

  public Integer getNumberOfBathrooms() {
    return this.numberOfBathrooms;
  }

  public double getSizeInSquareFeet() {
    return this.sizeInSquareFeet;
  }

  public String getCategory() {
    return this.category;
  }

  @Override
  public double calculatePrice() {
    int pricePerSquareFeet = 200;
    double housePrice;
    housePrice = pricePerSquareFeet * getSizeInSquareFeet();
    if (getNumberOfBedrooms() > 3) {
      int extraMoney = 10000;
      housePrice = housePrice + extraMoney;
      if (getCategory().equalsIgnoreCase("LUXURY")) {
        int luxuryExtra = 50000;
        housePrice = housePrice + luxuryExtra;
      }
    }
    return housePrice;
  }
}
