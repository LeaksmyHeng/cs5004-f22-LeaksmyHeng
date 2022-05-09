package maps;
import java.util.Set;
import java.util.HashSet;
import domain.Person;

public class CityScape {
  public static void main(String [] args) {
    Set<String> cities = new HashSet<>();
    cities.add("London");
    cities.add("New York");
    cities.add("Beijing");
    cities.add("Mumbai");
    cities.add("New York");

    System.out.println(cities);

    for(String s : cities) {
      System.out.println(s.toUpperCase() + " ");
    }

    // lambda
    System.out.println();
    cities.forEach(eachCity -> System.out.print(eachCity.toLowerCase() + " "));

    System.out.println("\nNow let's work with people");

    Set<Person> people = new HashSet<>();
    people.add(new Person("Babe Ruth", 149));
    people.add(new Person("Neo", 33));
    people.add(new Person("Bugs Bunny", 100));
    people.add(new Person("Babe Ruth", 149));
    people.forEach(person -> System.out.println(person));
  }
}
