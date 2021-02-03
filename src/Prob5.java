import java.util.*;

public class Prob5 {
    public Boolean isPalindrome(String s) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = s.length() - 1; i >= 0; i--) {
            stringBuilder.append(s.charAt(i));
        }
        return s.equals(stringBuilder.toString());
    }

    public String longestPalindrome(String s) {
        HashMap<Character, ArrayList<Integer>> loc = new HashMap<>();
        for (int i = 0;i < s.length(); i++) {
            if (loc.containsKey(s.charAt(i))) {
                loc.get(s.charAt(i)).add(i);
            } else {
                ArrayList<Integer> temp = new ArrayList<>();
                temp.add(i);
                loc.put(s.charAt(i), temp);
            }
        }
        String res = "";
        HashSet<Character> dealed = new HashSet<>();
        for (int index = 0;index < s.length(); index++) {
            char ch = s.charAt(index);
            if (dealed.contains(ch)) {
                continue;
            } else {
                dealed.add(ch);
            }
            ArrayList<Integer> chLocs = loc.get(ch);
            for (int i = 0; i < chLocs.size(); i++) {
                for (int j = chLocs.size()-1; j >= i; j--) {
                    if (chLocs.get(j)-chLocs.get(i)+1 > res.length() && isPalindrome(s.substring(chLocs.get(i), chLocs.get(j)+1)) ) {
                        res = s.substring(chLocs.get(i), chLocs.get(j)+1);
                        break;
                    }
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Prob5 prob5 = new Prob5();
        System.out.println(prob5.longestPalindrome("\"1111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111\""));
    }
}
