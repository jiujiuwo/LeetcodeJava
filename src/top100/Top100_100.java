package top100;

import java.util.Arrays;

public class Top100_100 {

    /**
     * 结果超时，通过率 47/48
     * @param temperatures
     * @return
     */
    public int[] dailyTemperatures2(int[] temperatures) {
        int length = temperatures.length;
        int[] result = new int[length];
        // 第一重循环，遍历数据，确定下标
        for (int i = 0; i < length; i++) {
            // 第二重循环，找出比i大的第一个数的下标，result[i]为下标之间的差值，即j-i,如果没有，则默认为0
            for (int j = i + 1; j < length; j++) {
                if (temperatures[j] > temperatures[i]) {
                    result[i] = j - i;
                    break;
                }
            }
        }
        return result;
    }

    public int[] dailyTemperatures(int[] temperatures) {
        int length = temperatures.length;
        int[] ans = new int[length];
        int[] next = new int[101];
        Arrays.fill(next, Integer.MAX_VALUE);
        for (int i = length - 1; i >= 0; --i) {
            int warmerIndex = Integer.MAX_VALUE;
            for (int t = temperatures[i] + 1; t <= 100; ++t) {
                if (next[t] < warmerIndex) {
                    warmerIndex = next[t];
                }
            }
            if (warmerIndex < Integer.MAX_VALUE) {
                ans[i] = warmerIndex - i;
            }
            next[temperatures[i]] = i;
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] input = {73, 74, 75, 71, 69, 72, 76, 73};
        int[] result = new Top100_100().dailyTemperatures2(input);
        Arrays.stream(result).forEach(item -> {
            System.out.print(item + " ");
        });
    }
}
