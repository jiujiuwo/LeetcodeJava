package top100;

import java.util.Stack;

/**
 * 394. 字符串解码
 * 初步判断用栈来做？
 */
public class Top100_394 {
    class Solution {
        public String decodeString(String s) {
            String result = "";
            if (null == s || s.length() == 0) {
                return result;
            }
            Stack<Character> stack = new Stack<>();
            for (int i = 0; i < s.length(); i++) {
                char ch = s.charAt(i);
                if (ch == '[') {
                    stack.push(ch);
                }else if(ch >= 'a'&& ch <='z'){

                }
            }
            return null;
        }
    }
}
