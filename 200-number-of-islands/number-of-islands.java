class Solution {
    public int numIslands(char[][] grid) {
        if(grid==null||grid.length==0)
            return 0;
        int m=grid.length;
       int n=grid[0].length;
       boolean vis[][]=new boolean[m][n];
       int c=0;
       for(int i=0;i<m;i++)
       {
        for(int j=0;j<n;j++)
        {
            if(!vis[i][j]&&grid[i][j]=='1')
            {
                c++;
                bfs(i,j,grid,vis);
            }
        }
       }
       return c;
        
        
    }
    void bfs(int row,int col,char[][]grid,boolean [][]vis)
    {
        int m=grid.length;
        int n=grid[0].length;
         Queue<int[]>q=new LinkedList<>();
         q.add(new int[]{row,col});
        vis[row][col]=true;
        int []delR={-1,0,1,0};
        int []delC={0,1,0,-1};
        while(!q.isEmpty())
        {
            int []curr=q.poll();
            int xrow=curr[0];
            int xcol=curr[1];
            for(int i=0;i<4;i++)
            {
                int yrow=xrow+delR[i];
                int ycol=xcol+delC[i];
                if(yrow>=0&&yrow<m&&ycol>=0&&ycol<n&&!vis[yrow][ycol]&&grid[yrow][ycol]=='1')
                {
                    vis[yrow][ycol]=true;
                    q.add(new int[]{yrow,ycol});
                }
            }
        }
        
    }
   
}