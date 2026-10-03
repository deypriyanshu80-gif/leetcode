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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer>l=new ArrayList<>();
        if(root==null)
        {
            return l;
        }
        helper(root,l,0);
        return l;
    }
    void helper(TreeNode root,List<Integer>k,int depth)
    {
        if(root==null)
        return;
        if(depth==k.size())
        {
            k.add(root.val);
        }
        helper(root.right,k,depth+1);
        helper(root.left,k,depth+1);

    }
}