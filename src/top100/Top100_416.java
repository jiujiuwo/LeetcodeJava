package top100;

import java.util.Arrays;

/**
 * 分割等和子集
 */
public class Top100_416 {

    /**
     * 答案错误，通过率 72/141
     * 该方法只适合没有重复数字的时候
     *
     * @param nums
     * @return
     */
    public boolean canPartition(int[] nums) {
        int yushu = Arrays.stream(nums).sum() % 2;
        // 除以2，余数不为0，不为复数，不能分割。
        if (yushu != 0) {
            return false;
        }
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            int sum1 = 0;
            for (int j = 0; j <= i; j++) {
                sum1 += nums[j];
            }
            int sum2 = 0;
            for (int k = i + 1; k < nums.length; k++) {
                sum2 += nums[k];
            }
            if (sum1 != 0 && sum1 == sum2) {
                return true;
            }
        }
        return false;
    }

    /**
     * 0-1背包，动态规划？
     *
     * @param nums
     * @return
     */
    /**
     * 思想：转换为01背包问题
     * dp[i][j]:容量为j的前i个物品所能组成的最大价值
     * bagsize:sum/2  weight[i]:nums[i]  value[i]:nums[i]
     * 原因：当容量为sum/2时如果刚好能装满，那么最后对应的最大价值一定是sum/2,因为 每块物品的重量和价值是相等的，你装进了sum/2的重量(前面刚说了装满的情况下)，那么它的价值一定是sum/2
     */
    public boolean canPartition1(int[] nums) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        //初筛
        if (sum % 2 == 1) {
            return false;
        }
        //动态规划
        //背包容量
        int target = sum / 2;
        int[][] dp = new int[nums.length + 1][target + 1];
        //采用二维dp:物品是从第一个物品开始、背包也是从容量为1开始(0行、0列都已经初始化过了，所以前期dp数组无需再初始化了)
        for (int i = 1; i <= nums.length; i++) {
            for (int j = 1; j <= target; j++) {
                //注意这里为什么不是nums[i]呢？是因为nums索引与dp数组索引本身就差1
                // 这行代码的意思是：判断当前容量能不能容下当前物品
                if (j < nums[i - 1]) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - nums[i - 1]] + nums[i - 1]);
                }

            }
        }
        return dp[nums.length][target] == target;
    }

    /**
     * 官方题解，0-1背包问题，关键是画出0-1背包的二维数组
     * @param nums
     * @return
     */
    public boolean canPartition2(int[] nums) {
        int n = nums.length;
        if (n < 2) {
            return false;
        }
        int sum = 0, maxNum = 0;
        for (int num : nums) {
            sum += num;
            maxNum = Math.max(maxNum, num);
        }
        if (sum % 2 != 0) {
            return false;
        }
        int target = sum / 2;
        if (maxNum > target) {
            return false;
        }
        boolean[][] dp = new boolean[n][target + 1];
        for (int i = 0; i < n; i++) {
            dp[i][0] = true;
        }
        dp[0][nums[0]] = true;
        for (int i = 1; i < n; i++) {
            int num = nums[i];
            for (int j = 1; j <= target; j++) {
                if (j >= num) {
                    dp[i][j] = dp[i - 1][j] | dp[i - 1][j - num];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[n - 1][target];
    }

}
