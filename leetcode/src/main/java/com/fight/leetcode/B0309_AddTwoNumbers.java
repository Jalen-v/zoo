package com.fight.leetcode;

/**
 * 2. 两数相加
 *
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 *
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 *
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 *
 * 示例：
 *
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/add-two-numbers
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class B0309_AddTwoNumbers {
    public static void main(String[] args) {

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
    }
    class Solution {
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            ListNode listNode = new ListNode(0);
            ListNode dummyHead = listNode;
            int carry = 0;
            while(l1!=null || l2!=null || carry != 0) {
                int val1 = l1 == null?0:l1.val;
                int val2 = l2 == null?0:l2.val;
                int cur = (val1 + val2 + carry)%10;
                carry = (val1 + val2 + carry)/10;
                l1 = l1 == null ? null : l1.next;
                l2 = l2 == null ? null : l2.next;
                listNode.next = new ListNode(cur);
                listNode = listNode.next;
            }
            return dummyHead.next;
        }
    }
}
