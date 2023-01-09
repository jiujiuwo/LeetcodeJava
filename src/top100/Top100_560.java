package top100;

import java.util.Arrays;

/**
 * 和为k的连续子数组
 */
public class Top100_560 {

    /**
     * 暴力解法，通过率 63/91
     *
     * @param nums
     * @param k
     * @return
     */
    public int subarraySum(int[] nums, int k) {
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j < nums.length; j++) {
                //找出所有子数组
                int sum = 0;
                for (int m = i; m <= j; m++) {
                    sum += nums[m];
                }
                if (sum == k) {
                    result++;
                }
            }
        }
        return result;
    }
}
