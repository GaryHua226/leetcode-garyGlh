public class Prob1269 {
    public int numWays(int steps, int arrLen) {
        if (arrLen == 1) {
            return 1;
        }
        arrLen = Math.min(steps / 2 + 1, arrLen); // 这里是精髓，走太远就回不去了
        long[] lastStep = new long[arrLen];
        lastStep[0] = 1;
        lastStep[1] = 1;
        for (int i = 0; i < steps - 1; i++) {
            long[] nextStep = new long[arrLen];
            for (int j = 0; j < arrLen; j++) {
                if (j == 0) {
                    nextStep[j] = (lastStep[j] + lastStep[j+1]) % (1000000007);
                } else if (j == arrLen - 1) {
                    nextStep[j] = (lastStep[j-1] + lastStep[j]) % 1000000007;
                } else {
                    nextStep[j] = (lastStep[j-1] + lastStep[j] + lastStep[j+1]) % 1000000007;
                }
            }
            lastStep = nextStep;
        }
        System.out.println(lastStep[0]);
        return (int)lastStep[0];
    }

    public static void main(String[] args) {
        new Prob1269().numWays(438,315977);
    }
}
