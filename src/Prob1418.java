import java.util.*;

public class Prob1418 {
    // orders[i]: customerName, tableNumber, foodItem
    public List<List<String>> displayTable(List<List<String>> orders) {
        Map<String, Map<String, Integer>> mp = new HashMap<>();
        Set<String> allFoods = new TreeSet<>();
        Set<String> allTables = new TreeSet<>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return Integer.parseInt(o1) - Integer.parseInt(o2);
            }
        });
        for (List<String> lst : orders) {
            String table = lst.get(1);
            String food = lst.get(2);
            if (!mp.containsKey(table)) {
                mp.put(table, new HashMap<>());
            }
            mp.get(table).put(food, mp.get(table).getOrDefault(food, 0) + 1);
            allFoods.add(food);
            allTables.add(table);
        }
        List<String> sortedFoods = new ArrayList<>(allFoods);
        List<String> sortedTables = new ArrayList<>(allTables);
        List<List<String>> ret = new ArrayList<>();

        for (String table : sortedTables) {
            List<String> tmp = new ArrayList<>();
            tmp.add(table);
            for (String food : sortedFoods) {
                tmp.add(String.valueOf(mp.get(table).getOrDefault(food, 0)));
            }
            ret.add(tmp);
        }
        sortedFoods.add(0, "Table");
        ret.add(0, sortedFoods);
        return ret;
    }
}
