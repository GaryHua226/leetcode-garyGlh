import leetcodeUtil.TreeNode;

public class Prob993 {
    private int pX, pY;
    private int dX, dY;
    private boolean fX, fY;
    public boolean isCousins(TreeNode root, int x, int y) {
        if (root.val == x || root.val == y) {
            return false;
        }
        dfs(root, x, y, 0);
        return dX==dY && pX!=pY;
    }

    public void dfs(TreeNode root, int x, int y, int d) {
        if (fX && fY) {
            return;
        }
        if (root.left != null) {
            if (root.left.val == x) {
                pX = root.val;
                dX = d + 1;
                fX = true;
            }
            if (root.left.val == y) {
                pY = root.val;
                dY = d + 1;
                fY = true;
            }
            dfs(root.left, x, y, d+1);
        }

        if (root.right != null) {
            if (root.right.val == x) {
                pX = root.val;
                dX = d + 1;
                fX = true;
            }
            if (root.right.val == y) {
                pY = root.val;
                dY = d + 1;
                fY = true;
            }
            dfs(root.right, x, y, d+1);
        }
    }

}
