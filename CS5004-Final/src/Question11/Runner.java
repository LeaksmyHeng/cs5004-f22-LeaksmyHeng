package Question11;

import java.util.List;


public class Runner implements Comparable<Runner> {
  private final String name;
  private final List<Double> fiveKRaceTimes;
  private final List<Double> tenKRaceTimes;
  private final List<Double> halfMarathonTimes;
  public Runner(String name, List<Double> fiveKRaceTimes, List<Double> tenKRaceTimes,
                List<Double> halfMarathonTimes) {
    this.name = name;
    this.fiveKRaceTimes = fiveKRaceTimes;
    this.tenKRaceTimes = tenKRaceTimes;
    this.halfMarathonTimes = halfMarathonTimes;
  }
  public String getName() {
    return name;
  }

  public List<Double> getFiveKRaceTimes() {
    return fiveKRaceTimes;
  }

  public List<Double> getTenKRaceTimes() {
    return tenKRaceTimes;
  }

  public List<Double> getHalfMarathonTimes() {
    return halfMarathonTimes;
  }

  // Compute the sum of 5k race
  public double sumOf5KRace() {
    List<Double> fiveKRaceTimes = getFiveKRaceTimes();
    double result = 0;
    if (fiveKRaceTimes.size() > 0) {
      for (Double fiveKRaceTime : fiveKRaceTimes) {
        result = result + fiveKRaceTime;
      }
    }
    return result;
  }

  // Get the size of the fiveKRace
  public int sizeOf5KRace() {
    List<Double> fiveKRaceTimes = getFiveKRaceTimes();
    return fiveKRaceTimes.size();
  }

  public double average5KRace() {
    double sumOf5KRace = sumOf5KRace();
    int sizeOf5KRace = sizeOf5KRace();

    if (sizeOf5KRace > 0) {
      return sumOf5KRace/sizeOf5KRace;
    }
    else {
      throw new IllegalArgumentException("Denominator is 0");
    }
  }

  /**
   * Part a of the question.
   */
  @Override
  public int compareTo(Runner o) {
    if (this.average5KRace() == o.average5KRace()) {
      return 0;
    }
    else if (this.average5KRace() > o.average5KRace()) {
      return 1;
    }
    return -1;
  }

  public boolean halfMarathonRaceQualify() {
    if (getHalfMarathonTimes().size() > 0) {
      for (int i = 0; i < getHalfMarathonTimes().size(); i++) {
        if (getHalfMarathonTimes().get(i) < 100.00) {
          return true;
        }
      }
    }
    return false;
  }

  /**
  public static void main(String[] args) {
    Runner a = new Runner("Leaksmy", List.of(10.00, 5.00, 7.00), List.of(15.00, 25.00), List.of(10.00, 2.00, 3.00));
    Runner b = new Runner("Daneil", List.of(15.00, 5.00, 17.00), List.of(2.00, 3.00), List.of(10.00, 5.00, 9.00));
    System.out.println(a.compareTo(b));
    System.out.println(b.compareTo(a));
    Runner c = new Runner("Daneil", List.of(15.00, 5.00, 17.00), List.of(2.00, 3.00), List.of(10.00, 5.00, 9.00));
    System.out.println(b.compareTo(c));
    Runner d = new Runner("Daneil", List.of(15.01, 5.00, 17.00), List.of(2.00, 3.00), List.of(10.00, 5.00, 9.00));
    System.out.println(b.compareTo(d));
  }
   */
}
