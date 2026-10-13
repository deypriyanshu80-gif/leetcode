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
    public boolean findTarget(TreeNode root, int k) {
        ArrayList<Integer>l=new ArrayList<>();
        HashSet<Integer>map=new HashSet<>();
        trav(map,l,root);
        for(int i:l)
        {
            if(map.contains(k-i)&&i!=k-i)
            return true;
        }
        return false;
    }
    void trav(HashSet<Integer>map,ArrayList<Integer>l,TreeNode root)
    {
        if(root==null)
        return;
        trav(map,l,root.left);
        map.add(root.val);
        l.add(root.val);
        trav(map,l,root.right);
    }
}