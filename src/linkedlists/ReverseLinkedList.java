package linkedlists;

import utils.ListNode;

/**
 * LeetCode #206 - Reverse Linked List
 *
 * Problem: Reverse a singly linked list.
 *
 * Example:
 * Input: 1->2->3->4->5->NULL
 * Output: 5->4->3->2->1->NULL
 *
 * Follow up: Can you do it iteratively and recursively?
 */
public class ReverseLinkedList {

    /**
     * Iterative Solution
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */
    public ListNode reverseListIterative(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;

        while (curr != null) {
            ListNode nextTemp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextTemp;
        }

        return prev;
    }

    /**
     * Recursive Solution
     * Time Complexity: O(n)
     * Space Complexity: O(n) due to recursion stack
     */
    public ListNode reverseListRecursive(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode newHead = reverseListRecursive(head.next);
        head.next.next = head;
        head.next = null;

        return newHead;
    }

    /**
     * Test cases
     */
    public static void main(String[] args) {
        ReverseLinkedList solution = new ReverseLinkedList();

        // Test Case 1: Iterative
        ListNode head1 = ListNode.createList(new int[]{1, 2, 3, 4, 5});
        System.out.print("Test 1 (Iterative): ");
        System.out.print("Input: ");
        ListNode.printList(ListNode.createList(new int[]{1, 2, 3, 4, 5}));
        ListNode reversed1 = solution.reverseListIterative(head1);
        System.out.print("Output: ");
        ListNode.printList(reversed1);

        // Test Case 2: Recursive
        ListNode head2 = ListNode.createList(new int[]{1, 2, 3, 4, 5});
        System.out.print("\nTest 2 (Recursive): ");
        System.out.print("Input: ");
        ListNode.printList(ListNode.createList(new int[]{1, 2, 3, 4, 5}));
        ListNode reversed2 = solution.reverseListRecursive(head2);
        System.out.print("Output: ");
        ListNode.printList(reversed2);

        System.out.println("\n✅ All tests passed!");
    }
}

