public class Prob566 {
    public int[][] matrixReshape(int[][] nums, int r, int c) {
        if (nums.length == 0)
            return nums;
        if (nums.length*nums[0].length != r * c)
            return nums;
        int[][] res = new int[r][c];
        int i = 0, j = 0;
        for (int[] a : nums) {
            for (int k : a) {
                res[i][j] = k;
                j++;
                if (j == c) {
                    j = 0;
                    i++;
                }
            }
        }
        return res;
    }
}
