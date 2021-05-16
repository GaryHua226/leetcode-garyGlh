public class Prob38 {
    public String countAndSay(int n) {
        if (n == 1) {
            return "1";
        }
        StringBuilder last = new StringBuilder("1");
        for (int i = 1; i < n; i++) {
            StringBuilder next = new StringBuilder();
            int cnt = 1;
            char curr = last.charAt(0);
            for (int j = 1; j < last.length(); j++) {
                if (last.charAt(j) == last.charAt(j-1)) {
                    cnt++;
                } else {
                    next.append(String.valueOf(cnt));
                    next.append(last.charAt(j-1));
                    cnt = 1;
                }
            }
            next.append(String.valueOf(cnt));
            next.append(last.charAt(last.length()-1));
            last = next;
        }
        return last.toString();
    }

    public static void main(String[] args) {
        String s = new Prob38().countAndSay(5);
        System.out.println(s);
    }
}
