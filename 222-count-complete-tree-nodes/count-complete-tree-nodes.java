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
   
    public int countNodes(TreeNode root) {
   if(root==null)
   return 0;
   int left=lefttrav(root);
   int right=righttrav(root);
   if(left==right)
   return (int)Math.pow(2,left)-1;
   return 1+countNodes(root.left)+countNodes(root.right);

    }
    public int lefttrav(TreeNode root)
    {
        int height=0;
        if(root==null)
        return 0;
        while(root!=null)
        {
            height++;
            root=root.left;
        }
        return height;
    }
    public int righttrav(TreeNode root)
    {
          int height=0;
        if(root==null)
        return 0;
        while(root!=null)
        {
            height++;
            root=root.right;
        }
        return height;
    }
}