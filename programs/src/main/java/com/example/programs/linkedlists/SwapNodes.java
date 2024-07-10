package com.example.programs.linkedlists;

import com.example.programs.Utils;

/**
 * url- https://leetcode.com/problems/swapping-nodes-in-a-linked-list/description/
 * You are given the head of a linked list, and an integer k.
 *
 * Return the head of the linked list after swapping the values of the kth node from the beginning and the kth node from the end (the list is 1-indexed).
 *
 *
 *
 * Example 1:
 *
 *
 * Input: head = [1,2,3,4,5], k = 2
 * Output: [1,4,3,2,5]
 * Example 2:
 *
 * Input: head = [7,9,6,6,7,8,3,0,9,5], k = 5
 * Output: [7,9,6,6,8,7,3,0,9,5]
 *
 *
 * Constraints:
 *
 * The number of nodes in the list is n.
 * 1 <= k <= n <= 105
 * 0 <= Node.val <= 100
 */

public class SwapNodes {
    public static void main(String[] args) {
        System.out.println(new SwapNodes().swapNodes(Utils.convertArrayToLinkedList(new int[]{1,2,3,4,5}),2));
    }

    public ListNode swapNodes(ListNode head, int k) {
        ListNode node1=head;
        ListNode node2=head;
        k-=1;
        while((k--)>0)node1=node1.next;
        ListNode ref= node1;
        while(node1.next!=null){
            node1 = node1.next;
            node2 = node2.next;
        }
        int temp =node2.val;
        node2.val=ref.val;
        ref.val=temp;
        return head;

    }
}
