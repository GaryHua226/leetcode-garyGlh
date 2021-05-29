public class Test {
    static int num = 0;

    public static void main(String[] args) {
        int n = 5;
        rec(n);
        System.out.println();
        System.out.println(num);
    }

    private static int rec(int n) {
        boolean kk = n > 0 && (num += rec(n-1)) > 0;
        return n;
    }
}
