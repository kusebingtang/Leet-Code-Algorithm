package org.leetcode.algorithm.dp;

/**
 * @author JiangBin
 * @create 2020-04-14 13:14
 */
public class LeetCode_121_买卖股票的最佳时机 {

    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        int max = 0;
        int sofarMin = prices[0];
        for (int i = 0; i < prices.length; ++i) {
            if (prices[i] > sofarMin) {
                max = Math.max(max, prices[i] - sofarMin);
            } else {
                sofarMin = prices[i];
            }
        }
        return max;
    }
}
