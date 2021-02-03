public class Prob7 {
    public int reverse(int x) {
        if (x == 0)
            return 0;
        boolean sign = x > 0;
        StringBuilder res = new StringBuilder();
        while (x != 0) {
            res.append(Math.abs(x%10));
            x /= 10;
        }
        String up = "2147483647";
        String down = "2147483648";
        if (res.length() < up.length())
            if (sign)
                return Integer.parseInt(res.toString());
            else
                return -1 * Integer.parseInt(res.toString());
        String cmp;
        if (sign) {
            // 判断是否是大于2147483647
            cmp = up;
        } else {
            // 判断是否是大于2147483648
            cmp = down;
        }
        for (int i = 0;i < cmp.length(); i++) {
            if (res.charAt(i) > cmp.charAt(i))
                return 0;
            else if (res.charAt(i) < cmp.charAt(i))
                break;
        }
        if (sign)
            return Integer.parseInt(res.toString());
        else
            return -Integer.parseInt(res.toString());
    }

    public static void main(String[] args) {
        Prob7 prob7 = new Prob7();
        prob7.reverse(-1534236469);
    }
}
