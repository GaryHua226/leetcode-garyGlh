public class Prob1310 {
    public int[] xorQueries(int[] arr, int[][] queries) {
        int[] a = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            if (i == 0) {
                a[i] = arr[i];
            } else {
                a[i] = a[i-1] ^ arr[i];
            }
        }
        int[] ans = new int[queries.length];
        int idx = 0;
        for (int[] query : queries) {
            if (query[0] == 0) {
                ans[idx] = a[query[1]];
            } else {
                ans[idx] = a[query[1]] ^ a[query[0] - 1];
            }
            idx++;
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1,3,4,8};
        int[][] queries = new int[][]{{0,1},{1,2},{0,3},{3,3}};
        new Prob1310().xorQueries(arr, queries);
    }
}
