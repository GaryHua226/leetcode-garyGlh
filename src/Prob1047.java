public class Prob1047 {
    public String removeDuplicates(String S) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < S.length(); i++) {
            if (sb.length() == 0)
                sb.append(S.charAt(i));
            else {
                if (S.charAt(i) == sb.charAt(sb.length()-1)) {
                    sb.delete(sb.length()-1,sb.length());
                } else {
                    sb.append(S.charAt(i));
                }
            }
        }
        return sb.toString();
    }
}
