/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> minHeap = new PriorityQueue<ListNode>(new Comparator<ListNode>(){
            public int compare(ListNode i, ListNode j)
            {
                if (i.val < j.val)
                    return -1;
                else if (i.val > j.val)
                    return 1;
                else
                    return 0;
            }
        });
        
        for (ListNode n : lists)
        {
            ListNode current = n;
            while(current != null)
            {
                minHeap.add(current);
                current = current.next;
            }
        }
        
        ListNode output = minHeap.poll();
        
        ListNode current = output;
        
        while(!minHeap.isEmpty())
        {
            current.next = minHeap.poll();
            current = current.next;
        }
        
        if (current != null)
            current.next = null;
        
        return output;
        
    }
}