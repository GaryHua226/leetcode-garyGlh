import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Prob17 {
    public List<String> letterCombinations(String digits) {
        if (digits.length() == 0)
            return new ArrayList<>();

        int[] chs = new int[]{0,0,3,3,3,3,3,4,3,4}; //每个按键对应多少个字母
        String[] b=  new String[]{"", "","abc","def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"}; // 每个按键对饮的字母串
        // digits中每一位对应一次要写多少个
        int[] a = new int[digits.length()+1];
        a[a.length-2] = chs[digits.charAt(digits.length()-1)-'0'];
        a[a.length-1] = 1;
        for (int i = digits.length()-2; i >= 0; i--) {
            a[i] = chs[digits.charAt(i)-'0'] * a[i+1];
        }

        StringBuilder[] stringBuilders = new StringBuilder[a[0]];
        for (int i = 0;i < stringBuilders.length; i++) {
            stringBuilders[i] = new StringBuilder();
        }

        for (int i = 0; i < digits.length(); i++) {
            for (int j = 0;j < a[0]; j++) {
                int num = digits.charAt(i) - '0';
                stringBuilders[j].append(b[num].charAt(j/a[i+1]%chs[num]));
            }
        }

        List<String> res = new ArrayList<>();
        for (StringBuilder sb : stringBuilders)
            res.add(sb.toString());
        return res;
    }

    public static void main(String[] args) {
        Prob17 prob17 = new Prob17();
        prob17.letterCombinations("237");
    }
}
