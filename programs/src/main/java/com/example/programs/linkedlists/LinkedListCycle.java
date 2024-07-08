package com.example.programs.linkedlists;

import com.example.programs.Utils;

import java.util.HashSet;
import java.util.Set;

public class LinkedListCycle {
    public static void main(String[] args) {
        ///the nodes needs to be cyclic in order to make this work be sure the nodes are cyclic
        System.out.println(new LinkedListCycle().hasCycle(Utils.convertArrayToLinkedList(new int[]{3, 2, 0, -4})));
        System.out.println(new LinkedListCycle().hasCycleWithSet(Utils.convertArrayToLinkedList(new int[]{3, 2, 0, -4})));

    }

        public boolean hasCycle(ListNode head) {
            if(head!=null&&head.next!=null){
                ListNode slow=head;
                ListNode fast=head;
                while(fast!=null&&fast.next!=null){
                    slow = slow.next;
                    fast = fast.next.next;
                    if(slow == fast){
                        return true;
                    }
                }
            }
            return false;
        }

    public boolean hasCycleWithSet(ListNode head) {
        Set<ListNode> heads= new HashSet();

        while(head!=null){
            if(heads.contains(head)){
                return true;
            }
            heads.add(head);
            head=head.next;
        }
        return false;
    }
}


