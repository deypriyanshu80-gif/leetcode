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
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer>k=new ArrayList<>();
        traverse(root,k);
        return k;
     
    }
    public void traverse(TreeNode root,List<Integer>k)
    {
        if(root==null)
        return;
        k.add(root.val);
        traverse(root.left,k);
        traverse(root.right,k);
    }
}