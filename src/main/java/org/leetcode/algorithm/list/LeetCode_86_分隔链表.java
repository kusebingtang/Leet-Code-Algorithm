package org.leetcode.algorithm.list;

/**
 * @author JiangBin
 * @create 2020-04-01 12:03
 */
public class LeetCode_86_分隔链表 {

    public ListNode partition(ListNode head, int x) {

        if (head == null) return null;

        ListNode lDummyHead = new ListNode(0);  //left虚拟头节点
        ListNode lCurrent = lDummyHead;

        ListNode rDummyHead = new ListNode(0);  //right虚拟头节点
        ListNode rightCurrent = rDummyHead;

        while (head != null) {
            if(head.val< x) {  //串入左链表节点
                lCurrent.next = head;
                lCurrent = head;
            }else {  //串入右链表节点
                rightCurrent.next = head;
                rightCurrent = head;
            }
            head = head.next;
        }

        //完成后，把右链表断了(避免出现环)
        rightCurrent.next = null;

        //串起来左右链表
        lCurrent.next = rDummyHead.next;
        return lDummyHead.next;

    }
}
