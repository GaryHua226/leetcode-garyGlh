import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Prob56 {
    public int[][] merge(int[][] intervals) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        int start = intervals[0][0];
        int end = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            if (end >= intervals[i][0]) {
                end = Math.max(end, intervals[i][1]);
            } else {
                List<Integer> tmp = new ArrayList<>();
                tmp.add(start);
                tmp.add(end);
                res.add(tmp);
                start = intervals[i][0];
                end = intervals[i][1];
            }
        }
        List<Integer> tmp = new ArrayList<>();
        tmp.add(start);
        tmp.add(end);
        res.add(tmp);
        int[][] ret = new int[res.size()][2];
        for (int i = 0; i < res.size(); i++) {
            ret[i][0] = res.get(i).get(0);
            ret[i][1] = res.get(i).get(1);
        }
        return ret;
    }
}
