class Solution {
    public int numEnclaves(int[][] grid) {
        int count=0;
        int m=grid.length;
        int n=grid[0].length;
        boolean [][]vis=new boolean[m][n];
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(grid[i][j]==1&&!vis[i][j])
                {
                    count +=bfs(i,j,grid,vis);
                }
            }
            
        }
        return count;
    }
    int bfs(int row,int col,int [][]grid,boolean [][]vis)
    {
        int count=1;
        boolean edge=false;
        int m=grid.length;
        int n=grid[0].length;
        Queue<int[]>q=new LinkedList<>();
        q.add(new int[]{row,col});
        vis[row][col]=true;
        int []delR={-1,0,1,0};
        int []delC={0,1,0,-1};
        if(row==0||row==m-1||col==0||col==n-1)
        edge=true;
        while(!q.isEmpty())
        {
            int curr[]=q.poll();
            int xrow=curr[0];
            int xcol=curr[1];
            for(int i=0;i<4;i++)
            {
                int yrow=xrow+delR[i];
                int ycol=xcol+delC[i];
                if(yrow>=0&&yrow<m&&ycol>=0&&ycol<n&&grid[yrow][ycol]==1&&vis[yrow][ycol]==false){
                if(yrow==0||ycol==0||yrow==m-1||ycol==n-1)
            {       
                edge=true;
                
                }
                    count++;
                    q.add(new int[]{yrow,ycol});
                    vis[yrow][ycol]=true;

                
                }
            }
        }
        return edge?0:count;
    }
}