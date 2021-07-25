import java.util.List;
import java.util.TreeSet;

public class Prob1418 {
    public List<List<String>> displayTable(List<List<String>> orders) {
        TreeSet<String> foods = new TreeSet<>();

        for (List<String> lst : orders) {
            foods.add(lst.get(2));
        }

    }
}
