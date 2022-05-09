package stock;

import java.text.DecimalFormat;

/**
 * This class represents a stock to be traded. We are focusing on selling stock.
 */
public class Stock {
  private String symbol;
  private String name;
  private double cost;
  private double currentPrice;

  /**
   * Construct a stock object and initialize it to the given stockSymbol, stockName, and stockCost.
   *
   * @param symbol    the symbol of the stock
   * @param name      the name of the stock
   * @param cost      the cost of the stock
   */
  public Stock(String symbol, String name, double cost) {
    this.symbol = symbol;
    this.name = name;
    this.cost = cost;
    this.currentPrice = 0.0;
  }

  /**
   * Create a getter method to get the Symbol.
   *
   * @return stock symbol
   */
  public String getSymbol() {
    return this.symbol;
  }

  /**
   * Create a getter method to get the name of the stock.
   *
   * @return stock name
   */
  public String getName() {
    return this.name;
  }

  /**
   * Create a getter method to get the cost of the stock.
   *
   * @return cost of the stock
   */
  public double getCostBasis() {
    return this.cost;
  }

  /**
   * Create a getter method to get the current price of the stock.
   *
   * @return current price of the stock
   */
  public double getCurrentPrice() {
    return this.currentPrice;
  }

  /**
   * Create a setter methods to set the value for the current price.
   *
   * @return the costBasis of the stock
   */
  public double setCostBasis(double costBasis) {
    return this.cost = costBasis;
  }

  /**
   * Create a setter methods to set the current price.
   *
   * @return the current price of the stock
   */
  public double setCurrentPrice(double currentPrice) {
    return this.currentPrice = currentPrice;
  }

  /**
   * Create a method that return the fractional change between the original cost basis
   * and the current price.
   *
   * @return fractional change
   */
  public double getChangePercent() {
    return (this.currentPrice - this.cost) / this.cost;
  }

  /**
   * Create a toString method for Stock class.
   *
   * @return string of the Stock class
   */
  public String toString() {
    DecimalFormat currentPrice = new DecimalFormat("$ 0.00");
    DecimalFormat percentChange = new DecimalFormat("0.00%");
    return this.name + " Current Price: " + currentPrice.format(getCurrentPrice()) + "\n"
            + " Gain/Loss: " + percentChange.format(getChangePercent());
  }
}
