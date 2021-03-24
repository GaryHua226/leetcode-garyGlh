public class Prob59 {
    public int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];
        int k = 1;
        int i, j;
        for (int l = 0; l < (n +1) / 2; l++) {
            i = l;
            j = l;
            // 一行
            if (i == n - i - 1) {
                for(; j < n - l; j++) {
                    res[i][j] = k++;
                }
                break;
            }
            for(; j < n - l; j++) {
                res[i][j] = k++;
            }
            j--;
            i++;
            for (; i < n - l; i++) {
                res[i][j] = k++;
            }
            i--;
            j--;
            for (; j >= l; j--) {
                res[i][j] = k++;
            }
            j++;
            i--;
            for(; i > l; i--) {
                res[i][j] = k++;
            }
        }
        return res;
    }
}
