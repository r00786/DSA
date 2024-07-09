package com.example.programs.linkedlists;

import com.example.programs.Utils;

public class MiddleNode {
    public static void main(String[] args) {
        System.out.println(new MiddleNode().middleNode(Utils.convertArrayToLinkedList(new int[]{1,2,3,4,5})));
    }



    public ListNode middleNode(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while(fast!=null&&fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        return slow;
    }
}
