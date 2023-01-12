package top100;

import java.util.Stack;

/**
 * 最长有效括号
 */
public class Top100_32 {

    /**
     * 暴力解法
     * 列举出所有的字串，判断字串是否正确，取最大的长度
     *
     * @param s
     * @return
     */
    public int longestValidParentheses(String s) {
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
                    stack.pop();
                    result++;
                    max = Math.max(result, max);
                } else {
                    result = 0;
                }
            }
        }

        return 2 * max;
    }

    /**
     * 双栈解法
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
                if (left.size() > right.size()) {
                    tmpMax = right.size();
                } else if (left.size() == right.size()) {
                    tmpMax = right.size();
                } else {
                    max = Math.max(tmpMax, max);
                    left.clear();
                    right.clear();
                }
            }
        }

        return 2 * max;
    }
}
