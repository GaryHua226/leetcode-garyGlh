public class Prob14 {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length==0)
            return "";
        // 采用横向比较的方法
        int len = strs[0].length();
        for (int i = 0; i < strs.length-1; i++) {
            if (len == 0)
                break;
            for (int j = 0;j < len && j < strs[i+1].length(); j++) {
                if (strs[i].charAt(j) != strs[i+1].charAt(j)) {
                    len = j;
                    break;
                }
            }
        }
        return strs[0].substring(0, len);
    }

    public static void main(String[] args) {
        Prob14 prob14 = new Prob14();
        System.out.println(prob14.longestCommonPrefix(new String[]{"a", "aa"}));
    }
}
