import leetcodeUtil.Employee;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Prob690 {
    public int getImportance(List<Employee> employees, int id) {
        Map<Integer, Employee> map = new HashMap<>();
        for (Employee e : employees) {
            map.put(e.id, e);
        }
        return getImportance_r(map, id);
    }

    public int getImportance_r(Map<Integer, Employee> employees, int id) {
        int res = employees.get(id).importance;
        for (int subID : employees.get(id).subordinates) {
            res += getImportance_r(employees, subID);
        }
        return res;
    }
}
