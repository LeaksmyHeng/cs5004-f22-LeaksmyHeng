package doubledispatch;

import java.util.ArrayList;
import java.util.List;

/**
 * Create a class to capture the log for the explorer.
 */
public class SimulationBuilder {

  /**
   * Create a static final Arrays to capture the log message from the explorers.
   */
  private static final ArrayList<String> logs = new ArrayList<String>();

  /**
   * Create a method for addLog message from the explorer to the logs array.
   */
  public static void addToLog(String s) {
    logs.add(s);
  }

  /**
   * Create a createPlanet method that will return the planet object.
   */
  public static IPlanet createPlanet(String name) {
    String lowerCaseName = name.toLowerCase();
    if (lowerCaseName.equals("mars")) {
      return new Mars();
    }
    else if (lowerCaseName.equals("mercury")) {
      return new Mercury();
    }
    else if (lowerCaseName.equals("venus")) {
      return new Venus();
    }
    else return null;
  }

  /**
   * Create the createExplorer method that capture what type of explorer exploring the planet.
   */
  public static ISpaceExplorer createExplorer(String name) {
    String lowerCaseExplorer = name.toLowerCase();
    if (lowerCaseExplorer.equals("terrainexplorer")) {
      return new TerrainExplorer();
    }
    else if (lowerCaseExplorer.equals("lifeexplorer")) {
      return new LifeExplorer();
    }
    return null;
  }

  /**
   * Create a getSimulationLog that will return all log message from the explorer.
   */
  public static List<String> getSimulationLog() {
    return logs;
  }
}
