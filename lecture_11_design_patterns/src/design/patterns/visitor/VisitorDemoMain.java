package design.patterns.visitor;

public class VisitorDemoMain {
  public static void main( String [] args) {
    Car car = new Car();

    car.accept(new CarDiagnosticVisitor());
    car.diagnoseParts();
    car.accept(new CarSalesVisitor());
    car.prepForSale();

    // So now let's explore if the composite element is dynamically structured
    // and changes after the program is running for a while...

    car.addPart(new LaneWarningSystem(false));
    car.diagnoseParts();
  }
}