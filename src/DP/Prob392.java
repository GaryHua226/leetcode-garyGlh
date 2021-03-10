package DP;

public class Prob392 {
    public boolean isSubsequence(String s, String t) {
        int i = 0;
        for (int j = 0; j < t.length(); j++) {
            if (t.charAt(j) == s.charAt(i)) {
                i++;
                if (i == s.length())
                    return true;
            }
        }
        return false;
    }
}
