import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Prob119 {
    public List<Integer> getRow(int rowIndex) {
        //           (n-k)
        // Cnk+1  = -------  Cnk
        //            k+1
        List<Integer> res = new LinkedList<>();
        res.add(1);
        int k = 0;
        long prev = 1;
        while (k < rowIndex) {
            prev = (rowIndex-k)*prev/(k+1);
            res.add((int)prev);
            k++;
        }
        return res;
    }

    public static void main(String[] args) {
        Prob119 prob119 = new Prob119();
        System.out.println(prob119.getRow(30));
    }
}
