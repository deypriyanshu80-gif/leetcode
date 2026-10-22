class Solution {
    public void dfs(int node,int[][] isConnected,int []vis)
    {
        vis[node]=1;
        for(int j=0;j<isConnected.length;j++)
        {
            if(isConnected[node][j]==1&&vis[j]==0)
            {
                dfs(j,isConnected,vis);
            }
        }
    }
    public int findCircleNum(int[][] isConnected) {
        int V=isConnected.length;
        int []vis=new int[V];
        int c=0;
        for(int i=0;i<V;i++)
        {
            if(vis[i]==0)
            {
                c++;
                dfs(i,isConnected,vis);
            }
        }
        return c;

    }

}