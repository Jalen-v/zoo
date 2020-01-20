package com.fight.leetcode;

/**
 * 121. 买卖股票的最佳时机
 * <p>
 * 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
 * 如果你最多只允许完成一笔交易（即买入和卖出一支股票），设计一个算法来计算你所能获取的最大利润。
 * 注意你不能在买入股票前卖出股票。
 * <p>
 * 示例 1:
 * 输入: [7,1,5,3,6,4]
 * 输出: 5
 * 解释: 在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
 * 注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格。
 * 示例 2:
 * 输入: [7,6,4,3,1]
 * 输出: 0
 * 解释: 在这种情况下, 没有交易完成, 所以最大利润为 0。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class A0117_1_BestTimeToBuyAndSellStock {

    public static void main(String[] args) {
        Solution solution = new A0117_1_BestTimeToBuyAndSellStock().new Solution();
        int[] prices = new int[]{7, 1, 5, 3, 6, 4};
        int i = solution.maxProfit(prices);
        System.out.println(i);
    }

    class Solution {
        public int maxProfit(int[] prices) {
            int max = 0;
            for (int i = 1; i < prices.length; i++) {
                for (int j = 0; j < i; j++) {
                    int current = prices[i] - prices[j];
                    max = Math.max(max, current);
                }
            }
            return max;
        }

        /**
         * 使我们感兴趣的点是上图中的峰和谷。我们需要找到最小的谷之后的最大的峰。
         * 我们可以维持两个变量——minprice 和 maxprofit，它们分别对应迄今为止所得到的最小的谷值和最大的利润（卖出价格与最低价格之间的最大差值）。
         * @param prices
         * @return
         */
        public int maxProfit2(int[] prices) {
            if (prices.length == 0) {
                return 0;
            }
            int minValue = prices[0];
            int maxProfit = 0;
            for (int i = 0; i < prices.length; i++) {
                if (prices[i] < minValue) {
                    minValue = prices[i];
                } else {
                    maxProfit = Math.max(maxProfit, prices[i] - minValue);
                }
            }
            return maxProfit;
        }
    }
}
