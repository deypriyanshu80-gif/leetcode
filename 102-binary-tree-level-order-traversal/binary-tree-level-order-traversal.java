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
    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode>q=new LinkedList<TreeNode>();
        List<List<Integer>>k=new ArrayList<>();
        if(root==null)
        return k;
        q.offer(root);
        while(!q.isEmpty())
        {
            int n=q.size();
            ArrayList<Integer>p=new ArrayList<>();
            for(int i=0;i<n;i++)
            {
                if(q.peek().left!=null)
                q.offer(q.peek().left);
                 if(q.peek().right!=null)
                q.offer(q.peek().right);
                p.add(q.poll().val);
            }
            k.add(p);
        }
    return k;       
    }
}