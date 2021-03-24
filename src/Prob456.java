import java.util.Stack;
import java.util.TreeMap;

public class Prob456 {
    public boolean find132pattern(int[] nums) {
        int n = nums.length;
        if (n < 3) {
            return false;
        }

        int leftMin = nums[0];
        TreeMap<Integer, Integer> rightAll = new TreeMap<>();

        for (int k = 2; k < n; k++) {
            rightAll.put(nums[k], rightAll.getOrDefault(nums[k], 0)+1);
        }

        for (int j = 1; j < n - 1; j++) {
            if (leftMin < nums[j]) {
                Integer next = rightAll.ceilingKey(leftMin + 1);
                if (next != null && next < nums[j]) {
                    return true;
                }
            }
            leftMin = Math.min(leftMin, nums[j]);
            rightAll.put(nums[j+1], rightAll.get(nums[j+1]) -1);
            if (rightAll.get(nums[j + 1]) == 0) {
                rightAll.remove(nums[j + 1]);
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Prob456 prob456 = new Prob456();
        System.out.println(prob456.find132pattern(new int[]{1,3,2,4,5,6,7,8,9}));
    }
}
