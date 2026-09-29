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
    ArrayList<Integer>x=new ArrayList<>();
    ArrayList<Integer>y=new ArrayList<>();
    public boolean isSameTree(TreeNode p, TreeNode q) {
        return trav(x,p).equals(trav(y,q));
        
    }
    public List<Integer> trav(ArrayList<Integer>p,TreeNode x )
    { 
        if(x==null)
        {
        p.add(null);
        return p;
        }
        p.add(x.val);
        trav(p,x.left);
        trav(p,x.right);
        return p;
    }
}