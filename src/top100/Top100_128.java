package top100;

import java.util.Arrays;

/**
 * 128. 最长连续序列
 * 要求使用O（n）的时间复杂度解决该问题，应该就不能用排序了，排序没有O（n）的时间复杂度
 */
public class Top100_128 {
    public int longestConsecutive(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {

        }
        return 0;
    }

    /**
     * 没有考虑 负数的情况，后续补充
     * @param nums
     * @return
     */
    public int longestConsecutive1(int[] nums) {
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= max) {
                max = nums[i];
            }
        }
        int[] dp = new int[Math.max(max, nums.length) + 1];
        Arrays.fill(dp, 0);
        for (int i = 0; i < nums.length; i++) {
            dp[nums[i]] = 1;
        }
        int result = 0;
        int tmp = 0;
        for (int i = 0; i < dp.length; i++) {
            if (dp[i] == 1) {
                tmp++;
            } else {
                result = Math.max(tmp, result);
                tmp = 0;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] in = {0, 3, 7, 2, 5, 8, 4, 6, 0, 1};
        System.out.println(new Top100_128().longestConsecutive1(in));
    }
}
