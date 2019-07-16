package algo;


/**
 * Sort a linked list in O(n log n) time using constant space complexity.
 *
 * Example 1:
 *
 * Input: 4->2->1->3
 * Output: 1->2->3->4
 * Example 2:
 *
 * Input: -1->5->3->4->0
 * Output: -1->0->3->4->5
 * */

public class LeetCode148 {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }

        @Override
        public String toString() {
            return String.format("Node(%d, next = %s)", val, next);
        }
    }

    public static void main(String[] args) {
        final ListNode node1 = new ListNode(4);
        final ListNode node2 = new ListNode(2);
        final ListNode node3 = new ListNode(1);
        final ListNode node4 = new ListNode(3);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;

        System.out.println(new LeetCode148().sortList(node1));
    }

    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode i = head;

        ListNode fast = head;
        ListNode slow = head;
        ListNode priorNode = new ListNode(Integer.MIN_VALUE);//the prior node of slow

        while(fast != null && fast.next != null) {
            fast = fast.next.next;

            priorNode = slow;
            slow = slow.next;
        }
        priorNode.next = null;
        ListNode j = slow;

        //i j is the head of left list and right list;
        i = sortList(i);
        j = sortList(j);
        System.out.println(String.format("merging [i:%s] [j:%s]", i.val, j.val));
        return merge(i, j);//return the new head;
    }

    private ListNode merge(ListNode i, ListNode j) {
        ListNode node1 = i;
        ListNode node2 = j;

        ListNode resultHead  = new ListNode(Integer.MIN_VALUE);
        ListNode result = resultHead;

        while(node1 != null || node2 != null) {
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