package com.example.programs.linkedlists;

import com.example.programs.Utils;

public class ReverseLinkedListEvenLength {
    public static void main(String[] args) {
        System.out.println(new ReverseLinkedListEvenLength().reverseEvenLengthGroups(Utils.convertArrayToLinkedList(new int[]{1,2,3,4,5,6,7,8,9,10})));
    }

    private ListNode reverse(ListNode head, int count) {
        ListNode prev = null;
        ListNode cur = head;
        ListNode next = null;
        while (cur != null && count > 0) {
            next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;

            // EXTRA CASE ADDS UP...
            count--;
        }
        head.next = next;
        return prev;
    }


    public ListNode reverseEvenLengthGroups(ListNode head) {
        // only the swaping is possible
        // BASIC START POINT
        int counter = 2;

        ListNode cur = head.next;
        ListNode prev = head;
        while (cur != null) {
            ListNode l_curr = cur; // copy of the head.next
            ListNode l_prev = prev; // copy of the head
            int count = 1;
            while (cur != null && count <= counter) {
                prev = cur;
                cur = cur.next;
                count++;
            }
            count -= 1;

            // if even number then REVERSE IT...
            // increase the counter...
            if (Math.min(count, counter) % 2 == 0) {
                ListNode newHead = reverse(l_curr, Math.min(count, counter));
                l_prev.next = newHead;
                prev = l_curr;
            }
            counter++;
        }
        return head;
    }
}
