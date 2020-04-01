package org.leetcode.algorithm.list;

/**
 * @author JiangBin
 * @create 2020-04-01 11:06
 */
public class LeetCode_203_移除链表元素 {

    /**
     * 删除链表中等于给定值 val 的所有节点。
     * <p>
     * 示例:
     * <p>
     * 输入: 1->2->6->3->4->5->6, val = 6
     * 输出: 1->2->3->4->5
     *
     * @param head
     * @param val
     * @return
     */
    public ListNode removeElements(ListNode head, int val) {

        if (head == null) return null;

        ListNode newHead = new ListNode(0);  // 虚拟头节点
        ListNode currentNode = newHead;

        while (head != null) {
            if(head.val != val) {
                currentNode.next = head;
                currentNode = head;
            }
            head = head.next;
        }
        currentNode.next = null;
        return newHead.next;//返回虚拟头节点下一个链表头节点
    }


}
