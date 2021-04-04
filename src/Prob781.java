import java.util.HashMap;
import java.util.Map;

public class Prob781 {
    public int numRabbits(int[] answers) {
        Map<Integer, Integer> record = new HashMap<>();
        int cnt = 0;
        for (int i = 0; i < answers.length; i++) {
            if (record.containsKey(answers[i])) {
                int t = record.get(answers[i]);
                t--;
                if (t == 0) {
                    record.remove(answers[i]);
                } else {
                    record.put(answers[i], t);
                }
            } else {
                cnt += answers[i] + 1;
                if (answers[i] != 0)
                    record.put(answers[i], answers[i]);
            }
        }
        return cnt;
    }
}
