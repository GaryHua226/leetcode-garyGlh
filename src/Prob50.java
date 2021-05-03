public class Prob50 {
    public double myPow(double x, int n) {
        double res = myPow_pos(x, Math.abs(n));
        if (n < 0) {
            res = 1 / res;
        }
        return res;
    }

    private double myPow_pos(double x, int n) {
        if (n == 0) {
            return 1;
        } else if (n == 1) {
            return x;
        }
        if (n % 2 == 0) {
            double tmp = myPow_pos(x, n / 2);
            return tmp * tmp;
        } else {
            double tmp = myPow_pos(x, n / 2);
            return tmp * tmp * x;
        }
    }

}
