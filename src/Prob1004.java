import java.util.LinkedList;
import java.util.Queue;

public class Prob1004 {
    public int longestOnes(int[] A, int K) {
        int left = 0, right = 0;
        int zeroCnt = 0;
        int res = 0;
        while (right < A.length) {
            if (A[right] == 0) {
                if (zeroCnt == K) {
                    // 0已经够个数了
                    res = Math.max(res, right - left);
                    while (left < right && A[left] == 1) {
                        left++;
                    }
                    left++;
                } else {
                    zeroCnt++;
                }
                right++;
            } else{
                right++;
            }
        }
        res = Math.max(res, right - left);
        return res;
    }

    public static void main(String[] args) {
        Prob1004 prob1004 = new Prob1004();
        System.out.println(prob1004.longestOnes(new int[]{0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1},3));
    }
}
