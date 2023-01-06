package top100;

import java.util.LinkedList;
import java.util.Stack;

/**
 * 394. 字符串解码
 * 初步判断用栈来做？
 * 想到了用栈来操作，但是没有实现，我想的是每个字母出栈以后怎么做，实际应该是等整个[]出栈,然后再弹出一位必是数字
 */
public class Top100_394 {

    /**
     * 通过率  29 / 34，不清楚哪里还有问题。。。
     *
     * @param s
     * @return
     */
    public String decodeString(String s) {
        String result = "";
        String tmpResult = "";
        if (null == s || s.length() == 0) {
            return result;
        }
        int multi = 0;
        String stackS = "";
        Stack<Integer> intS = new Stack<>();
        Stack<String> strStack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '[') {
                intS.push(multi);
                if (stackS.length() > 0)
                    strStack.push(stackS);
                multi = 0;
                stackS = "";
            } else if (ch == ']') {
                int mul = intS.pop();
                String tmpS = "";
                if (!strStack.isEmpty()) {
                    tmpS = strStack.pop();
                }
                if (stackS.length() > 0) {
                    tmpResult += tmpS;
                    for (int j = 0; j < mul; j++) {
                        tmpResult += stackS;
                    }
                } else {
                    for (int j = 0; j < mul; j++) {
                        tmpResult += tmpS;
                    }
                }
                strStack.push(tmpResult);
                stackS = "";
                tmpResult = "";
            } else if (ch >= '0' && ch <= '9') {
                multi = 10 * multi + Integer.parseInt(ch + "");
            } else {
                stackS += ch;
            }
            if (i == s.length() - 1) {
                strStack.push(stackS);
            }
        }
        while (!strStack.isEmpty()) {
            result = strStack.pop() + result;
        }
        return result;
    }

    /**
     * 别人的100%的解法。
     *
     * @param s
     * @return
     */
    public String decodeString1(String s) {
        StringBuilder res = new StringBuilder();
        int multi = 0;
        LinkedList<Integer> stack_multi = new LinkedList<>();
        LinkedList<String> stack_res = new LinkedList<>();
        for (Character c : s.toCharArray()) {
            if (c == '[') {
                stack_multi.addLast(multi);
                stack_res.addLast(res.toString());
                multi = 0;
                res = new StringBuilder();
            } else if (c == ']') {
                StringBuilder tmp = new StringBuilder();
                int cur_multi = stack_multi.removeLast();
                for (int i = 0; i < cur_multi; i++) tmp.append(res);
                res = new StringBuilder(stack_res.removeLast() + tmp);
            } else if (c >= '0' && c <= '9') multi = multi * 10 + Integer.parseInt(c + "");
            else res.append(c);
        }
        return res.toString();
    }

    public static void main(String[] args) {
        String result = new Top100_394().decodeString("3[z]2[2[y]pq4[2[jk]e1[f]]]ef");
        System.out.println(result);
    }
}
