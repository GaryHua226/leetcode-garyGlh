public class Prob992 {
    int f(int[] A, int K) {
        if (K == 0)
            return 0;
        // 0 1 2 3 4
        // 1 2 1 2 3
        int[] freq = new int[A.length+1];
        int count = 0;
        int left = 0, right = 0;
        int res = 0;
        while (right < A.length) {
            freq[A[right]]++;
            if (freq[A[right]] == 1) {
                count++;
                if (count == K + 1) {
                    while (left < right && count == K + 1) {
                        res += right - left;
                        freq[A[left]]--;
                        if (freq[A[left]] == 0)
                            count--;
                        left++;
                    }
                }
            }
            right++;
        }
        res += (right - left) * (right - left + 1) / 2;
        return res;
    }


    public int subarraysWithKDistinct(int[] A, int K) {
        return f(A, K) - f(A,K-1);
    }

    public static void main(String[] args) {
        Prob992 prob992 = new Prob992();
        System.out.println(prob992.subarraysWithKDistinct(new int[]{1,2},1));
    }
}
