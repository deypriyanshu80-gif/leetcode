class Solution {
    public void solve(char[][] board) {
        int m=board.length;
        int n=board[0].length;
        boolean vis[][]=new boolean[m][n];
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(board[i][j]=='O'&&!vis[i][j])
                {
                    bfs(i,j,board,vis);
                }
            }
        }
    }
    void bfs(int r, int c,char [][]board, boolean [][]vis)
    {
         int m=board.length;
        int n=board[0].length;
        ArrayList<int[]>k=new ArrayList<>();
        Queue<int[]>q=new LinkedList<>();
        q.add(new int[]{r,c});
       
        
        boolean edge=false;
        vis[r][c]=true;
        int []delr={-1,0,1,0};
        int []delc={0,1,0,-1};
        while(!q.isEmpty())
        {
            int curr[]=q.poll();
            int xr=curr[0];
            int xc=curr[1];
            k.add(new int[]{xr,xc});
             if(xr==0||xc==0||xr==m-1||xc==n-1)
                 edge=true;
            for(int i=0;i<4;i++)
            {
                int yr=xr+delr[i];
                int yc=xc+delc[i];
                
                if(yr>=0&&yr<m&&yc>=0&&yc<n&&!vis[yr][yc]&&board[yr][yc]=='O')
                {
                   
                    
                         q.add(new int[]{yr,yc});
                         vis[yr][yc]=true;
                        
                    
                }
            }
        }
        if(!edge)
        {
            for(int i=0;i<k.size();i++)
            {
                int x=k.get(i)[0];
                int y=k.get(i)[1];
                board[x][y]='X';
            }
        }
    }
}