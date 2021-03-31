public class Prob190 {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 32; i++) {
            if ((n & (1 << i)) == 0) {
                sb.append('0');
            } else {
                sb.append('1');
            }
        }
//        System.out.println(sb);
        return parseInt(sb.toString());
    }

    public static int parseInt(String str) {
        int res = 0;
        for (int i = 1; i < str.length(); i++) {
            res *= 2;
            res += str.charAt(i)-'0';
        }
        if (str.charAt(0) == '1') {
            res -= Math.pow(2, 31);
        }
        return res;
    }
}