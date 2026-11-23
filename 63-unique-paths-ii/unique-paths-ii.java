class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m=obstacleGrid.length;
        int n=obstacleGrid[0].length;
        int dp[][]=new int[m][n];
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                dp[i][j]=-1;
            }
        }
        if(obstacleGrid[0][0]==1)
        return 0; 
        if(obstacleGrid[m-1][n-1]==1)
        return 0;  
        return counter(0,0,m,n,dp,obstacleGrid);
    }
    int counter(int r,int c, int m,int n,int [][]dp,int [][]obstacleGrid)
    {
        if(r==m-1&&c==n-1)
        {
            return 1;
        }
        if(r==m||c==n)
        return 0;
        //obstacle edge case
        if(obstacleGrid[r][c]==1)
        return 0;
        if(dp[r][c]!=-1)
        return dp[r][c];
        int downpath=counter(r+1,c,m,n,dp,obstacleGrid);
        int rightpath=counter(r,c+1,m,n,dp,obstacleGrid);
        return dp[r][c]=downpath+rightpath;
    }
}