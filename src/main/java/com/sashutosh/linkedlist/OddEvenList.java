package com.sashutosh.linkedlist;

public class OddEvenList {

     public static class ListNode {
          int val;
          ListNode next;
          ListNode() {}
          ListNode(int val) { this.val = val; }
          ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);

        ListNode two = new ListNode(2);
        head.next=two;
        ListNode three = new ListNode(3);
        two.next=three;
        ListNode four = new ListNode(4);
        three.next=four;
        four.next=null;
        /*ListNode five = new ListNode(5);
        four.next=five;
        five.next=null;*/
        //print(head);
        oddEvenList(head);
        //print(head);

    }
    public static void print(ListNode head){
         ListNode cur=head;
         while(cur!=null){

             System.out.println(cur.val);
             cur=cur.next;
         }
    }
    public static ListNode oddEvenList(ListNode head) {
        ListNode tail = head;
        int len=0;
        while(tail.next!=null){
            tail = tail.next;
            len=len+1;
        }
        if(len%2==0){
            len++;
        }
        ListNode cur=head;
        int oper=0;
        while(oper<=len/2){
            ListNode nextNode = cur.next;
            cur.next=nextNode.next;
            tail.next=nextNode;
            nextNode.next=null;
            tail=tail.next;
            cur= cur.next;
            oper++;
            System.out.println("------");
            print(head);
        }

        return head;

    }
}
