package com.fight.leetcode;

/**
 * 371. 两整数之和
 * <p>
 * 不使用运算符 + 和 - ​​​​​​​，计算两整数 ​​​​​​​a 、b ​​​​​​​之和。
 * <p>
 * 示例 1:
 * <p>
 * 输入: a = 1, b = 2
 * 输出: 3
 * 示例 2:
 * <p>
 * 输入: a = -2, b = 3
 * 输出: 1
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sum-of-two-integers
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class A0222_2_SumOfTwoIntegers {

    class Solution {
        public int getSum(int a, int b) {
            if (a == 0)
                return b;
            if (b == 0)
                return a;
            return getSum((a ^ b), (a & b) << 1);
        }
    }
}
