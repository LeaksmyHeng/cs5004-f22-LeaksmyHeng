package design.patterns.visitor;


import java.util.List;
import java.util.LinkedList;

public class Car implements ICar {
  private final List<CarComponent> components;
  CarComponentVisitor visitor;

  public Car() {
    this.components = new LinkedList<CarComponent>();
    this.components.add(new Engine("V8 - GMC", 98));
    this.components.add(new Transmission(50));
    this.components.add(new BrakeSystem(70, false));
  }


  @Override
  public void diagnoseParts() {
    for(CarComponent eachComponent : components ) {
      eachComponent.accept(visitor);
    }
  }

  @Override
  public void addPart(CarComponent carComponent) {
    this.components.add(carComponent);
  }

  @Override
  public void prepForSale() {
    for(CarComponent eachComponent : components ) {
      eachComponent.accept(visitor);
    }
  }
  @Override
  public void accept(CarComponentVisitor visitor) {
    this.visitor = visitor;
  }
}

