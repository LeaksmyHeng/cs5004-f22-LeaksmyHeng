package mystring;
import java.util.ArrayList;
import java.util.List;

public class StringExample {
  private List<String> list;

  public StringExample() {
    list = new ArrayList<>();
    list.add("MY CS5004 class");
    list.add("are amazing");
    list.add("students!");
    list.add("Don't you think");
    list.add("Dean Beth?");
  }

  @Override
  public String toString() {
    return list.toString();
  }

  public String recursiveToString() {
    return recursiveToStringHelper(0, "");
  }

  private String recursiveToStringHelper(int index, String accumulator) {
    if( index == list.size()) {
      return accumulator;
    }
    String current = "(" + list.get(index) + ")";
    int nextIndex = index + 1;
    return recursiveToStringHelper(nextIndex, accumulator + current);
  }

  public static void main(String [] args) {
    StringExample example = new StringExample();
    System.out.println(example.toString());
    System.out.println("Recursive version");
    System.out.println(example.recursiveToString());
  }
}
