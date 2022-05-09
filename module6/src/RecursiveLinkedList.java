import java.util.List;

public class RecursiveLinkedList {

  public static String toString(List<String> list) {
    return toStringRec(list, 0);
  }

  private static String toStringRec(List<String> list, int index) {
    if (index >= list.size()) {
      return "";
    }
    String rest = toStringRec(list, index+1);
    if (rest.length() > 0) {
      return "(" + list.get(index).toString() + ")" + " " + rest;
    }
    else {
      return "(" + list.get(index).toString() + ")";
    }
  }

  // better way to reverse the list (Using for each)
  public static String toStringLoop(List<String> list) {
    String result = "";
    // for each element in the list list, extract the data to the verible obj
    // then execute the statement in the for loop
    for (String obj:list) {
      result = result + " (" + obj.toString() + ")";
    }
    return result.substring(1);
  }

  // traditional java for loop
  public static String toStringPos(List<String> list) {
    String result = "";
    for (int index=0; index < list.size(); index = index + 1) {
      result = result + " (" + index + ":" + list.get(index).toString() + ")";
    }
    return result.substring(1);
  }
}
