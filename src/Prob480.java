import java.util.Arrays;

public class Prob480 {
    public double[] medianSlidingWindow(int[] nums, int k) {
        double[] res = new double[nums.length-k+1];
        // 维护一个长度为k的数组
        int[] temp = new int[k];
        if (k >= 0) System.arraycopy(nums, 0, temp, 0, k);
        Arrays.sort(temp);

        for (int i = 0;i < nums.length - k + 1; i++) {
            if (k % 2 == 1) {
                res[i] = temp[(k-1)/2]; // 取中位数
            } else {
                res[i] = ((double)temp[k/2-1] + (double)temp[k/2]) / 2;
            }
            if (i == nums.length - k)
                break;
//            System.out.println(Arrays.toString(temp));
            // 更新temp数组
            int tobedeleted = nums[i];
            int delete_index = 0;
            for (int j = 0;j < k; j++) {
                if (temp[j] == tobedeleted) {
                    delete_index = j;
                    break;
                }
            }
            int tobeinserted = nums[i+k];
            int insert_index = k-1;
            for (int j = 0;j < k; j++) {
                if (temp[j] > tobeinserted) {
                    insert_index = j;
                    break;
                }
            }

            if (delete_index == insert_index) {
                temp[insert_index] = tobeinserted;
            } else if (delete_index < insert_index) {
                System.arraycopy(temp, delete_index + 1, temp, delete_index, insert_index - delete_index);
                if (insert_index == k - 1 && temp[k-1] < tobeinserted)
                    temp[insert_index] = tobeinserted;
                else
                    temp[insert_index - 1] = tobeinserted;
            } else {
                System.arraycopy(temp, insert_index, temp, insert_index + 1, delete_index - insert_index);
                temp[insert_index] = tobeinserted;
            }

        }
//        System.out.println(Arrays.toString(res));
        return res;
    }

    public static void main(String[] args) {
        Prob480 prob480 = new Prob480();
        prob480.medianSlidingWindow(new int[]{1,3,-1,-3,5,3,6,7}, 3);
    }
}
