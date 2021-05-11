public class Prob1734 {
    public int[] decode(int[] encoded) {
        int n = encoded.length + 1;
        int x = 0;
        for (int i = 1; i <= n; i++) {
            x ^= i;
        }
        int[] perm = new int[encoded.length+1];
        perm[0] = x;
        for (int i = 1; i < encoded.length; i+=2) {
            perm[0] ^= encoded[i];
        }
        for (int i = 1; i < n; i++) {
            perm[i] = perm[i-1] ^ encoded[i-1];
        }
        return perm;
    }
}
