/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode oddEvenList(ListNode head) {
        if (head == null)
            return null;
        
        ListNode oddHead = head;
        ListNode evenHead = head.next;
        
        ListNode n1 = head;
        ListNode n2 = head.next;
        
        for (int i = 1; n2 != null; i++)
        {
            if (i % 2 == 0)
            {
                n2.next = n1.next;
                n2 = n1.next;
            }
            else
            {
                n1.next = n2.next;
                
                if (n2.next != null)
                    n1 = n2.next;
                else
                    n2 = null;
                    
            }
        }
        
        n1.next = evenHead;
        
        
        return oddHead;
    }
}