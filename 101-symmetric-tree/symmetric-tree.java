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
    ArrayList<Integer>l=new ArrayList<>();
    ArrayList<Integer>r=new ArrayList<>();
    public boolean isSymmetric(TreeNode root) {
        return lefty(root,l).equals(righty(root,r));
        
    }
    List<Integer> lefty(TreeNode root,ArrayList<Integer>k)
    {
        if(root==null)
     {   k.add(null);
        return k;
    }
        k.add(root.val);
        lefty(root.left,k);
        lefty(root.right,k);
        return k;
    }
     List<Integer> righty(TreeNode root,ArrayList<Integer>k)
    {
        if(root==null)
       { k.add(null);
        return k;
       }
       k.add(root.val);
        righty(root.right,k);
        righty(root.left,k);
        return k;
    }
}