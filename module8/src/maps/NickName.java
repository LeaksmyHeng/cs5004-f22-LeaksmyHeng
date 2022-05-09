package maps;

import java.util.HashMap;
import java.util.Map;

import domain.Person;

public class NickName {
  // If you use an object for the KEY make sure it is immutable AND hash() is overridden!
  private Map<Person, String> people;

  public NickName() {
    people = new HashMap<Person, String>();
    people.put(new Person("Frederick Douglass", 55), "Freddie");
    people.put(new Person("Baby Ruth", 3), "Babe");
    people.put(new Person("Amanda Gorma", 22), "Mandy");
  }

}
