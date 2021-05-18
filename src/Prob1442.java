public class Prob1442 {
    public int countTriplets(int[] arr) {
        int n = arr.length;
        int[] xors = new int[n + 1];
        xors[0] = 0;
        for (int i = 1; i < n + 1; i++) {
            xors[i] = xors[i-1] ^ arr[i-1];
        }
        int cnt = 0;
        for (int i = 1; i < n + 1; i++) {
            for (int j = 0; j < i; j++) {
                if ((xors[i] ^ xors[j]) == 0) {
                    cnt += (j - i);
                }
            }
        }
        return cnt;
    }
}
