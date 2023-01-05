package top100;

/**
 * 最大正方形
 * 类似题目，1277
 */
public class Top100_221 {
    class Solution {
        /**
         * 先试一下暴力破解法,暴力法需要四重循环？
         * 递归？？
         * 暴力法超出时间限制，通过率 76/78
         *
         * @param matrix
         * @return
         */
        public int maximalSquare(char[][] matrix) {
            if (matrix == null || matrix.length <= 0)
                return 0;
            int rows = matrix.length;
            int columns = matrix[0].length;
            // 最大正方形的边长取两者中较小的一个
            int max = Math.min(rows, columns);

            boolean checkPass;

            for (int len = max; len > 0; len--) {
                for (int row = 0; row + len <= rows; row++) {
                    for (int column = 0; column + len <= columns; column++) {

                        // 每次循环检查一个正方形时，先默认测试通过。

                        checkPass = true;
                        //判断正方形是否成立
                        for (int i = row; i < row + len; i++) {
                            for (int j = column; j < column + len; j++) {
                                if (matrix[i][j] == '0') {
                                    checkPass = false;
                                    break;
                                }
                            }
                            if (!checkPass) {
                                break;
                            }
                        }
                        if (checkPass) {
                            return (int) Math.pow(len, 2);
                        }
                    }
                }
            }
            return 0;
        }

        /**
         * 动态规划的方法
         * dp[i][j] 表示以 [i][j] 为右下角且值全为1的正方形的边长
         * 如果 matrix [i][j] = 0,则，dp[i][j] = 0;
         * 如果 matrix [i][j] = 1,则。dp[i][j] = min(dp[i-1][j],dp[i][j-1],dp[i-1][j-1]) +1
         *
         * @param matrix
         * @return
         */
        public int maximalSquare1(char[][] matrix) {
            if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
                return 0;
            }
            int rows = matrix.length;
            int cols = matrix[0].length;
            int[][] dp = new int[rows][cols];
            int max = 0;
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    if (matrix[i][j] == '0') {
                        dp[i][j] = 0;
                    } else {
                        if (i >= 1 && j >= 1) {
                            int min = Math.min(dp[i - 1][j], dp[i][j - 1]);
                            min = Math.min(dp[i - 1][j - 1], min);
                            dp[i][j] = min + 1;
                        } else {
                            dp[i][j] = 1;
                        }
                        max = Math.max(max, dp[i][j]);
                    }
                }
            }

            return (int)Math.pow(max,2);
        }
    }
}
