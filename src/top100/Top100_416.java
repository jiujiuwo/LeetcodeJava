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
    public boolean canPartition1(int[] nums) {



        return false;
    }
}
