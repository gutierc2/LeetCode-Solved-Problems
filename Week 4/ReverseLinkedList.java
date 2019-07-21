/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode reverseList(ListNode head) {
        
        if (head == null)
            return null;
        
        ListNode n1 = head;
        ListNode n2 = head.next;
        
        while (n2 != null)
        {
            ListNode n3 = n2.next;
            n2.next = n1;
            n1 = n2;
            n2 = n3;
        }
        
        head.next = null;
        
        return n1;
    }
}