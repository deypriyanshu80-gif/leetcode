/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode deleteMiddle(ListNode head) {
        if(head==null||head.next==null)
        return null;
        ListNode temp=head;
        int n=0;
        while(temp!=null)
        {
            n++;
            
            temp=temp.next;
        }
        int middle=(n/2)+1;
        temp=head;
        int count=0;
        while(temp!=null&&temp.next!=null)
        {
            count++;
            if(count==n/2)
            {
                temp.next=temp.next.next;
                break;
            }
            temp=temp.next;
        }
        return head;

        
    }
}