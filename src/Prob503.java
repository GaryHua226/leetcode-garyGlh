import java.util.Arrays;
import java.util.Stack;

public class Prob503 {
    public int[] nextGreaterElements(int[] nums) {
        if (nums.length == 0)
            return new int[]{};
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        int[] res = new int[nums.length];
        Arrays.fill(res, -1);
        for (int i = 1; i < nums.length; i++) {
            while (!stack.empty() && nums[i] > nums[stack.peek()]) {
                res[stack.pop()] = nums[i];
            }
            stack.push(i);
        }
        for (int i = 1; i < nums.length; i++) {
            while (!stack.empty() && nums[i] > nums[stack.peek()]) {
                res[stack.pop()] = nums[i];
            }
        }
        return res;
    }

    public static void main(String[] args) {

    }
}
