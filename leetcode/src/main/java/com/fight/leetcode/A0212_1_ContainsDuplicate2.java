package com.fight.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * 219. 存在重复元素 II
 * <p>
 * 给定一个整数数组和一个整数 k，判断数组中是否存在两个不同的索引 i 和 j，使得 nums [i] = nums [j]，并且 i 和 j 的差的绝对值最大为 k。
 * 示例 1:
 * <p>
 * 输入: nums = [1,2,3,1], k = 3
 * 输出: true
 * 示例 2:
 * <p>
 * 输入: nums = [1,0,1,1], k = 1
 * 输出: true
 * 示例 3:
 * <p>
 * 输入: nums = [1,2,3,1,2,3], k = 2
 * 输出: false
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/contains-duplicate-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class A0212_1_ContainsDuplicate2 {

    public static void main(String[] args) {

    }

    class Solution {
        /**
         * 滑动窗口k
         * 时间复杂度 O(n min(n,k))
         * 空间复杂度 O(1)
         */
        public boolean containsNearbyDuplicate(int[] nums, int k) {
            int length = nums.length;
            for (int i = 0; i < length; i++) {
                for (int j = i + 1; j <= i + k && j < length; j++) {
                    if (nums[i] == nums[j]) {
                        return true;
                    }
                }
            }
            return false;
        }

        /**
         * 申请一个min(n,k)大小的空间
         * 时间复杂度 O(n)
         n* 空间复杂度 O(min(k,n))
         * @param nums
         * @param k
         * @return
         */
        public boolean containsNearbyDuplicate2(int[] nums, int k) {
            Set<Integer> set = new HashSet<>();
            for (int i = 0; i < nums.length; i++) {
                if (set.contains(nums[i])) {
                    return true;
                }
                set.add(nums[i]);
                if (set.size() > k) {
                    set.remove(nums[i - k]);
                }
            }
            return false;
        }
    }
}
