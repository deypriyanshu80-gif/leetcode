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
    public ListNode sortList(ListNode head) {
       if(head==null||head.next==null)
       return head;
       ListNode mid=getMid(head);
       ListNode left=head;
       ListNode right=mid;
       left=sortList(head);
       right=sortList(right);
       return merge(left,right);
    }
    private ListNode getMid(ListNode head)
    {
        ListNode temp=head;
        int n=0;
        while(temp!=null)
        {
            n++;
            temp=temp.next;
        }
        int mid=n/2+1;
        temp=head;
        ListNode prev=null;
        int i=0;
        while(temp!=null)
        {
            i++;
            if(i==mid)
            break;
            else
            {
                prev=temp;
                temp=temp.next;
            }
        }
        if(prev!=null)
        {
            prev.next=null;
        }
        return temp;
    }
    private ListNode merge(ListNode l1,ListNode l2)
    {
        ListNode dummy=new ListNode(0);
        ListNode curr=dummy;
        while(l1!=null&&l2!=null)
        {
            if(l1.val<l2.val)
            {
                curr.next=l1;
                l1=l1.next;
            }
            else{
                curr.next=l2;
                l2=l2.next;
            }
            curr=curr.next;
        }
        if(l1!=null)
        curr.next=l1;
        if(l2!=null)
        curr.next=l2;
        return dummy.next;
    }
}