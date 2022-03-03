package com.sashutosh;

public class MergeLinkedList {

    public static void main(String[] args) {
        LinkedList headOne = new LinkedList(1);
        headOne.next = new LinkedList(1);
        headOne.next.next = new LinkedList(1);
        headOne.next.next.next = new LinkedList(3);
        headOne.next.next.next.next = new LinkedList(3);


        LinkedList headTwo = new LinkedList(1);
        headTwo.next = new LinkedList(2);
        headTwo.next.next = new LinkedList(2);
        headTwo.next.next.next = new LinkedList(5);
        headTwo.next.next.next.next = new LinkedList(6);
        headTwo.next.next.next.next.next = new LinkedList(10);
        headOne = mergeLinkedLists(headOne, headTwo);
        traverse(headOne);
    }

    public static void traverse(LinkedList head) {
        LinkedList current = head;
        while (current != null) {
            System.out.println(current.value);
            current = current.next;
        }
    }

    public static LinkedList mergeLinkedLists(LinkedList headOne, LinkedList headTwo) {
        // Write your code here.
        LinkedList current = headOne;
        LinkedList prev = null;
        LinkedList toInsert = headTwo;
        if (current != null && toInsert.value < current.value) {
            headTwo = toInsert.next;
            toInsert.next = current;
            headOne = toInsert;
            current = headOne;
            toInsert = headTwo;
        }
        while (toInsert != null) {

           /* if(toInsert==null){
                break;
            }*/
            while (current != null && toInsert.value >= current.value) {
                prev = current;
                current = current.next;
            }
            //if(toInsert.value < current.value)
            {
                if (toInsert == headTwo)
                    headTwo = toInsert.next;
                if (prev != null)
                    prev.next = toInsert;
                prev = toInsert;
                toInsert.next = current;
                toInsert = headTwo;
            }

        }

        return headOne;
    }

    public static class LinkedList {
        int value;
        LinkedList next;

        LinkedList(int value) {
            this.value = value;
            this.next = null;
        }
    }
}
