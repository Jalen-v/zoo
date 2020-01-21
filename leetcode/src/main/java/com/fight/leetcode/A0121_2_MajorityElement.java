package com.fight.leetcode;

/**
 * 169. 多数元素
 *
 * 给定一个大小为 n 的数组，找到其中的多数元素。多数元素是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。
 * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 *
 * 示例 1:
 * 输入: [3,2,3]
 * 输出: 3
 * 示例 2:
 *
 * 输入: [2,2,1,1,1,2,2]
 * 输出: 2
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/majority-element
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class A0121_2_MajorityElement {

    public static void main(String[] args) {
        Solution solution = new A0121_2_MajorityElement().new Solution();
        int[] nums = {7, 7, 1, 7, 1, 1 , 5, 7 , 5, 5, 7, 7 , 5};
        int i = solution.majorityElement(nums);
        System.out.println(i);
    }

    /**
     * 投票算法，只适用于多数元素出现次数大于n/2的情况
     * 1 当候选元素是众数时，能抵消相同数量的非众数
     * 2 当候选元素不是众数时，非众数自相抵消，由于众数大于n/2，所以不会影响
     */
    class Solution {
        public int majorityElement(int[] nums) {
            int count = 0;
            Integer candidate = null;

            for (int num : nums) {
                if (count == 0) {
                    candidate = num;
                }
                count += (num == candidate) ? 1 : -1;
            }

            return candidate;
        }
    }
}
