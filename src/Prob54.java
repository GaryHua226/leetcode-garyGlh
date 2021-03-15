import java.util.ArrayList;
import java.util.List;

public class Prob54 {
    public List<Integer> spiralOrder(int[][] matrix) {
        int r = matrix.length;
        int c = matrix[0].length;
        ArrayList<Integer> res = new ArrayList<>();
        int i, j;
        for (int l = 0; l < Math.min((r+1)/2, (c+1)/2); l++) {
            i = l;
            j = l;
            // 一行
            if (i == r - i - 1) {
                for (; j < c-l; j++) {
                    res.add(matrix[i][j]);
                }
                break;
            }
            // 一列
            if (j == c - j - 1) {
                for (; i < r-l; i++) {
                    res.add(matrix[i][j]);
                }
                break;
            }
            for (; j < c-l; j++) {
                res.add(matrix[i][j]);
            }
            j--;
            i++;
            for (; i < r-l; i++) {
                res.add(matrix[i][j]);
            }
            i--;
            j--;
            for (; j >= l; j--) {
                res.add(matrix[i][j]);
            }
            j++;
            i--;
            for (; i > l; i--) {
                res.add(matrix[i][j]);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Prob54 prob54 = new Prob54();
        prob54.spiralOrder(new int[][]{{1,2,3,4},{5,6,7,8},{9,10,11,12}});
    }
}
