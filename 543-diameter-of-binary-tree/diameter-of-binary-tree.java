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
   
    int max;
    

    public int diameterOfBinaryTree(TreeNode root) {
        int count=trav(root,0);
        return max;
    }
    public int trav(TreeNode root, int c)
    {
    if(root==null)
        return 0;
    
    int l=trav(root.left,c+1);
    int r=trav(root.right,c+1);
    if((l+r)>max)
        max=l+r;
         
    return Math.max(l,r)+1;
    }
}