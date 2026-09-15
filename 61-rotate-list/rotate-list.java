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
    public ListNode rotateRight(ListNode head, int k) {
        if(head==null||head.next==null)
        {
            return head;
        }
        ListNode temp=head;
        ListNode prev=null;
        int n=0;
        while(temp!=null)
        {
            temp=temp.next;
            n++;
        }
        for(int i=1;i<=k%n;i++)
        {
            temp=head;
            prev=null;
            while(temp.next!=null)
            {
                prev=temp;
                temp=temp.next;
            }temp.next=head;
                   
                    prev.next=null;
                    head=temp;
                  
                
            
        }
        return head;
    }
}