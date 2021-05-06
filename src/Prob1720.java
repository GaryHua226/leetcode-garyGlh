public class Prob1720 {
    public int[] decode(int[] encoded, int first) {
        int[] res = new int[encoded.length+1];
        res[0] = first;
        for (int i = 1; i < res.length; i++) {
            // encoded[i-1] = res[i] ^ res[i-1]
            // res[i] ^ res[i-1] ^ res[i-1] = res[i] ^ (00...00) = res[i]
            // res[i] = encoded[i-1] ^ res[i-1]
            res[i] = encoded[i-1] ^ res[i-1];
        }
        return res;
    }
}
