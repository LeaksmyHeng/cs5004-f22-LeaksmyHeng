package domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Person implements Comparable<Person> { // implements comparable interface now
  private String name;
  private int age;

  public Person(String name, int age) {
    this.name = name;
    this.age = age;
  }
  public String getName() { return name; }
  public int getAge() { return age; }

  @Override
  public String toString() { return this.name + " - "+ this.age; }

  // Add: Equals & Hashcode, CompareTo
  @Override
  public boolean equals(Object other) {
    if (this == other ) return true; // identity: same object
    if(!( other instanceof Person )) return false; // wrong class type
    Person otherPerson = (Person) other;
    return (this.name.equals(otherPerson.name) && this.age == otherPerson.age);
  }

  @Override public int hashCode() {
    return Objects.hash(name, age);
  }

  @Override
  public int compareTo(Person other) {
    /*
     * Sorting by  name. compareTo should return < 0 if this(current object)
     * is less other, > 0 if this  greater than other and 0 if they are  equal.
     */
    return this.name.compareTo(other.name); // can simply use String compareTo
  }
  public static Predicate<Person> isAdult() {
    return p -> p.getAge() >= 21;
  }

  public static List<Person> filterPerson(List<Person> people,
                                          Predicate<Person> predicate) {
    return people.stream()
            .filter(predicate)
            .collect(Collectors.<Person>toList());
  }

  public static void main(String [] args) {
    Person p1 = new Person("Frederick Douglass", 55);
    Person p2 = new Person("Baby Ruth", 3);
    Person p3 = new Person("Amanda Gorman", 22);

    List<Person> people = new ArrayList<>();
    people.add(p1);
    people.add(p2);
    people.add(p3);
    System.out.println(filterPerson(people,isAdult()));


    // Map the Person Names to integer lengths
    List<Integer> nameLengths = new ArrayList<>();
    nameLengths = people.stream()
            .map((Person person) -> person.getName().length() )
            .collect(Collectors.toList());
    for (Integer each : nameLengths  ) {
      System.out.println(each);

    }
    // Uncomment here if we want to sort via comparable
    // Collections.sort(people);
    // System.out.println(people);

    System.out.println("\nEquality Test using == first");
    System.out.println(new Person("Frederick Douglass", 55) == ( new Person("Frederick Douglass", 11)));
    System.out.println(new Person("Frederick ", 55) == (new Person("Frederick Douglass", 11)));
    System.out.println(new Person("Frederick Douglass", 55) == ( new Person("Frederick Douglass", 55)));

    System.out.println("Now using .equals() method");
    System.out.println(new Person("Frederick Douglass", 55).equals( new Person("Frederick Douglass", 11)));
    System.out.println(new Person("Frederick ", 55).equals (new Person("Frederick Douglass", 11)));
    System.out.println(new Person("Frederick Douglass", 55).equals( new Person("Frederick Douglass", 55)));

  }

}
