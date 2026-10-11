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
    public int kthSmallest(TreeNode root, int k) {
        PriorityQueue<Integer>max=new PriorityQueue<>(Collections.reverseOrder());
        helper(max,root);
        while(max.size()>k)
        {
            max.poll();
        }
        return max.poll();


    }
    void helper(PriorityQueue<Integer>max,TreeNode root)
    {
        if(root==null)
        {
            return;
        }
        max.add(root.val);
        helper(max,root.left);
        helper(max,root.right);
    }
}