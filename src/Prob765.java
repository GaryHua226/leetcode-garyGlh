public class Prob765 {
    public int minSwapsCouples(int[] row) {
        // 贪心算法解决
        int[] a = new int[row.length]; // 记录每个人的情侣是谁
        int[] b = new int[row.length]; // 记录每个人所在的位置

        for (int i = 0;i < row.length; i+=2) {
            a[i] = i+1;
            a[i+1] = i;
        }

        for (int i = 0;i < row.length; i++) {
            b[row[i]] = i;
        }

        int x, y;
        int cnt = 0;
        for (int i = 0;i < row.length; i+=2) {
            x = row[i];
            y = row[i+1];
            if (a[x] != y) {
                // 如果这两个不是情侣
                // 把i+1位置换成i位置的情侣
                // x y ... a[x] => x a[x] ... y
                row[i+1] = a[x];
                row[b[a[x]]] = y;
                b[y] = b[a[x]];
                b[a[x]] = i+1;
                cnt++;
            }
        }
        return cnt;
    }
}
