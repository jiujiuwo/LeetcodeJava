package top100;

import java.util.Arrays;

/**
 * 寻找重复数
 * 要求，只能使用O(1)的额外空间。
 */
public class Top100_287 {

    /**
     * 暴力解法
     * 通过率 55/58
     *
     * @param nums
     * @return
     */
    public int findDuplicate(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (i != j && nums[i] == nums[j]) {
                    return nums[i];
                }
            }
        }
        return 0;
    }

    /**
     * 第二种解法，应该是什么思路呢？时间复杂度小于O（n2）
     * 排序后，遍历。
     * @param nums
     * @return
     */
    public int findDuplicate1(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == nums[i + 1]) {
                return nums[i];
            }
        }
        return 0;
    }
}
