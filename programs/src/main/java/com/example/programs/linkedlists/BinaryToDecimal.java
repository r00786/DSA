package com.example.programs.linkedlists;

/**
 * Given head which is a reference node to a singly-linked list. The value of each node in the linked list is either 0 or 1. The linked list holds the binary representation of a number.
 *
 * Return the decimal value of the number in the linked list.
 *
 * The most significant bit is at the head of the linked list.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: head = [1,0,1]
 * Output: 5
 * Explanation: (101) in base 2 = (5) in base 10
 * Example 2:
 *
 * Input: head = [0]
 * Output: 0
 *
 *
 * Constraints:
 *
 * The Linked List is not empty.
 * Number of nodes will not exceed 30.
 * Each node's value is either 0 or 1.
 *
 */
public class BinaryToDecimal {


    public int getDecimalValue(ListNode head) {
        String binaryNumber="";
        ListNode current=head;
        while(current!=null){
            binaryNumber+=current.val+"";
            current=current.next;
        }


        return convertBinaryToDecimal(binaryNumber);


    }

    public  int convertBinaryToDecimal(String binary) {
        int decimal = 0;
        int power = 1; // 2^0
        for(int i=binary.length()-1;i>=0;i--){
            char bit =binary.charAt(i);
            if(bit=='1'){
                decimal+=power;
            }
            power *= 2;
        }
        return decimal;
    }


}
