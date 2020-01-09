package com.fight.leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 *
 * 20. 有效的括号
 *
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 *
 * 有效字符串需满足：
 *
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 注意空字符串可被认为是有效字符串。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/valid-parentheses
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class A0109_1_ValidParentheses {

    public static void main(String[] args) {
        Solution solution = new A0109_1_ValidParentheses().new Solution();
//        String str = "[(()[])]";
        String str = "()";
        boolean valid = solution.isValid(str);
        System.out.println(valid);
    }

    /**
     * 选择栈数据结构
     */
    class Solution {
        public boolean isValid(String s) {
            Stack<Character> stack = new Stack<>();
            Map<Character, Character> map = new HashMap<>();
            map.put(')','(');
            map.put(']','[');
            map.put('}','{');

            for (int i=0; i<s.length();i++) {
                char c = s.charAt(i);
                if (map.containsKey(c)) {
                    Character top = stack.isEmpty()?'#':stack.pop();
                    if (top != map.get(c)) {
                        return false;
                    }
                } else {
                    stack.push(c);
                }
            }
            return stack.isEmpty();
        }
    }
}

