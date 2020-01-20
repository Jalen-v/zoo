package com.fight.leetcode;

/**
 * 125. 验证回文串
 *
 * 给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
 * 说明：本题中，我们将空字符串定义为有效的回文串。
 *
 * 示例 1:
 * 输入: "A man, a plan, a canal: Panama"
 * 输出: true
 * 示例 2:
 * 输入: "race a car"
 * 输出: false
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/valid-palindrome
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class A0119_1_ValidPalindrome {

    public static void main(String[] args) {
        Solution solution = new A0119_1_ValidPalindrome().new Solution();
//        String s = "A man, a plan, a canal: Panama";
        String s = "race a car";
        boolean palindrome = solution.isPalindrome(s);
        System.out.println(palindrome);
    }

    class Solution {
        // 双指针
        public boolean isPalindrome(String s) {
            for (int begin = 0, end = s.length() - 1; begin < end; begin++, end--) {

                while (!isCharactor(s.charAt(begin)) && !isNumber(s.charAt(begin)) && begin < end) {
                    begin++;
                }
                while (!isCharactor(s.charAt(end)) && !isNumber(s.charAt(end)) && begin < end) {
                    end--;
                }

                char c1 = s.charAt(begin);
                char c2 = s.charAt(end);

                if (!(c1+"").equalsIgnoreCase(c2 + "")) {
                    return false;
                }
            }
            return true;
        }

        public boolean isCharactor(char ch) {
            if ((ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z')) {
                return true;
            }
            return false;
        }
        public boolean isNumber(char ch) {
            if (ch >= '0' && ch <= '9') {
                return true;
            }
            return false;
        }
    }

}
