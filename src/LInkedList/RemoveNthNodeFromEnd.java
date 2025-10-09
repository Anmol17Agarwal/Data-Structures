package LInkedList;

//Leetcode question number 19
public class RemoveNthNodeFromEnd {

    //  Definition for singly-linked list.
      public class ListNode {
          int val;
          ListNode next;
          ListNode() {}
          ListNode(int val) { this.val = val; }
          ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     }
    class Solution {
        public ListNode removeNthFromEnd(ListNode head, int n) {
            int count=0;
            ListNode temp=head;
            ListNode node = head;
            while(node!=null){
                count++;
                node=node.next;
            }
            if(count==n){
                return head.next;
            }
            int stopAt = count - n;
            temp = head;
            for (int i = 1; i < stopAt; i++) {
                temp = temp.next;
            }
            temp.next = temp.next.next;

            return head;
        }
    }
}
