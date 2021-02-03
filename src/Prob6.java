import java.util.Arrays;

public class Prob6 {
    public String convert(String s, int numRows) {
        if (numRows == 1)
            return s;
        StringBuilder[] stringBuilders = new StringBuilder[numRows];
        for (int i = 0;i <numRows; i++)
            stringBuilders[i] = new StringBuilder();
        int row = 0;
        boolean up = true;
        for (int i = 0;i < s.length(); i++) {
            stringBuilders[row].append(s.charAt(i));
            if (up) {
                row++;
                if (row == numRows) {
                    up = false;
                    row = numRows - 2;
                }
            } else {
                row--;
                if (row == -1) {
                    up = true;
                    row = 1;
                }
            }
        }
        StringBuilder res = new StringBuilder();
        for (StringBuilder stringBuilder : stringBuilders)
            res.append(stringBuilder.toString());
        return res.toString();
    }

    public static void main(String[] args) {
        Prob6 prob6 = new Prob6();
        System.out.println(prob6.convert("PAYPALISHIRING",3));
    }
}
