/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root==null)
        return "";
        Queue<TreeNode>q=new LinkedList<>();
        StringBuilder sb=new StringBuilder();
        q.offer(root);
        while(!q.isEmpty())
        {
            TreeNode curr=q.poll();
            if(curr==null)
            {
                sb.append("null ");
                continue;
            }
            sb.append(curr.val+" ");
            q.offer(curr.left);
            q.offer(curr.right);

        }
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data.equals(""))
        return null;
        Queue<TreeNode>q=new LinkedList<>();
        String k[]=data.split(" ");
        TreeNode curr=new TreeNode(Integer.parseInt(k[0]));
        q.offer(curr);
        for(int i=1;i<k.length-1;i++)
        {
            TreeNode parent=q.poll();
            if(!k[i].equals("null"))
            {
                TreeNode left=new TreeNode(Integer.parseInt(k[i]));
                parent.left=left;
                q.offer(left);
            }
             if(!k[++i].equals("null"))
            {
                TreeNode right=new TreeNode(Integer.parseInt(k[i]));
                parent.right=right;
                q.offer(right);
            }
        }
        return curr;

    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));