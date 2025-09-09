package LInkedList;

//LEETCODE QUESTION NO 83
public class RemoveDuplicateFromSortedLL {

      public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
      }


    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode copy = head;

        while (head.next != null) {
            ListNode headNext = head.next;
            if (head.val == headNext.val) {
                head.next = headNext.next;
                headNext.next = null;
            } else {
                head = head.next;
                headNext = headNext.next;
            }
        }
        return copy;
    }
}
