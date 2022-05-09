import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


/**
 * Create a class name Lambda.
 * Purpose: To filter.
 * Given a filteringString of length n, if the first n characters of the element matches the
 * filteringString(case insensitive) include the elements in the return list.
 * */
public class Lambda {
  List<String> words = Arrays.asList("straw man", "Straw hat", "last straw", "drinking straw", "Straw", "strah brah");

  public List<String> lambdaFilter(String filterString) {
    // write any supporting code you need here
    return words.stream().filter(words -> words.toLowerCase().startsWith(filterString.toLowerCase())).collect(Collectors.toList());
  }

  public static void main(String [] args) {
    Lambda lambda = new Lambda();
    List<String> strawsLuv = lambda.lambdaFilter("Straw");
    System.out.println(strawsLuv);
  }
}