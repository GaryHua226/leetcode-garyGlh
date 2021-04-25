import leetcodeUtil.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Prob783 {
    public int minDiffInBST(TreeNode root) {
        ArrayList<Integer> arr = new ArrayList<>();
        in(arr, root);
        int res = Integer.MAX_VALUE;
        for (int i = 1; i < arr.size(); i++) {
            res = Math.min(res, arr.get(i) - arr.get(i-1));
        }
        return res;
    }

    public void in(List<Integer> lst, TreeNode root) {
        if (root == null) {
            return;
        }
        in(lst, root.left);
        lst.add(root.val);
        in(lst, root.right);
    }
}
