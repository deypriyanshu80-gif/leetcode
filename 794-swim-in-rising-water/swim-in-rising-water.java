class Solution {
    public int swimInWater(int[][] grid) {
        int n=grid.length;
        boolean vis[][]=new boolean[n][n];
        vis[0][0]=true;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[2] - b[2]);
        pq.offer(new int[]{0,0,grid[0][0]});
        int[] delr = {-1, 1, 0, 0};
        int[] delc = {0, 0, -1, 1};
        while(!pq.isEmpty())
        {
            int curr[]=pq.poll();
            int r=curr[0];
            int c=curr[1];
            int t=curr[2];
            if(r==n-1&&c==n-1)
            {
                return t;
            }
            for(int i=0;i<4;i++)
            {
                int row=r+delr[i];
                int col=c+delc[i];
                if(row>=0&&row<n&&col>=0&&col<n&&!vis[row][col])
                {
                    vis[row][col]=true;
                    pq.offer(new int[]{row,col,Math.max(t,grid[row][col])});
                }
            }
        }
return -1;
    }
}