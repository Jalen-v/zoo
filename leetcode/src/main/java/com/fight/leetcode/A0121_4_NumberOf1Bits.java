package com.fight.leetcode;

/**
 * 191. 位1的个数
 *
 * 编写一个函数，输入是一个无符号整数，返回其二进制表达式中数字位数为 ‘1’ 的个数（也被称为汉明重量）。
 *
 * 示例 1：
 * 输入：00000000000000000000000000001011
 * 输出：3
 * 解释：输入的二进制串 00000000000000000000000000001011 中，共有三位为 '1'。
 *
 * 示例 2：
 * 输入：00000000000000000000000010000000
 * 输出：1
 * 解释：输入的二进制串 00000000000000000000000010000000 中，共有一位为 '1'。
 *
 * 示例 3：
 * 输入：11111111111111111111111111111101
 * 输出：31
 * 解释：输入的二进制串 11111111111111111111111111111101 中，共有 31 位为 '1'。
 *  
 *
 * 提示：
 * 请注意，在某些语言（如 Java）中，没有无符号整数类型。在这种情况下，输入和输出都将被指定为有符号整数类型，并且不应影响您的实现，因为无论整数是有符号的还是无符号的，其内部的二进制表示形式都是相同的。
 * 在 Java 中，编译器使用二进制补码记法来表示有符号整数。因此，在上面的 示例 3 中，输入表示有符号整数 -3。
 *  
 *
 * 进阶:
 * 如果多次调用这个函数，你将如何优化你的算法？
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/number-of-1-bits
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class A0121_4_NumberOf1Bits {

    public static void main(String[] args) {
        Solution solution = new A0121_4_NumberOf1Bits().new Solution();
        int n = -3;
        int i = solution.hammingWeight(n);
        System.out.println(i);
    }

    public class Solution {
        // you need to treat n as an unsigned value
        public int hammingWeight(int n) {
            int count = 0;
            for(int i=0; i<32; i++) {
                if ((n & 1) != 0) {
                    count++;
                }
                n >>= 1;
            }
            return count;
        }

        /**
         * 这里用一个trick， 可以轻松求出。 就是n & (n - 1) 可以消除 n 最后的一个1的原理。
         *
         * 为什么能消除最后一个1， 其实也比较简单，大家自己想一下
         *
         * 这样我们可以不断进行n = n & (n - 1)直到n === 0 ， 说明没有一个1了。 这个时候我们消除了多少1变成一个1都没有了， 就说明n有多少个1了。
         * @param n
         * @return
         */
        public int hammingWeight2(int n) {
            int sum = 0;
            while (n != 0) {
                sum++;
                n &= (n - 1);
            }
            return sum;
        }
    }
}
