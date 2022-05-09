package Question11;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class runnerIterator {
  public static List<Runner> RunnerIterator(List<Runner> runners) {
    List<Runner> result = new ArrayList<>();
    for (Runner thisRunner : runners) {
      if (thisRunner.sizeOf5KRace() >= 5 && thisRunner.halfMarathonRaceQualify()) {
        result.add(thisRunner);
      }
    }
    return result;
  }

  public static void main(String[] args) {
    Runner a = new Runner("Leaksmy",
            List.of(100.00, 50.00, 70.00, 80.00, 25.00),
            List.of(1500.00, 2500.00),
            List.of(99.00, 200.00, 300.00));
    Runner b = new Runner("Meh",
            List.of(15.00, 5.00, 17.00),
            List.of(2.00, 3.00),
            List.of(10.00, 5.00, 9.00));
    Runner c = new Runner("Daneil",
            List.of(15.00, 5.00, 17.00),
            List.of(2.00, 3.00),
            List.of(10.00, 5.00, 9.00));
    Runner d = new Runner("Mark",
            List.of(15.00, 5.00, 17.00, 18.26, 17.25, 36.45, 200.31),
            List.of(2.00, 3.00),
            List.of(10.00, 5.00, 9.00));
    List<Runner> runners = new ArrayList<>();
    runners.add(a);
    runners.add(b);
    runners.add(c);
    runners.add(d);
    List<Runner> runnerIter = RunnerIterator(runners);
    System.out.println("Number of runner is 2 = " + runnerIter.size());
    Iterator<Runner> runner = runnerIter.iterator();
    runner.forEachRemaining(runner1 -> System.out.println("Name of that 2 Person is : " + runner1.getName()));
  }
}
