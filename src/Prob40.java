import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Prob40 {
    List<List<Integer>> res;
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        res = new ArrayList<>();
        Arrays.sort(candidates);
        List<Integer> currList = new ArrayList<>();
        dfs(candidates, target, 0, 0, currList);
        return res;
    }

    public void dfs(int[] candidates, int target, int currIndex, int currSum, List<Integer> currList) {
        if (currSum == target) {
            List<Integer> newRes = new ArrayList<>(currList);
            res.add(newRes);
            return;
        } else if (currSum > target) {
            return;
        }
        if (currIndex >= candidates.length) {
            return;
        }

        int nextIndex = currIndex + 1; // 下一个数字出现的位置
        int currCount = 1; // 当前数字出现的次数
        int currNum = candidates[currIndex];
        for (; nextIndex < candidates.length && candidates[nextIndex]==candidates[currIndex]; nextIndex++) {
            currCount ++;
        }
        for (int i = 0; i <= currCount; i++) {
            for (int j = 0; j < i; j++) {
                currList.add(currNum);
            }
            dfs(candidates, target, nextIndex, currSum + currNum * i, currList);
            for (int j = 0; j < i; j++) {
                currList.remove(currList.size()-1);
            }
        }
    }

    public static void main(String[] args) {
        new Prob40().combinationSum2(new int[]{10,1,2,7,6,1,5},8);
    }
}
