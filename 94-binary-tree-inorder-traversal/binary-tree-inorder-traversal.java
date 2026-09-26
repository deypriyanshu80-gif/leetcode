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
    public List<Integer> inorderTraversal(TreeNode root) 
    {
        List<Integer>k=new ArrayList<>();
        trav(root,k);
        return k;
    }
    public void trav(TreeNode root,List<Integer>k)
    {
        if(root==null)
        return;
        trav(root.left,k);
        k.add(root.val);
        trav(root.right,k);
        
    }
        
    

}