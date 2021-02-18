import sun.awt.image.ImageWatched;

import java.util.LinkedList;
import java.util.Queue;

public class Prob995 {
    public int minKBitFlips(int[] A, int K) {
//        int n = A.length;
//        int[] diff = new int[n+1];
//        int ans = 0, revCnt = 0;
//        for (int i = 0; i < n; i++) {
//            revCnt += diff[i];
//            if ((A[i] + revCnt) % 2 == 0) {
//                if (i + K > n) {
//                    return -1;
//                }
//                ++ans;
//                ++revCnt;
//                --diff[i+K];
//            }
//        }
//        return ans;
        Queue<Integer> queue = new LinkedList<>();
        int res = 0;
        for (int i = 0; i < A.length; i++) {
            if (queue.size() != 0 && queue.peek() <= i - K) {
                queue.remove();
            }
            if (queue.size() % 2 == 0 && A[i] == 0 || queue.size() % 2 == 1 && A[i] == 1) {
                if (i > A.length - K)
                    return -1;
                queue.add(i);
                res++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Prob995 prob995 = new Prob995();
        prob995.minKBitFlips(new int[]{0,0,1},3);
    }
}
