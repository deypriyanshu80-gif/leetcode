class Solution {
    public int minPathSum(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        Integer dp[][]=new Integer[m][n];
        int min=count(0,0,m,n,dp,grid);
        return min;

    }
    int count(int r,int c,int m,int n,Integer[][]dp,int [][]grid)
    {
         if(r<0||r>=m||c<0||c>=n)
        return Integer.MAX_VALUE;
        if(r==m-1&&c==n-1)
        {
            return grid[r][c];
        }
        if(dp[r][c]!=null)
        {
            return dp[r][c];
        }
       
        int down=count(r+1,c,m,n,dp,grid);
        int right=count(r,c+1,m,n,dp,grid);
        dp[r][c]=grid[r][c]+Math.min(down,right);
        return dp[r][c];
    }
}