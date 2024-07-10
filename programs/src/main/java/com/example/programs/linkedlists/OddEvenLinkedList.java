package com.example.programs.linkedlists;

/**
 * url- https://leetcode.com/problems/odd-even-linked-list/description/
 * Given the head of a singly linked list, group all the nodes with odd indices together followed by the nodes with even indices, and return the reordered list.
 *
 * The first node is considered odd, and the second node is even, and so on.
 *
 * Note that the relative order inside both the even and odd groups should remain as it was in the input.
 *
 * You must solve the problem in O(1) extra space complexity and O(n) time complexity.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: head = [1,2,3,4,5]
 * Output: [1,3,5,2,4]
 * Example 2:
 *
 *
 * Input: head = [2,1,3,5,6,4,7]
 * Output: [2,3,6,7,1,5,4]
 *
 *
 * Constraints:
 *
 * The number of nodes in the linked list is in the range [0, 104].
 * -106 <= Node.val <= 106
 */
public class OddEvenLinkedList {



    public ListNode oddEvenList(ListNode head) {
        if(head==null||head.next==null)return head;
        ListNode odd=null;
        ListNode even=null;
        ListNode evenStart=null;
        ListNode oddStart=null;
        ListNode current=head;
        int index=1;
        while(current!=null){
            boolean isOdd=index%2==0;
            ++index;
            if(isOdd){
                if(even==null){
                    even=new ListNode(current.val);
                    evenStart=even;
                }else{
                    even.next=new ListNode(current.val);
                    even=even.next;
                }

            }else{
                if(odd==null){
                    odd=new ListNode(current.val);
                    oddStart=odd;
                }else{
                    odd.next=new ListNode(current.val);
                    odd=odd.next;
                }
            }
            current=current.next;
        }
        odd.next=evenStart;

        return oddStart;

    }
}
