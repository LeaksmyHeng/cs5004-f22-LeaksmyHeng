package design.patterns.strategy;

interface PayStrategy {
  void pay(Employee e);
}

class Employee {

  PayStrategy strategy;
  String name;

  public Employee(String name, PayStrategy payStrategy) {
    this.strategy = payStrategy;
    this.name = name;
  }

  public String getName() { return name; }
  public String toString() { return this.getName(); }

  public void pay() {
    strategy.pay(this);
  }

  public void changePayStrategy(PayStrategy payStrategy) {
    strategy = payStrategy;
  }
}

class HourlyPayStrategy implements PayStrategy {

  @Override
  public void pay(Employee e) {
    System.out.println("Doing Hourly Pay for " + e);
    System.out.println("May need to pull specific pay data from employee, hence the reference to them");
    System.out.println("Eg: get number of hours and overtime");
  }
}

class SalariedPayStrategy implements PayStrategy {

  @Override
  public void pay(Employee e) {
    System.out.println("Doing Salaried Pay for " + e);
  }
}

class CommissionedPayStrategy implements PayStrategy {

  @Override
  public void pay(Employee e) {
    System.out.println("Doing Commission Pay for " + e);
  }
}
public class StrategyDemo {
  public static void main(String [] args) {
    Employee emp = new Employee("John Doe", new HourlyPayStrategy());
    Employee emp2 = new Employee("Jane Doe", new SalariedPayStrategy());
    emp.pay();
    emp2.pay();
    System.out.println("**** Changing the Pay Strategy on the fly ****");
    emp.changePayStrategy(new CommissionedPayStrategy());
    emp.pay();
  }
}