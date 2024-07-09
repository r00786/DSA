package com.example.programs.linkedlists;

import com.example.programs.Utils;

import java.util.HashSet;
import java.util.Set;

public class DeleteDuplicatesLinkedList {
    public static void main(String[] args) {
        System.out.println(new DeleteDuplicatesLinkedList().deleteDuplicates(Utils.convertArrayToLinkedList(new int[]{1,2,1})));
    }

    public ListNode deleteDuplicates(ListNode head) {
        Set<Integer> set= new HashSet();
        ListNode current=head;
        ListNode prevNode=head;
        while(current!=null){
            if(set.contains(current.val)){
                prevNode.next=current.next;
            }else{
                set.add(current.val);
                prevNode=current;
            }
            current=current.next;
        }
        return head;

    }
}
