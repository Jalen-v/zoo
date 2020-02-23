package com.fight.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 560. 和为K的子数组
 *
 * 给定一个整数数组和一个整数 k，你需要找到该数组中和为 k 的连续的子数组的个数。
 *
 * 示例 1 :
 *
 * 输入:nums = [1,1,1], k = 2
 * 输出: 2 , [1,1] 与 [1,1] 为两种不同的情况。
 * 说明 :
 *
 * 数组的长度为 [1, 20,000]。
 * 数组中元素的范围是 [-1000, 1000] ，且整数 k 的范围是 [-1e7, 1e7]。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/subarray-sum-equals-k
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class A0219_1_SubArraySumEqualsK {
    public static void main(String[] args) {
        Solution solution = new A0219_1_SubArraySumEqualsK().new Solution();
        int i = solution.subarraySum(new int[]{1, 2, 3, 3, -3, 9}, 6);
        System.out.println(i);
    }

    class Solution {
        public int subarraySum(int[] nums, int k) {
            Map<Integer, Integer> map = new HashMap<>();
            int count = 0;
            int sum = 0;
            for (int num : nums) {
                sum += num;
                if (sum == k)
                    count++;
                if (map.containsKey(sum - k))
                    count += map.get(sum - k);

                if (map.containsKey(sum))
                    map.put(sum, map.get(sum) + 1);
                else
                    map.put(sum, 1);
            }
            return count;
        }
    }
}
