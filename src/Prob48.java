public class Prob48 {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        int tmp;
        int row, col;
        int next_row, next_col;
        int rowUpper, colUpper;
        if (n % 2 == 0) {
            rowUpper = n / 2;
            colUpper = n / 2;
        } else {
            rowUpper = (n - 1) / 2;
            colUpper = n / 2 + 1;
        }
        for (int i = 0; i < rowUpper; i++) {
            for (int j = 0; j < colUpper; j++) {
                row = i;
                col = j;
                int last = matrix[i][j];
                for (int c = 0; c < 3; c++) {
                    next_row = col;
                    next_col = n - 1 - row;
                    tmp = matrix[next_row][next_col];
                    matrix[next_row][next_col] = last;
                    last = tmp;
                    row = next_row;
                    col = next_col;
                }
                matrix[i][j] = last;
            }
        }
    }

    public static void main(String[] args) {
        new Prob48().rotate(new int[][]{{5,1,9,11},{2,4,8,10},{13,3,6,7},{15,14,12,16}});
    }
}
