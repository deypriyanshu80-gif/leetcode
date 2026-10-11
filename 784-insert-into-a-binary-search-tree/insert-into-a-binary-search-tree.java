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
    public TreeNode insertIntoBST(TreeNode root, int val) {
        TreeNode newNode = new TreeNode(val);
        if(root==null)
        {
            root=newNode;
            return root;
        }
        TreeNode curr=root;
        while(curr!=null)
        {
            if(curr.val>val)
            {
                if(curr.left!=null)
                {
                    curr=curr.left;
                }
                else
                {
                curr.left=newNode;
                return root;
                }
            }
            if(curr.val<val)
            {
                if(curr.right!=null)
                {
                    curr=curr.right;
                }
                else
                {
                    curr.right=newNode;
                    return root;
                }
            }
        }
        return root;
    }
}