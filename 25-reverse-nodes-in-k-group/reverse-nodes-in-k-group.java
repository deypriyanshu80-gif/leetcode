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
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode temp=head;
        int c=0;
        int n=0;
        Stack<ListNode>s=new Stack<>();
        ListNode curr=new ListNode(-1);
        while(temp!=null)
        {
            temp=temp.next;
            n++;
        }
        ListNode j=curr;
        temp=head;
        int i;
        while((n-c)>=k)
        {
             i=0;
            while(i<k)
            {
                
                s.push(temp);
                temp=temp.next;
                i++;
               
            }
            i=0;
    while(i<k)
    {
       j.next=s.pop();
       j=j.next;
       i++;
    }
    c+=k;
        
        }if((n-c)<k){
            j.next=temp;
           
        }
        return curr.next;

    }
}