import leetcodeUtil.TreeNode;

public class Prob897 {
    private TreeNode resNode;

    public TreeNode increasingBST(TreeNode root) {
        TreeNode dummyNode = new TreeNode(-1);
        resNode = dummyNode;
        inorder(root);
        return dummyNode.right;
    }

    public void inorder(TreeNode node) {
        if (node == null) {
            return ;
        }
        inorder(node.left);

        resNode.right = node;
        node.left = null;
        resNode = node;

        inorder(node.right);
    }
}
