package com.example.programs.linkedlists;

import com.example.programs.Utils;

import java.util.List;

public class ReverseLinkedListBetween {
    public static void main(String[] args) {
        System.out.println(new ReverseLinkedListBetween().reverseBetween(Utils.convertArrayToLinkedList(new int[]{1,2,3,4,5,6}),2,5));
        System.out.println(new ReverseLinkedListBetween().reverseBetweenNodeReOrder(Utils.convertArrayToLinkedList(new int[]{1,2,3,4,5,6}),2,5));

    }

        boolean stop = false;
        ListNode leftNode;
        public ListNode reverseBetween(ListNode head, int left, int right) {
            this.leftNode=head;
            this.stop=false;
            recursiveReverse(head,left,right);
            return head;
        }

        public void recursiveReverse(ListNode rightNode,int left,int right){
            if(right==1){
                return;
            }
            if(left>1){
                this.leftNode=this.leftNode.next;
            }
            rightNode=rightNode.next;
            recursiveReverse(rightNode,left-1,right-1);
            if(this.leftNode==rightNode||this.leftNode==rightNode.next){
                this.stop=true;
            }
            if(!stop){
                int temp= this.leftNode.val;
                this.leftNode.val=rightNode.val;
                rightNode.val=temp;
                this.leftNode=this.leftNode.next;
            }



        }

       public ListNode reverseBetweenNodeReOrder(ListNode head, int left, int right) {
            ListNode dummy= new ListNode(0,head);
            ListNode before=dummy;
            for(int i=1;i<left;i++){
                before=before.next;
            }
           recursiveReverseReOrder(before,left,right);
            return dummy.next;
    }

    public ListNode recursiveReverseReOrder(ListNode before, int left, int right){
            if(right-left==0){
                return before.next;
            }
            ListNode first,last,revSubListStart,revSubListEnd,after;
             first=before.next;
            if(right-left>1){
                revSubListEnd=recursiveReverseReOrder(first,left+1,right-1);
                revSubListStart=first.next;
                last=revSubListEnd.next;
            }else{
                last=first.next;
                revSubListStart=first;
                revSubListEnd=last;
            }
            after=last.next;
            before.next=last;
            last.next=revSubListStart;
            revSubListEnd.next=first;
            first.next=after;

            return first;
    }

}
