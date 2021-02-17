public class Prob485 {
    public int findMaxConsecutiveOnes(int[] nums) {
        int res = 0;
        int cnt = 0;
        for (int i : nums) {
            if (i == 1) {
                cnt++;
            } else {
                res = Math.max(res, cnt);
                cnt = 0;
            }
        }
        res = Math.max(res, cnt);
        return res;
    }
}
