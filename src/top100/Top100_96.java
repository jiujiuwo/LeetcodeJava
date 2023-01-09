package top100;

/**
 * 96. 不同的二叉搜索树
 * 动态规划？公式？
 */
public class Top100_96 {

    /**
     * n=1，res = 1
     * n=2,res = 2
     * n=3,res =
     * 动态规划，找规律？
     *
     * @param n
     * @return
     */
    public int numTrees(int n) {

        int[] G = new int[n + 1];
        G[0] = 1;
        G[1] = 1;

        for (int i = 2; i <= n; ++i) {
            for (int j = 1; j <= i; ++j) {
                G[i] += G[j - 1] * G[i - j];
            }
        }
        return G[n];
    }
}