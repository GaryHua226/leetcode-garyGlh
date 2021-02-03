public class Prob8 {
    public int myAtoi(String s) {
        s = s.trim(); // delete space
        if (s.length() == 0)
            return 0;
        boolean positive = true;
        int index = 0;

        if (s.charAt(0) == '-') {
            index = 1;
            positive = false;
        }
        else if (s.charAt(0) == '+') {
            index = 1;
        }
        else if (!Character.isDigit(s.charAt(0)))
            return 0;

        int res = 0;
        for (; index < s.length(); index++) {
            if (!Character.isDigit(s.charAt(index)))
                break;
            if (res * 10 / 10 == res) {
                if (positive) {
                    res = res * 10;
                    res = res + s.charAt(index) - '0';
                    if (res < 0)
                        return Integer.MAX_VALUE;
                } else {
                    res = res * 10;
                    res = res - s.charAt(index) + '0';
                    if (res > 0)
                        return Integer.MIN_VALUE;
                }
            } else {
                if (positive)
                    return Integer.MAX_VALUE;
                else
                    return Integer.MIN_VALUE;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Prob8 prob8 = new Prob8();
        System.out.println(prob8.myAtoi("2147483648"));
    }
}
