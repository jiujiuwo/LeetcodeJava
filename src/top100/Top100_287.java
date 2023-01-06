package top100;

/**
 * 寻找重复数
 * 要求，只能使用O(1)的额外空间。
 */
public class Top100_287 {

    /**
     * 暴力解法
     * 通过率 55/58
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

}
