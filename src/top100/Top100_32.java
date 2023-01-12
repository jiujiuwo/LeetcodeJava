package top100;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

/**
 * 最长有效括号
 * 使用动态规划，或者类似于单调栈来解题
 */
public class Top100_32 {

    /**
     * 暴力解法，暴力解法此题行不通，还是需要判断
     * 列举出所有的字串，判断字串是否正确，取最大的长度
     *
     * @param s
     * @return
     */
    public int longestValidParentheses(String s) {
        if (null == s || s.length() == 0) {
            return 0;
        }
        for (int max = s.length(); max > 0; max--) {
            for (int i = 0; i + max < s.length(); i++) {

            }
        }
        return 0;
    }

    /**
     * 错误解法
     * 输入"()(()"时，答案错误
     * 单个栈好像不太容易解决问题 ，用双栈试一试？
     *
     * @param s
     * @return
     */
    public int longestValidParentheses1(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int result = 0;
        int max = 0;
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char tmp = s.charAt(i);
            if (tmp == '(') {
                stack.push(tmp);
            } else if (tmp == ')') {
                if (!stack.isEmpty()) {
                    char pop = stack.pop();
                    if (pop == '(') {
                        result++;
                        max = Math.max(result, max);
                    }
                } else {
                    result = 0;
                }
            }
        }
        if (!stack.isEmpty()) {

        }

        return 2 * max;
    }

    /**
     * 双栈解法,也不太行
     * 错误解法
     *
     * @param s
     * @return
     */
    public int longestValidParentheses2(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int tmpMax = 0;
        int max = 0;
        Stack<Character> left = new Stack<>();
        Stack<Character> right = new Stack<>();

        // 什么时候需要重新开始计数？
        for (int i = 0; i < s.length(); i++) {
            char tmp = s.charAt(i);
            if (tmp == '(') {
                left.push(tmp);
            } else if (tmp == ')') {
                right.push(tmp);
                if (left.size() >= right.size()) {
                    tmpMax = right.size();
                    max = Math.max(tmpMax, max);
                } else {
                    max = Math.max(tmpMax, max);
                    tmpMax = 0;
                    left.clear();
                    right.clear();
                }
            }
        }

        return 2 * max;
    }

    /**
     * 使用栈来解题，将数组下标入栈
     * 栈 已知每个有限的括号字符串必须是连续的，那么可以用栈来寻找以某个字符结尾最长的有限长度。
     * 将栈底保存为最后一个未被匹配的右括号下标。 1.若当前字符为'(',直接将坐标放入栈中。 2.若当前字符为')'，
     * 先弹出栈顶坐标，若弹出后栈顶为空，那么代表这个')'未被匹配，放入栈中;若栈不为空，那么代表已经匹配了，
     * 这时候统计它的有限长度为i-栈顶坐标。
     *
     * @param s
     * @return
     */
    public int longestValidParentheses3(String s) {
        int maxans = 0;
        Deque<Integer> stack = new LinkedList<>();
        stack.push(-1);
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                stack.pop();
                // 这里栈为空时，将右括号也入了栈
                if (stack.isEmpty()) {
                    stack.push(i);
                } else {
                    maxans = Math.max(maxans, i - stack.peek());
                }
            }
        }
        return maxans;
    }

    /**
     * 啊，动态规划，太难了呀
     * @param s
     * @return
     */
    public int longestValidParentheses4(String s) {
        int n = s.length(), ans = 0;
        char[] arr = (" " + s).toCharArray();
        int[] dp = new int[n + 5];
        for (int i = 1; i <= n; i++) {
            if (arr[i] == '(') continue;
            if (arr[i - 1] == '(') dp[i] = Math.max(dp[i], i - 2 >= 0 ? dp[i - 2] + 2 : 0);
            else if (i - dp[i - 1] - 1 >= 1 && arr[i - dp[i - 1] - 1] == '(') dp[i] = Math.max(dp[i], dp[i - 1] + 2 + dp[i - dp[i - 1] - 2]);
            ans = Math.max(ans, dp[i]);
        }
        return ans;
    }


    public static void main(String[] args) {
        System.out.println(new Top100_32().longestValidParentheses3("()()()"));
    }
}
