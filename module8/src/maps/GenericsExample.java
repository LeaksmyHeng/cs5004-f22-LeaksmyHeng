package maps;
import domain.Person;

import java.util.ArrayList;
import java.util.List;

public class GenericsExample <T> {
  private T data;
  public GenericsExample(T data) {
    this.data = data;
  }
  public T getData() {return this.data;}

  public static void main(String [] args) {
    GenericsExample<String> s = new GenericsExample<>("Hello Class!");
    GenericsExample<Person> p = new GenericsExample<>(new Person("Lauryn", 23));
    System.out.println(s.getData());
    System.out.println(p.getData());
    System.out.println(p.getData().getName());
    GenericsExample<Integer> i = new GenericsExample<>(12);
    System.out.println(i.getData());
  }
}
