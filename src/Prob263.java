public class Prob263 {
    public boolean isUgly(int n) {
        if (n == 0) {
            return true;
        }
        while (n % 2 == 0) {
            n >>= 1;
        }
        while (n % 3 == 0) {
            n /= 3;
        }
        while (n % 5 == 0) {
            n /= 5;
        }
        return n == 1;
    }

    public static void main(String[] args) {
        System.out.println(new Prob263().isUgly(0));
    }
}
