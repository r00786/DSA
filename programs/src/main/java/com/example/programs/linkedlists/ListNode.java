package com.example.programs.linkedlists;

 class ListNode {
     int val;
     ListNode next;
     ListNode(int x) {
         val = x;
         next = null;
     }
  @Override
  public String toString() {
   StringBuilder sb = new StringBuilder();
   ListNode current = this;
   while (current != null) {
    sb.append(current.val);
    if (current.next != null) {
     sb.append(" -> ");
    }
    current = current.next;
   }
   return sb.toString();
  }
 }
 