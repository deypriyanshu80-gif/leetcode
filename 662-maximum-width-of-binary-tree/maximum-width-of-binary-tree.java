/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int widthOfBinaryTree(TreeNode root) {
      if(root==null)
      return 0;
      Queue<TreeNode>q1=new LinkedList<>();
      Queue<Integer>q2=new LinkedList<>();
      q1.offer(root);
      q2.offer(0);
      int max=0;
        while(!q1.isEmpty())
        {
            int lastindex=0;
            int firstindex=0;
            int len=q1.size();
            for(int i=0;i<len;i++)
            {
                TreeNode curr=q1.poll();
                int curr2=q2.poll();
                if(i==0)
                {
                    firstindex=curr2;
                }
                if(i==len-1)
                {
                    lastindex=curr2;
                }
                if(curr.left!=null)
                {
                    q1.offer(curr.left);
                    q2.offer(curr2*2+1);
                }
                if(curr.right!=null)
                {
                    q1.offer(curr.right);
                    q2.offer(curr2*2+2);
                }

            }
            max=Math.max(max,lastindex-firstindex+1);
        }
        return max;
    }
}