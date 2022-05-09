import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import Question8.Pair;

import static org.testng.AssertJUnit.assertEquals;

public class Question8Test {

    @Test
    public void testCreateListOfPair() {
        List<String> xs = new ArrayList<>();
        xs.add("Hello");
        xs.add("Okay");
        xs.add("This is fine");
        List<Integer> ys = new ArrayList<>();
        ys.add(1);
        ys.add(2);
        ys.add(3);
        List<Pair<String, Integer>> newPair = Pair.createListOfPairs(xs, ys);
        assertEquals(3, newPair.size(), 0.0f);
        Pair i = Pair.create("Smy", 24);
        assertEquals(i.getfirst(), "Smy");
        assertEquals(i.getsecond(), 24);
        assertEquals((newPair.get(0).getfirst()), "Hello");
        assertEquals((newPair.get(1).getfirst()), "Okay");
        assertEquals((newPair.get(2).getfirst()), "This is fine");
        assertEquals((newPair.get(0).getsecond()), 1, 0.0f);
        assertEquals((newPair.get(1).getsecond()), 2, 0.0f);
        assertEquals((newPair.get(2).getsecond()), 3, 0.0f);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCreateListOfPairFailure() {
        List<String> xs = new ArrayList<>();
        xs.add("Hello");
        xs.add("Okay");
        xs.add("This is fine");
        List<Integer> ys = new ArrayList<>();
        ys.add(1);
        ys.add(2);
        List<Pair<String, Integer>> newPair = Pair.createListOfPairs(xs, ys);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCreateListOfPairFailure2() {
        List<String> xs = new ArrayList<>();
        xs.add("This is fine");
        List<Integer> ys = new ArrayList<>();
        ys.add(1);
        ys.add(2);
        List<Pair<String, Integer>> newPair = Pair.createListOfPairs(xs, ys);
    }

}
