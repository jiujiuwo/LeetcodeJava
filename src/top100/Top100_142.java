package top100;

import java.util.ArrayList;
import java.util.List;

/**
 * 142. 环形链表II
 */
public class Top100_142 {
    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    /**
     * Definition for singly-linked list.
     * class ListNode {
     * int val;
     * ListNode next;
     * ListNode(int x) {
     * val = x;
     * next = null;
     * }
     * }
     */
    public class Solution {

        /**
         * 使用hash,或者这种链表的方法来做，可以通过
         *
         * @param head
         * @return
         */
        public ListNode detectCycle(ListNode head) {
            List<ListNode> nodes = new ArrayList<>();
            ListNode ptr = head;
            while (ptr != null) {
                if (nodes.contains(ptr)) {
                    return ptr;
                }
                nodes.add(ptr);
                ptr = ptr.next;
            }
            return null;
        }
    }

    /**
     * 快慢指针做法
     *
     * @param head
     * @return
     */
    public ListNode detectCycle2(ListNode head) {
        ListNode fast = head, slow = head;

        // 先找出第一次相遇的位置，此时fast和slow分别走了 n 和 2n次环
        while (true) {
            if (fast == null || fast.next == null) return null;
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) break;
        }
        fast = head;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        return fast;
    }
}

