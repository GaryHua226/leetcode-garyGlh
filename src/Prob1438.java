import java.util.Comparator;
import java.util.PriorityQueue;

public class Prob1438 {
    public int longestSubarray(int[] nums, int limit) {
        if (nums.length == 0)
            return 0;
        PriorityQueue<Integer> maxheap = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        PriorityQueue<Integer> minheap = new PriorityQueue<>();
        int left = 0, right = 1;
        maxheap.offer(nums[0]);
        minheap.offer(nums[0]);
        int res = 1;
        while (right < nums.length) {
            maxheap.offer(nums[right]);
            minheap.offer(nums[right]);
            if (maxheap.peek() - minheap.peek() > limit) {
                res = Math.max(res, right - left);
                while (left < right && maxheap.peek() - minheap.peek() > limit) {
                    maxheap.remove(nums[left]);
                    minheap.remove(nums[right]);
                    left++;
                }
            }
            right++;
        }
        res = Math.max(right-left,res);
        return res;
    }

    public static void main(String[] args) {
        Prob1438 prob1438 = new Prob1438();
        prob1438.longestSubarray(new int[]{1,4,3,2,5,6,9,8,7}, 1);
    }
}
