package algo;

/**
 * Merge two sorted linked lists and return it as a new list. The new list should be made by splicing together the nodes of the first two lists.
 *
 * Example:
 *
 * Input: 1->2->4, 1->3->4
 * Output: 1->1->2->3->4->4
 * **/

public class LeetCode21 {

    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }

        @Override
        public String toString() {
            return String.format("Node(%d, next = %s)", val, next);
        }
    }

    public static void main(String[] args) {
        final ListNode node0 = new ListNode(1);
        final ListNode node1 = new ListNode(2);
        final ListNode node2 = new ListNode(4);

        final ListNode node3 = new ListNode(1);
        final ListNode node4 = new ListNode(3);
        final ListNode node5 = new ListNode(4);

        node0.next = node1;
        node1.next = node2;

        node3.next = node4;
        node4.next = node5;

        System.out.println(new LeetCode21().mergeTwoLists(node0, node3));
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode node1 = l1;
        ListNode node2 = l2;
        ListNode resultHead = new ListNode(0);
        ListNode result = resultHead;

        while (node1 != null || node2 != null) {
            if(node1 != null && node2 != null) {
                if(node1.val <= node2.val) {
                    result.next = node1;
                    node1 = node1.next;
                } else {
                    result.next = node2;
                    node2 = node2.next;
                }
            } else if(node1 == null) {
                result.next = node2;
                node2 = node2.next;
            } else if(node2 == null) {
                result.next = node1;
                node1 = node1.next;
            }
            result = result.next;
        }
        return resultHead.next;
    }
}
