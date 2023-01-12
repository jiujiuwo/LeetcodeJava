package top100;

/**
 * 二叉树的最近公共祖先
 */
public class Top100_236 {

    /**
     * 递归的做法，别人的做法，怎么变成自己的？
     * <p>
     * 递归
     *
     * @param root
     * @param p
     * @param q
     * @return
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // 最重要的一步，递归判断传入进来的结点，是否是，p或者q，如果是的话，返回当前结点，
        // 如果为空的话，也返回上层结点，通过后面判断是否为null,来判断left和right是否包含P或者Q
        if (root == p || root == q || root == null) return root;
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        // 如果左右子树查找结果都不为空，则说明传入的root即为最近祖先结点
        if (left != null && right != null) return root;
        // 代码能走到这里，说明左右子树至少有一个子树是最近祖先结点，因为先调用的左子树的递归，因此如果左子树中没有找到p或q
        // 则最近祖先结点一定是在右子树中。
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
