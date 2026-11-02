class Solution {
    public int minimumEffortPath(int[][] heights) {
        PriorityQueue<int[]>min=new PriorityQueue<>((a,b)->Integer.compare(a[0],b[0]));
        int m=heights.length;
        int n=heights[0].length;
        int diff[][]=new int[m][n];
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                diff[i][j]=Integer.MAX_VALUE;
            }
        }
        min.offer(new int[]{0,0,0});
        int []dr={-1,0,1,0};
        int []dc={0,1,0,-1};
        diff[0][0]=0;
        while(!min.isEmpty())
        {
          int curr[]=min.poll();
          int d=curr[0];
          int r=curr[1];
          int c=curr[2];
          if(r==m-1&&c==n-1)
          {
            return d;
       }
          for(int i=0;i<4;i++)
        {
            int x=r+dr[i];
            int y=c+dc[i];
            if(x>=0&&x<m&&y>=0&&y<n)
            {
                if(Math.max(d,Math.abs(heights[r][c]-heights[x][y]))<diff[x][y])
                {
                    diff[x][y]=Math.max(d,Math.abs(heights[r][c]-heights[x][y]));
                    min.offer(new int[]{diff[x][y],x,y});
                }
            }
        }

        }
 return diff[m-1][n-1];
    }
}