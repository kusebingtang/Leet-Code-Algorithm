package org.leetcode.algorithm.string;

/**
 * @author JiangBin
 * @create 2020-07-05 15:21
 */
public class LeetCode_44_通配符匹配 {
    /**
     * 给定一个字符串 (s) 和一个字符模式 (p) ，实现一个支持 '?' 和 '*' 的通配符匹配。
     * <p>
     * '?' 可以匹配任何单个字符。
     * '*' 可以匹配任意字符串（包括空字符串）。
     * 两个字符串完全匹配才算匹配成功。
     * <p>
     * 说明:
     * <p>
     * s 可能为空，且只包含从 a-z 的小写字母。
     * p 可能为空，且只包含从 a-z 的小写字母，以及字符 ? 和 *。
     * 示例 1:
     * <p>
     * 输入:
     * s = "aa"
     * p = "a"
     * 输出: false
     * 解释: "a" 无法匹配 "aa" 整个字符串。
     * <p>
     * <p>
     * 示例 2:
     * <p>
     * 输入:
     * s = "aa"
     * p = "*"
     * 输出: true
     * 解释: '*' 可以匹配任意字符串。
     * <p>
     * <p>
     * 示例 3:
     * <p>
     * 输入:
     * s = "cb"
     * p = "?a"
     * 输出: false
     * 解释: '?' 可以匹配 'c', 但第二个 'a' 无法匹配 'b'。
     * <p>
     * <p>
     * 示例 4:
     * <p>
     * 输入:
     * s = "adceb"
     * p = "*a*b"
     * 输出: true
     * 解释: 第一个 '*' 可以匹配空字符串, 第二个 '*' 可以匹配字符串 "dce".
     * <p>
     * <p>
     * 示例 5:
     * <p>
     * 输入:
     * s = "acdcb"
     * p = "a*c?b"
     * 输出: false
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/wildcard-matching
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param s
     * @param p
     * @return
     */

    public boolean isMatch(String s, String p) {
        if (s == null || p == null) {
            return false;
        }

        int i = 0, j = 0; //i 表示 s 移动的指针 j表示p移动的指针
        int startPos = -1; //* position
        int match = -1; //匹配*用的

        while (i < s.length()) {
            //如果 s.charAt(i) == p.charAt(j) 相同，两个指针下移
            if (j < p.length() && (s.charAt(i) == p.charAt(j)|| p.charAt(j) == '?')) {
                i++;
                j++;
            }
            //匹配到*
            else if (j < p.length() && p.charAt(j) == '*') {
                startPos = j;
                match = i;
                j++;
            } else if (startPos != -1) {
                match++;
                i = match;
                j = startPos + 1;
            } else {
                return false;
            }
        }

        while (j < p.length() && p.charAt(j) == '*') j++;

        return j == p.length();
    }

    public static void main(String[] args) {

        LeetCode_44_通配符匹配 test = new LeetCode_44_通配符匹配();

        test.isMatch("aa","a");

    }
}
