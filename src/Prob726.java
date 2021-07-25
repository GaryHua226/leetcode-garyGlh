import java.util.*;

public class Prob726 {
    private static boolean isAlpha(char ch) {
        return ('a' <= ch && ch <= 'z') || ('A' <= ch && ch <= 'Z');
    }

    private static boolean isUpper(char ch) {
        return 'A' <= ch && ch <= 'Z';
    }

    private static boolean isLower(char ch) {
        return 'a' <= ch && ch <= 'z';
    }

    private static boolean isDigit(char ch) {
        return '0' <= ch && ch <= '9';
    }

    public String countOfAtoms(String formula) {
        List<String> lst = new ArrayList<>();
        for (int i = 0; i < formula.length(); i++) {
            if (isUpper(formula.charAt(i))) {
                StringBuilder sb = new StringBuilder();
                sb.append(formula.charAt(i));
                int j = i + 1;
                for (; j < formula.length() && isLower(formula.charAt(j)); j++) {
                    sb.append(formula.charAt(j));
                }
                i = j - 1;
                lst.add(sb.toString());
            } else if (isDigit(formula.charAt(i))) {
                StringBuilder sb = new StringBuilder();
                int j = i;
                for (; j < formula.length() && isDigit(formula.charAt(j)); j++) {
                    sb.append(formula.charAt(j));
                }
                i = j - 1;
                lst.add(sb.toString());
            } else {
                lst.add(String.valueOf(formula.charAt(i)));
            }
        }
        Stack<Integer> st = new Stack<>();
        Map<String, Integer> cnt = new TreeMap<>();
        int cur = 0;
        for (int i = lst.size() - 1; i >= 0; i--) {
            String str = lst.get(i);
            if (str.equals("(")) {

            } else if (str.equals(")")) {

            } else if (isAlpha(str.charAt(0))) {

            } else if (isDigit(str.charAt(0))) {

            } else {
                System.out.println("error!");
            }
        }
        System.out.println(lst);
        return null;
    }

    public static void main(String[] args) {
        new Prob726().countOfAtoms("Mg(OH)2");
    }
}
