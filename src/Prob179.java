import java.util.Arrays;
import java.util.Comparator;

public class Prob179 {
    public String largestNumber(int[] nums) {
        int n = nums.length;
        String[] strs = new String[n];
        for (int i = 0; i < n; i++) {
            strs[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(strs, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return (o1+o2).compareTo(o2+o1);
            }
        });
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(strs[i]);
        }
        while (sb.charAt(0) == '0' && sb.length() > 1) {
            sb.delete(0, 1);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(new Prob179().largestNumber(new int[]{0, 0}));
    }
}
