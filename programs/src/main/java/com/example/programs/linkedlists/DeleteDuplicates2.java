package com.example.programs.linkedlists;

import com.example.programs.Utils;

/**
 * url- https://leetcode.com/problems/remove-duplicates-from-sorted-list-ii/description/
 * Given the head of a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list. Return the linked list sorted as well.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: head = [1,2,3,3,4,4,5]
 * Output: [1,2,5]
 * Example 2:
 *
 *
 * Input: head = [1,1,1,2,3]
 * Output: [2,3]
 *
 *
 * Constraints:
 *
 * The number of nodes in the list is in the range [0, 300].
 * -100 <= Node.val <= 100
 * The list is guaranteed to be sorted in ascending order.
 */
public class DeleteDuplicates2 {
    public static void main(String[] args) {
        System.out.println(new DeleteDuplicates2().deleteDuplicates(Utils.convertArrayToLinkedList(new int[]{1,2,3,3,4,4,5})));
    }


    public ListNode deleteDuplicates(ListNode head) {
        ListNode current=head;
        ListNode prevNode=null;
        while(current!=null&&current.next!=null){
            if(current.val==current.next.val){
                ListNode inner=current;
                while(inner!=null&&inner.val==current.val){
                    inner=inner.next;
                }
                if(prevNode!=null){
                    prevNode.next=inner;
                    current=prevNode;
                }else{
                    head=inner;
                    current=head;
                }
            }else{
                prevNode=current;
                current=current.next;
            }

        }
        return head;
    }
}
