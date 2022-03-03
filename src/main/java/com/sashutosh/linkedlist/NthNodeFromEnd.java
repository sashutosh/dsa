package com.sashutosh.linkedlist;

public class NthNodeFromEnd {
       static class ListNode {
          int val;
          ListNode next;
          ListNode() {}
          ListNode(int val) { this.val = val; }
          ListNode(int val, ListNode next) { this.val = val; this.next = next; }
      }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        NthNodeFromEnd nthNodeFromEnd = new NthNodeFromEnd();
        nthNodeFromEnd.removeNthFromEnd(head,2);
        System.out.println(head.val);
    }

      public ListNode removeNthFromEnd(ListNode head, int n) {
        int size = getSize(head);
        int fromStart= size-n;
        ListNode cur= head;
        if(fromStart==0) {
            head = head.next;
            return head;
        }
        for(int i=0;i<fromStart-1;i++){
            cur = cur.next;
        }
        if(cur.next!=null){
            cur.next = cur.next.next;
        }
        else{
            cur.next=null;
        }
        return head;
    }

    private int getSize(ListNode head) {
        ListNode cur = head;
        int size=0;
        while(cur!=null){
            cur = cur.next;
            size++;
        }
        return size;
    }
}
