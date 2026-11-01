class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n= grid.length;
        int [][]vis=new int[n][n];
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            vis[i][j]=-1;
        }
        Queue<int[]>q=new LinkedList<>();
        if(grid[0][0]==0)
        q.offer(new int[]{0,0,1});
        else
        return -1;
        vis[0][0]=1;
        int[] dRow = {-1, -1, -1,  0, 0,  1,  1,  1};
        int[] dCol = {-1,  0,  1, -1, 1, -1,  0,  1};
        while(!q.isEmpty())
        {
            int curr[]=q.poll();
            int r=curr[0];
            int c=curr[1];
            int d=curr[2];
            if(r==n-1&&c==n-1)
            return d;
    for(int i=0;i<8;i++)
    {
        int row=r+dRow[i];
        int col=c+dCol[i];
        if(row>=0&&row<n&&col>=0&&col<n&&grid[row][col]==0&&vis[row][col]==-1)
        {
            q.offer(new int[]{row,col,d+1});
            vis[row][col]=1;
        }
    }
        }
return -1;
    }
}