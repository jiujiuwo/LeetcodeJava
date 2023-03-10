package top100;

import java.util.Arrays;
import java.util.Stack;

/**
 * 每日温度
 * 单调栈，相关题目
 * 问题本质，找出当前元素后，第一个比当前元素大的元素的下标
 * 496,901，42,84
 */
public class Top100_739 {

    /**
     * 结果超时，通过率 47/48
     *
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

    /**
     * 动态规划，从最后一个元素开始，倒序遍历
     *
     * @param temperatures
     * @return
     */
    public int[] dailyTemperatures4(int[] temperatures) {
        int length = temperatures.length;
        int[] result = new int[length];
        result[length - 1] = 0;
        // 开始倒序遍历
        for (int i = length - 2; i > 0; i--) {
            // 由于是倒序，那么i之后的 result[j]都已经确定好了。
            for (int j = i + 1; j < length; j += result[j]) {
                // 如果 后面的元素大于前面的元素，那么，result[i] 为两个元素的差值、
                if (temperatures[i] < temperatures[j]) {
                    result[i] = j - i;
                    break;
                    //如果后面的元素不大于前面的元素，则变动为0
                } else if (result[j] == 0) {
                    result[i] = 0;
                    break;
                }
            }
        }
        return result;
    }

    /**
     * 以空间换时间，单调栈？
     * 借用栈来存储 数组的下标。
     *  如果栈为空，则直接入栈，
     *  如果栈不为空，并且，当前元素大于栈顶元素，则找到了当前栈中元素的，后面第一个大于他们的值
     *  如果当前元素小于栈顶元素，则需要继续压栈。
     * @param temperatures
     * @return
     */
    public int[] dailyTemperatures3(int[] temperatures) {
        int length = temperatures.length;
        int[] result = new int[length];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < length; i++) {
            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                int index = stack.pop();
                result[index] = i - index;
            }
            stack.push(i);
        }
        return result;
    }

    /**
     * @param temperatures
     * @return
     */
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
        int[] result = new Top100_739().dailyTemperatures2(input);
        Arrays.stream(result).forEach(item -> {
            System.out.print(item + " ");
        });
    }
}
