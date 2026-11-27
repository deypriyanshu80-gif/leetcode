class Solution {
    public int countSquares(int[][] matrix) {
        int m=matrix.length;
        int n=matrix[0].length;
        Integer dp[][]=new Integer[m][n];
        int sum=0;
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                helper(matrix,dp,m,n,i,j);
            }
        }
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(dp[i][j]!=null)
                sum+=dp[i][j];
            }
        }
        return sum;
    }
    int helper(int [][]matrix,Integer[][] dp,int m,int n,int r,int c)
    {
         if(r>=m||c>=n)
        return 0;
        if(matrix[r][c]!=1)
        return 0;
       
        if(dp[r][c]!=null)
        return dp[r][c];
    
        int down=helper(matrix,dp,m,n,r+1,c);
        int right=helper(matrix,dp,m,n,r,c+1);
        int diag=helper(matrix,dp,m,n,r+1,c+1);
        dp[r][c]=1+Math.min(down,Math.min(right,diag));
        return dp[r][c];
    }
}