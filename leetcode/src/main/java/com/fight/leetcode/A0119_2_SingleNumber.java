package com.fight.leetcode;

public class A0119_2_SingleNumber {
    public static void main(String[] args) {
        Solution solution = new A0119_2_SingleNumber().new Solution();
        int[] nums = {2,2,1};
        int i = solution.singleNumber(nums);
        System.out.println(i);

        System.out.println(123^132);
        System.out.println(123^123);
        System.out.println(10^5);
        System.out.println(10^14);
        System.out.println(12^3);
    }

    class Solution {
        public int singleNumber(int[] nums) {
            int result = 0;
            for (int num : nums) {
                result ^= num;
            }
            return result;
        }
    }
}
