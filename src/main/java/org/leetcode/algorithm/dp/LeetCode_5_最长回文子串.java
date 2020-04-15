package org.leetcode.algorithm.dp;

/**
 * @author JiangBin
 * @create 2020-04-14 13:54
 * <p>
 * <p>
 * 5. 最长回文子串
 * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
 * <p>
 * 示例 1：
 * <p>
 * 输入: "babad"
 * 输出: "bab"
 * 注意: "aba" 也是一个有效答案。
 * 示例 2：
 * <p>
 * 输入: "cbbd"
 * 输出: "bb"
 */
public class LeetCode_5_最长回文子串 {

    public static  String longestPalindrome(String s) {

        if (s == null) return null;
        char[] cs = s.toCharArray();
        if (cs.length <= 1) return s;

        //最小回文子串长度，最少是1
        int maxLen = 1;

        int begin = 0;

        int totalLength = cs.length;

        int i = 0;
        while (i < totalLength) {
            int left = i - 1;
            int right = i;
            while (++right < totalLength && cs[right] == cs[i]) ;

            //right 会成为新的i
            i = right;

            //从left向左，right向右扩展
            while (left >= 0 && right < totalLength && cs[left] == cs[right]) {
                left--;
                right++;
            }

            //扩展结束后cs[left,right) 就是这一次扩展找到的最大回文子串
            //++left left就是找到的最大回文子串的开始索引
            int len = right - ++left;
            if (len > maxLen) {
                maxLen = len;
                begin = left;
            }
        }
        return new String(cs, begin, maxLen);
    }

    public static void main(String[] args) {
        System.out.println(longestPalindrome("bb"));
    }


}
