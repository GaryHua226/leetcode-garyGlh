import java.util.HashMap;
import java.util.HashSet;

public class Prob87 {
    public boolean isScramble(String s1, String s2) {
        return isScramble_r(s1, s2, 0, s1.length());
    }

    public boolean isScramble_r(String s1, String s2, int start, int end) {
        return true;
    }
}
