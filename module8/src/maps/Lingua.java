package maps;

import java.util.HashMap;
import java.util.Map;
import domain.Person;

public class Lingua {
  private Map<String, String> dictionary;

  public Lingua() {
    dictionary = new HashMap<>();
    dictionary.put("Bonjour", "Hello");
    dictionary.put("Au revoir", "Goodbye");
    dictionary.put("Ca va?", "How's it going?");
  }

  public Map<String, String> getDictionary() {return this.dictionary;}

  public static void main(String [] args) {
    Lingua lingo = new Lingua();
    System.out.println(lingo.getDictionary().get("Ca va?"));
    System.out.println(lingo.getDictionary().get("Bonjour"));

    Map<String, Person> nicknames = new HashMap<>();
    nicknames.put("Babe", new Person("Babe Ruth", 149));
    nicknames.put("Neo", new Person("Mr. Anderson", 33));
    nicknames.put("Bugs", new Person("Bugs Bunny", 100));

    System.out.println(nicknames.get("Neo"));

  }
}