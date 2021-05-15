import java.util.HashMap;

public class Prob13 {
    public int romanToInt(String s) {
        HashMap<Character, Integer> roman2int = new HashMap<>();
        roman2int.put('I',1);
        roman2int.put('V',5);
        roman2int.put('X',10);
        roman2int.put('L',50);
        roman2int.put('C',100);
        roman2int.put('D',500);
        roman2int.put('M',1000);
        int res = 0;
        for (int i = 0; i < s.length() - 1; i++) {
            int curr = roman2int.get(s.charAt(i));
            int next = roman2int.get(s.charAt(i+1));
            if (curr < next) {
                res -= curr;
            } else {
                res += curr;
            }
        }
        res += roman2int.get(s.charAt(s.length()-1));
        return res;
    }

    public static void main(String[] args) {
        Prob13 prob13 = new Prob13();
        System.out.println(prob13.romanToInt("IV"));
    }
}
