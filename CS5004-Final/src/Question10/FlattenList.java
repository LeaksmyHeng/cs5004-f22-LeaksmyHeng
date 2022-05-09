package Question10;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

// Since the question doesn't say whether it is case sensitive or not,
// I would assume that it is so here
class FlattenList {
  public List<String> flatten (List<List<String>> nestedList) {
    List<String> fullList = new ArrayList<>();
    List<String> fullList2 = new ArrayList<>();
    List<String> result = new ArrayList<>();
    nestedList.forEach(fullList::addAll);

    for (String word : fullList) {
      if (!fullList2.contains(word.toLowerCase())) {
        fullList2.add(word.toLowerCase());
        result.add(word);
      }
    }
    // delete the 2 fullList out.
    fullList.clear();
    fullList2.clear();
    return result;
  }

  // testing that the method works well
  public static void main(String[] args) {
    List<String> a = new ArrayList<>();
    a.add("Leaksmy");
    a.add("Peter");
    a.add("Mark");
    List<String> b = new ArrayList<>();
    b.add("Leaksmy");
    b.add("leaksmy");
    b.add("Peter");
    a.add("Mark");
    b.add("Daniel");
    b.add("orange");
    List<List<String>> c = new ArrayList<>();
    c.add(a);
    c.add(b);

    FlattenList result = new FlattenList();
    System.out.println(result.flatten(c));
  }
}