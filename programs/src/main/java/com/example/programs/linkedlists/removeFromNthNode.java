package com.example.programs.linkedlists;

import com.example.programs.Utils;

/**
 * url - https://leetcode.com/problems/remove-nth-node-from-end-of-list/description/
 * Given the head of a linked list, remove the nth node from the end of the list and return its head.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: head = [1,2,3,4,5], n = 2
 * Output: [1,2,3,5]
 * Example 2:
 *
 * Input: head = [1], n = 1
 * Output: []
 * Example 3:
 *
 * Input: head = [1,2], n = 1
 * Output: [1]
 *
 *
 * Constraints:
 *
 * The number of nodes in the list is sz.
 * 1 <= sz <= 30
 * 0 <= Node.val <= 100
 * 1 <= n <= sz
 *
 */

public class removeFromNthNode {
    public static void main(String[] args) {
        System.out.println(new removeFromNthNode().removeNthFromEnd(Utils.convertArrayToLinkedList(new int[]{1,2}),2));
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head==null||head.next==null)return head.next;
        int length=0;
        ListNode current=head;
        while(current!=null){
            ++length;
            current=current.next;
        }
        current=head;
        int i=0;
        ListNode prevNode=null;
        while(current!=null){
            if(length-i==n){
                if(prevNode==null){
                    head=current.next;
                }else{
                    prevNode.next=current.next;
                }
                break;
            }
            ++i;
            prevNode=current;
            current=current.next;
        }

        return head;

    }
}
