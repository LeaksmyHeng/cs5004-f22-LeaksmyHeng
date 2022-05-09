package mystring;
import java.util.ArrayList;
import java.util.List;

public class StringExample {
  private List<String> list;

  public StringExample() {
    list = new ArrayList<>();
    list.add("My CS5004 class");
    list.add("at");
    list.add("Northeastern");
    list.add("is");
    list.add("fantastic!");
  }

  @Override
  public String toString() {
    return list.toString();
  }

  public String recursiveToString() {
    return recursiveToStringHelper(0, "");
  }

  private String recursiveToStringHelper(int index, String accumulator) {
    if(index == list.size()) { // base case
      return accumulator;
    }
    String current = "(" + list.get(index) + ")";
    int nextIndex = index + 1;
    return recursiveToStringHelper(nextIndex, accumulator + current);
  }

  public static void main(String [] args) {
    StringExample example = new StringExample();
    System.out.println(example.toString());
    System.out.println("Recursive Example");
    System.out.println(example.recursiveToString());
  }
}
