package question11;

/**
 * Create a utility class called Temperature. Since this is a utility class and has no
 * intention on making changes, I will put it as a final class and each method underneath is are
 * static method.
 */
public final class Temperature {
  private static final double constantThirtyTwo = 32.0;
  private static final double constantFive = 5.0;
  private static final double constantNine = 9.0;

  public static double toCelsius(double fahrenheit) {
    return (fahrenheit - constantThirtyTwo ) * constantFive/constantNine;
  }

  public static double toFahrenheit(double celsius) {
    return (celsius * constantNine/constantFive) + constantThirtyTwo;
  }

  public static double toKelvin(double celsius) {
    double constantAbsZeroC = -273.1;
    return celsius - constantAbsZeroC;
  }
}
