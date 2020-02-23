package com.fight.leetcode;

/**
 * 203. 移除链表元素
 *
 * 删除链表中等于给定值 val 的所有节点。
 *
 * 示例:
 *
 * 输入: 1->2->6->3->4->5->6, val = 6
 * 输出: 1->2->3->4->5
 */
public class A0210_1_RemoveLinkedListElements {
    public static void main(String[] args) {
        A0210_1_RemoveLinkedListElements list = new A0210_1_RemoveLinkedListElements();
        Solution solution = list.new Solution();
        ListNode listNode = list.new ListNode(1);
        ListNode listNode1 = solution.removeElements(listNode, 1);
        System.out.println(listNode1);
    }

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode(int x) { val = x; }
     * }
     */
    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }

        @Override
        public String toString() {
            return "ListNode{" +
                    "val=" + val +
                    ", next=" + next +
                    '}';
        }
    }
    class Solution {
        public ListNode removeElements(ListNode head, int val) {
            while(head != null && head.val == val) {
                head = head.next;
            }
            ListNode current = head;
            while(current != null && current.next != null) {
                ListNode next = current.next;
                while(next != null && next.val == val) {
                    next = next.next;
                }
                current.next = next;
                current = next;
            }
            return head;
        }

        /**
         * 使用哨兵节点（虚拟节点）处理头部元素
         * @param head
         * @param val
         * @return
         */
        public ListNode removeElements2(ListNode head, int val) {
            ListNode sentinel = new ListNode(0);
            sentinel.next = head;

            ListNode prev = sentinel, curr = head;
            while (curr != null) {
                if (curr.val == val) prev.next = curr.next;
                else prev = curr;
                curr = curr.next;
            }
            return sentinel.next;
        }
    }
}
