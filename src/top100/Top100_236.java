package top100;

/**
 * 二叉树的最近公共祖先
 */
public class Top100_236 {

    /**
     * 递归的做法，别人的做法，怎么变成自己的？
     *
     * @param root
     * @param p
     * @param q
     * @return
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == p || root == q || root == null) return root;
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        // 如果left 和 right都不为空，说明此时root就是最近公共节点
        // 如果left为空，right不为空，就返回right，说明目标节点是通过right返回的，反之亦然。
        if (left != null && right != null) return root;
        if (left == null) return right;
        return left;
    }

}

/**
 * Definition for a binary tree node.
 */
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}
