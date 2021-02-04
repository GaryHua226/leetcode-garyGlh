public class Prob424 {
    public int characterReplacement(String s, int k) {
        if (s.length() < 2)
            return s.length();

        char[] schar = s.toCharArray();
        int[] freq = new int[26];
        int left = 0, right = 0;
        int maxCount = 0;
        int res = 0;
        while (right < s.length()) {
            freq[schar[right] - 'A']++;
            maxCount = Math.max(maxCount, freq[schar[right] - 'A']);
            right++;

            // 这里只用将left++的原因是我们要求最大的滑动窗口，因此只需要考虑将滑动窗口不断增大二不需要减小它
            if (right - left > maxCount + k) {
                freq[schar[left] - 'A']--;
                left++;
            }
            res = Math.max(res, right - left);
        }
        return res;
    }
}
