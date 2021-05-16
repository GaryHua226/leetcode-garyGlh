import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Prob39 {
    private List<List<Integer>> res;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        res = new ArrayList<>();
        List<Integer> curList = new ArrayList<>();
        dfs(candidates, target, 0, curList, 0);
        return res;
    }

    private void dfs(int[] candidates, int target, int currIndex, List<Integer> curList, int curSum) {
        if (curSum == target) {
            List<Integer> newRes = new ArrayList<>(curList);
            res.add(newRes);
            return;
        } else if (curSum > target) {
            return;
        }
        curList.add(candidates[currIndex]);
        dfs(candidates, target, currIndex, curList, curSum + candidates[currIndex]);
        curList.remove(curList.size()-1);
        if (currIndex != candidates.length - 1) {
            dfs(candidates, target, currIndex + 1, curList, curSum);
        }
    }

}
