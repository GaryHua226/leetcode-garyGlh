public class Prob643 {
    public double findMaxAverage(int[] nums, int k) {
        long sum = 0;
        double res;
        for (int i = 0;i < k; i++)
            sum += nums[i];
        res = (double)sum / k;
        for (int i = 1; i <= nums.length - k; i++) {
            sum -= nums[i-1];
            sum += nums[i+k-1];
            if ((double)sum / k > res)
                res = (double)sum / k;
        }
        return res;
    }

    public static void main(String[] args) {
        Prob643 prob643 = new Prob643();
        System.out.println(prob643.findMaxAverage(new int[]{0,1,1,3,3}, 4));
    }
}
