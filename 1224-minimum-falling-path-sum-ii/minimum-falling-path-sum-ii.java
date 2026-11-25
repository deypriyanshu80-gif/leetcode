class Solution {
    public int minFallingPathSum(int[][] grid) {
        int n=grid.length;
        Integer dp[][]=new Integer[n][n];
        int min=Integer.MAX_VALUE;
        for(int i=0;i<n;i++)
        {
            min=Math.min(min,mindp(grid,dp,0,i,n));
        }
        return min;
    }
    int mindp(int [][]grid,Integer[][]dp, int r,int c,int n)
    {
        if(r==n-1)
        {
            return grid[r][c];

        }
        if(dp[r][c]!=null)
        return dp[r][c];
        int mini=Integer.MAX_VALUE;
        for(int c1=0;c1<n;c1++)
        {if(c1!=c)
            mini=Math.min(mini,mindp(grid,dp,r+1,c1,n));
        }
        dp[r][c]=grid[r][c]+mini;
        return dp[r][c];
    }
}