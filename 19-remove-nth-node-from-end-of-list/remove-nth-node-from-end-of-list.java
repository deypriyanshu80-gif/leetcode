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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head==null||head.next==null)
        return null;
        ListNode temp=head;
        int size=0;
        while(temp!=null)
        {
            size++;
            temp=temp.next;
        }
        int f=size-n+1;
        if(f==1)
        {
            return head.next;
        }
        temp=head;
        int i=0;
        while(temp!=null&&temp.next!=null)
        {
            i++;
          
            if(i==f-1)
            temp.next=temp.next.next;
              temp=temp.next;
        }
        return head;
    }
}