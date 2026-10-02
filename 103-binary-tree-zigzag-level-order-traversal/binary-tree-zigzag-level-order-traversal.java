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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>>x=new ArrayList<>();
        Queue<TreeNode>q=new LinkedList<>();
        if(root==null)
        {
            return x;
        }
        q.offer(root);
        boolean flag=true;
        while(!q.isEmpty())
        {
             int n=q.size();
            Integer y[]=new Integer[n];
           
            
            for(int i=0;i<n;i++)
            {
                TreeNode curr=q.poll();
                int index=flag?i:(n-1-i);
                y[index]=curr.val;
                
                if(curr.left!=null)
                {
                    q.offer(curr.left);

                }
                 if(curr.right!=null)
                {
                    q.offer(curr.right);

                }
            }
            flag=!flag;
           x.add(Arrays.asList(y));
        }
        return x;
    }
}