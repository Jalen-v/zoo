package com.fight.leetcode;

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
