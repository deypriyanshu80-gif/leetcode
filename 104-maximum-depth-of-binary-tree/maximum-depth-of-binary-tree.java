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
    int count=0;
    public int maxDepth(TreeNode root) {
        
        if(root==null)
        return 0;
        nodecounter(root,1);
        return count;
    }
    public void nodecounter(TreeNode root,int c)
    {
        if(root==null)
        return;
        count=Math.max(count,c);
        nodecounter(root.left,c+1);
        nodecounter(root.right,c+1);
    }
}