/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        HashMap<TreeNode,TreeNode>parent_track=new HashMap<>();
        parentsearcher(root,parent_track,target);
        Queue<TreeNode>q=new LinkedList<>();
        HashMap<TreeNode,Boolean>vis=new HashMap<>();
        q.offer(target);
        vis.put(target,true);
        int lvl=0;
        while(!q.isEmpty())
        {
            if(lvl==k)
            {
                break;
            }
            
            int len=q.size();
            lvl++;
            for(int i=0;i<len;i++)
            {
                TreeNode curr=q.poll();
                if(curr.left!=null&&vis.get(curr.left)==null)
                {
                    q.offer(curr.left);
                    vis.put(curr.left,true);
                }
                  if(curr.right!=null&&vis.get(curr.right)==null)
                {
                    q.offer(curr.right);
                    vis.put(curr.right,true);
                }
                if(parent_track.get(curr)!=null&&vis.get(parent_track.get(curr))==null)
                {q.offer(parent_track.get(curr));
                vis.put(parent_track.get(curr),true);
                }
            }

        }int size=q.size();
        ArrayList <Integer>res=new ArrayList<>();
        for(int i=0;i<size;i++)
        {
            TreeNode current=q.poll();
            res.add(current.val);
        }

        return res;
    }
    void parentsearcher(TreeNode root,HashMap<TreeNode,TreeNode>parent_track,TreeNode target)
    {
        Queue<TreeNode>q=new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty())
        {
            TreeNode curr=q.poll();
            if(curr.left!=null){
                q.offer(curr.left);
                parent_track.put(curr.left,curr);
            }
             if(curr.right!=null){
                q.offer(curr.right);
                parent_track.put(curr.right,curr);
            }

        }
    }
}