package com.example.programs.linkedlists;

import com.example.programs.Utils;

public class ReversingLinkedList {
    public static void main(String[] args) {
        System.out.println(new ReversingLinkedList().reverseList(Utils.convertArrayToLinkedList(new int[]{1,2,3,4,5})));
    }

    ListNode reverseList(ListNode head) {
        ListNode current = head;
        ListNode prev = null;
        while(current!=null){
            ListNode currentNext=current.next;
            current.next=prev;
            prev=current;
            current=currentNext;

        }
        return prev;
    }
    }
