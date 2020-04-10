package org.leetcode.algorithm.string;

/**
 * @author JiangBin
 * @create 2020-04-10 11:15
 * <p>
 * <p>
 * 给定一个字符串，逐个翻转字符串中的每个单词。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入: "the sky is blue"
 * 输出: "blue is sky the"
 * 示例 2：
 * <p>
 * 输入: "  hello world!  "
 * 输出: "world! hello"
 * 解释: 输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。
 * 示例 3：
 * <p>
 * 输入: "a good   example"
 * 输出: "example good a"
 * 解释: 如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。
 *  
 * <p>
 * 说明：
 * <p>
 * 无空格字符构成一个单词。
 * 输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。
 * 如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。
 *  
 * <p>
 * 进阶：
 * <p>
 * 请选用 C 语言的用户尝试使用 O(1) 额外空间复杂度的原地解法。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-words-in-a-string
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode_151_翻转字符串里的单词 {

    public String reverseWords(String s) {
        if (s == null) return "";

        char[] chars = s.toCharArray();

        int len = 0;

        int cur = 0;
        boolean space = true; //前一个字符是否为空格字符
        for (int i = 0; i < chars.length; i++) {

            if (chars[i] != ' ') {//chars[i] 为非空字符
                chars[cur++] = chars[i];
                space = false;
            } else if (space == false) {
                chars[cur++] = ' ';
                space = true;
            }

        }
        len = space ? cur - 1 : cur;
        if (len <= 0) return "";

        reverse(chars, 0, len); //对整个字符串进行逆序

        int preSpaceIndex = -1;//上一个为' '字符的索引
        for (int i = 0; i < len; i++) {
            if (chars[i] == ' ') {//chars[i] 为非空字符
                reverse(chars, preSpaceIndex + 1, i);
                preSpaceIndex = i;
            }
        }
        reverse(chars, preSpaceIndex + 1, len);
        return new String(chars,0,len);
    }

    /**
     * 将[lIndex,rIndex)字符串逆序
     *
     * @param chars
     * @param lIndex
     * @param rIndex
     */
    private void reverse(char[] chars, int lIndex, int rIndex) {
        rIndex--;
        while (lIndex < rIndex) {
            char temp = chars[lIndex];
            chars[lIndex] = chars[rIndex];
            chars[rIndex] = temp;
            lIndex++;
            rIndex--;
        }

    }


    public static void main(String[] args) {
        LeetCode_151_翻转字符串里的单词 test = new LeetCode_151_翻转字符串里的单词();

        System.out.println(test.reverseWords("the sky is blue"));

    }
}
