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

}
