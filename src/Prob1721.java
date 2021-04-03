public class Prob1721 {
    public int trap(int[] height) {
        int n = height.length;
        int[] l2r_max = new int[n];
        int[] r2l_max = new int[n];
        int tmp = height[0];
        l2r_max[0] = tmp;
        for (int i = 1; i < n; i++) {
            if (height[i] > tmp) {
                tmp = height[i];
            }
            l2r_max[i] = tmp;
        }
        tmp = height[n-1];
        r2l_max[n-1] = tmp;
        for (int i = n - 2; i >= 0; i--) {
            if (height[i] > tmp) {
                tmp = height[i];
            }
            r2l_max[i] = tmp;
        }
        int cnt = 0;
        for (int i = 1; i < n - 1; i++) {
            if (Math.min(l2r_max[i], r2l_max[i]) > height[i]) {
                cnt += Math.min(l2r_max[i], r2l_max[i]) - height[i];
            }
        }
        return cnt;
    }

    public static void main(String[] args) {
        new Prob1721().trap(new int[]{0,1,0,2,1,0,1,3,2,1,2,1});
    }
}
