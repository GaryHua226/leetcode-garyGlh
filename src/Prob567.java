import java.util.Arrays;
import java.util.Calendar;
import java.util.HashMap;

public class Prob567 {
    public boolean checkInclusion(String s1, String s2) {
        int[] map = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            map[s1.charAt(i)-'a'] += 1;
        }
        int count = s1.length();
        int left = 0, right = 0;
        int[] record = new int[26];
        System.arraycopy(map, 0, record, 0, 26);
        while (right < s2.length()) {
            if (map[s2.charAt(right)-'a'] == 0) {
                // 出现了不在s1中的字符，更新left,right,record,count
                System.arraycopy(map, 0, record, 0, 26);
                right++;
                left = right;
                count = s1.length();
            } else {
                // 字符在s1中有出现
                if (record[s2.charAt(right)-'a'] == 0) {
                    if (count == 0) {
                        return true;
                    } else {
                        // s2.char(j)这个字符用完了，得更新左指针
                        record[s2.charAt(left)-'a']++;
                        left++;
                        count++;
                    }
                } else {
                    record[s2.charAt(right)-'a']--;
                    right++;
                    count--;
                    if (count == 0)
                        return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Prob567 prob567 = new Prob567();
        System.out.println(prob567.checkInclusion("ab","eidbaoo"));
    }
}
