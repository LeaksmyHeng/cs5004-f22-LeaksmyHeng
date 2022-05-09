package frequency;

import java.util.HashMap;
import java.util.Map;

/**
 * Create a utility class to count the word in the message string.
 */
public class Analytics {

  /**
   * Count the frequency words in the message.
   */
  public static Map<String, Double> wordFrequency(String message) {
    if (message == null || message.equals("")) {
      return null;
    }
    else {
      Map<String, Double> newMap = new HashMap<>();
      for (String word : message.split(" ")) {
        String upperCaseWord = word.replaceAll("[^a-zA-Z0-9]", "").toUpperCase();
        /* Check if the key is already in the map */
        if (newMap.containsKey(upperCaseWord)) {
          newMap.put(upperCaseWord, newMap.get(upperCaseWord) + 1.0);
        } else {
          newMap.put(upperCaseWord, 1.0);
        }
      }
      double total = 0.0;
      for (double value : newMap.values()) {
        total += value;
      }
      for (Map.Entry<String, Double> entry : newMap.entrySet()) {
        newMap.put(entry.getKey(), entry.getValue() / total);
      }
      return newMap;
    }
  }
}
