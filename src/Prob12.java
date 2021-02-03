public class Prob12 {
    public String intToRoman(int num) {
        String[][] roman = new String[][]{{"I", "V", "X"}, {"X", "L", "C"}, {"C", "D", "M"}, {"M"}};
        int i = 0;
        StringBuilder res = new StringBuilder();
        while (num > 0) {
            int temp = num % 10;
            StringBuilder bit = new StringBuilder();
            if (temp <= 3) {
                for (int j = 0;j < temp;j++)
                    bit.append(roman[i][0]);
            } else if (temp == 4) {
                bit.append(roman[i][0]);
                bit.append(roman[i][1]);
            } else if (temp == 5) {
                bit.append(roman[i][1]);
            } else if (temp <= 8) {
                bit.append(roman[i][1]);
                for (int j = 0;j < temp - 5; j++)
                    bit.append(roman[i][0]);
            } else {
                bit.append(roman[i][0]);
                bit.append(roman[i][2]);
            }
            res.insert(0, bit);
            i++;
            num /= 10;
        }
        return res.toString();
    }

    public static void main(String[] args) {
        Prob12 prob12 = new Prob12();
        System.out.println(prob12.intToRoman(1994));
    }
}
