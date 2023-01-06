package top100;

import java.util.Stack;

/**
 * 394. 字符串解码
 * 初步判断用栈来做？
 * 想到了用栈来操作，但是没有实现，我想的是每个字母出栈以后怎么做，实际应该是等整个[]出栈,然后再弹出一位必是数字
 */
public class Top100_394 {
    class Solution {
        public String decodeString(String s) {
            String result = "";
            if (null == s || s.length() == 0) {
                return result;
            }
            String tmp = String.valueOf(0);
            for (int i = 0; i < s.length(); ) {
                char ch = s.charAt(i);
                //如果是字母，直接追加
                if (ch >= 'a' && ch <= 'z') {
                    result += ch;
                    i++;
                    continue;
                }
                //如果是数字，则扫描后续内容入栈，直到遇到第一个']'
                if (ch >= '0' && ch <= '9') {
                    tmp += ch;
                    i++;
                    continue;
                }
                //如果是[,则
            }
            return null;
        }
    }
}
