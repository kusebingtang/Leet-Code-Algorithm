package org.leetcode.algorithm.list;

/**
 * @author JiangBin
 * @create 2020-04-01 12:13
 * <p>
 * <p>
 * <p>
 * 请判断一个链表是否为回文链表。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 1->2
 * 输出: false
 * 示例 2:
 * <p>
 * 输入: 1->2->2->1
 * 输出: true
 * 进阶：
 * 你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/palindrome-linked-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode_234_回文链表 {

    public boolean isPalindrome(ListNode head) {

        if (head == null || head.next == null) return true;
        if (head.next.next == null) return head.val == head.next.val;  //两个节点，要求两个节点的值必须相同




        return false;
    }
}
