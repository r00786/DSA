package com.example.programs.linkedlists;

import com.example.programs.Utils;

public class SwapPairs {
    public static void main(String[] args) {
        System.out.println(new SwapPairs().swapPairs(Utils.convertArrayToLinkedList(new int[]{1,2,3,4,5,6})));
    }


    public ListNode swapPairs(ListNode head) {
        if(head==null||head.next==null)return head;
        ListNode dummy=head.next;
        ListNode prev=null;

        while(head!=null&&head.next!=null){
            if(prev!=null){
                prev.next=head.next;
            }
            prev=head;
            ListNode nextNode= head.next.next;
            head.next.next=head;
            head.next = nextNode;
            head=nextNode;
        }

        return dummy;

    }
}
