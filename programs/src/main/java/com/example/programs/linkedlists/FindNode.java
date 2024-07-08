package com.example.programs.linkedlists;

import com.example.programs.Utils;

/**
 * Example 3: Given the head of a linked list and an integer k, return the
 * 𝑘
 * 𝑡
 * ℎ
 * k
 * th
 *   node from the end.
 *
 * For example, given the linked list that represents 1 -> 2 -> 3 -> 4 -> 5 and k = 2, return the node with value 4, as it is the 2nd node from the end.
 *
 * This problem is very similar to the first example. Again, we could just convert the list to an array, or we could iterate through once to find the length and then iterate again once we know the length, but there is a more elegant solution.
 *
 * If we separate the two pointers by a gap of k, and then move them at the same speed, they will always be k apart. When the fast pointer (the one further ahead) reaches the end, then the slow pointer must be at the desired node, since it is k nodes behind.
 */
public class FindNode {
    public static void main(String[] args) {
        System.out.println(new FindNode().findNode(Utils.convertArrayToLinkedList(new int[]{1 , 2 , 3 , 4 , 5}),2));
    }


    ListNode findNode(ListNode head, int k) {
      ListNode slow=head;
      ListNode fast=head;
      for(int i=0;i<k;i++){
          fast=fast.next;
      }
      while (fast!=null){
          slow=slow.next;
          fast=fast.next;
      }

       return slow;

    }
}
