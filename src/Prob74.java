public class Prob74 {
    public boolean searchMatrix(int[][] matrix, int target) {
        // search row
        int start = 0;
        int end = matrix.length;
        while (end - start > 1) {
            int mid = (start + end) / 2;
            if (matrix[mid][0] == target) {
                return true;
            } else if (matrix[mid][0] < target) {
                start = mid;
            } else {
                end = mid;
            }
        }
        int row;
        if (matrix[end][0] <= target) {
            row = end;
        } else {
            row = start;
        }
        System.out.println(row);
        // search col
        start = 0;
        end = matrix[0].length;
        while (end - start > 1) {
            int mid = (start + end) / 2;
            if (matrix[row][mid] == target) {
                return true;
            } else if (matrix[row][mid] < target) {
                start = mid;
            } else {
                end = mid;
            }
        }
        return matrix[row][start] == target || matrix[row][end] == target;
    }
}
