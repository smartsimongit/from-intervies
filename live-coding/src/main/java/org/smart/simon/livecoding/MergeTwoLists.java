package org.smart.simon.livecoding;


/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
public class MergeTwoLists {
    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

//    list1 {1,2,4}
//    list2 {1,3,4}
//
//    result - {1,1,2,3,4,4}


    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummyHead = new ListNode(-1);
        ListNode current = dummyHead;
        while (list1 != null && list2 != null) {
            if (list1.val >= list2.val) {
                current.next = list2;
                list2 = list2.next;
            } else {
                current.next = list1;
                list1 = list1.next;
            }
            current = current.next;
        }
        if (list2 != null) {
            current.next = list2;
        }else {
            current.next = list1;
        }
        return dummyHead.next;
    }
}
