package com.fight.leetcode;

/**
 * 53. 最大子序和
 *
 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 *
 * 示例:
 *
 * 输入: [-2,1,-3,4,-1,2,1,-5,4],
 * 输出: 6
 * 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
 * 进阶:
 *
 * 如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的分治法求解。
 *
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximum-subarray
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class A0112_3_MaximumSubarray {

    public static void main(String[] args) {
        int[] nums = new int[]{-2,1,-3,4,-1,2,1,-5,4};
        Solution solution = new A0112_3_MaximumSubarray().new Solution();
//        int max = solution.maxSubArray(nums);
        int max = solution.maxSubArray2(nums);
        System.out.println(max);
    }

    class Solution {
        /**
         * 我们定义函数 S(i) ，它的功能是计算以 0（包括 0）开始加到 i（包括 i）的值。
         * 那么 S(j) - S(i - 1) 就等于 从 i 开始（包括 i）加到 j（包括 j）的值。
         * 我们进一步分析，实际上我们只需要遍历一次计算出所有的 S(i), 其中 i = 0,1,2....,n-1。
         * 然后我们再减去之前的 S(k),其中 k = 0，1，i - 1，中的最小值即可。 因此我们需要 用一个变量来维护这个最小值，还需要一个变量维护最大值。
         * @param nums
         * @return
         */
        public int maxSubArray(int[] nums) {
            int sum = 0;
            int maxSum = nums[0];
            int minSum = 0;
            for (int i = 0; i< nums.length; i++) {
                sum += nums[i];
                maxSum = Math.max(maxSum, sum - minSum);
                minSum = Math.min(minSum, sum);
            }
            return maxSum;
        }

        /**
         * 动态规划的难点在于找到状态转移方程，
         * dp[i] - 表示到当前位置 i 的最大子序列和
         * 状态转移方程为： dp[i] = max(dp[i - 1] + nums[i], nums[i])
         * 初始化：dp[0] = nums[0]
         *
         * 从状态转移方程中，我们只关注前一个状态的值，所以不需要开一个数组记录位置所有子序列和，只需要两个变量，
         * currMaxSum - 累计最大和到当前位置i
         * maxSum - 全局最大子序列和:
         *
         * currMaxSum = max(currMaxSum + nums[i], nums[i])
         * maxSum = max(currMaxSum, maxSum)
         *
         * @param nums
         * @return
         */
        public int maxSubArray2(int[] nums) {
            int currentMaxSum = nums[0];
            int maxSum = nums[0];
            for (int i = 0; i< nums.length; i++) {
                currentMaxSum = Math.max(currentMaxSum + nums[i], nums[i]);
                maxSum = Math.max(maxSum, currentMaxSum);
            }
            return maxSum;
        }
    }
}
