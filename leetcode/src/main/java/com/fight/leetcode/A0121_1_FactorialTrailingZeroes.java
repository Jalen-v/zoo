package com.fight.leetcode;

/**
 * 172. 阶乘后的零
 *
 * 给定一个整数 n，返回 n! 结果尾数中零的数量。
 *
 * 示例 1:
 *
 * 输入: 3
 * 输出: 0
 * 解释: 3! = 6, 尾数中没有零。
 * 示例 2:
 *
 * 输入: 5
 * 输出: 1
 * 解释: 5! = 120, 尾数中有 1 个零.
 * 说明: 你算法的时间复杂度应为 O(log n) 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/factorial-trailing-zeroes
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class A0121_1_FactorialTrailingZeroes {

    public static void main(String[] args) {
        Solution solution = new A0121_1_FactorialTrailingZeroes().new Solution();
        int i = solution.trailingZeroes(10);
        System.out.println(i);
    }

    /**
     * 我们的结果并不是直接f(n) = n / 5, 比如n为30， 25中是有两个5的。 类似，n为150，会有7个这样的数字，通过观察我们发现规律f(n) = n/5 + n/5^2 + n/5^3 + n/5^4 + n/5^5+..
     */
    class Solution {
        public int trailingZeroes(int n) {
            int count = 0;
            while (n > 0) {
                count += n/5;
                n = n/5;
            }
            return count;
        }
    }
}
