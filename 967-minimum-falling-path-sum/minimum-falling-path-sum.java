class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int n=matrix.length;
        Integer dp[][]=new Integer[n][n];
     
        int min=Integer.MAX_VALUE;
    for(int i=0;i<n;i++)
    {
         min=Math.min(min,mindp(n,dp,matrix,0,i));
    }
    return min;
    }
    int mindp (int n,Integer [][]dp,int [][]matrix,int r ,int c)
    {
         if(c>=n||c<0)
        return Integer.MAX_VALUE;
        if(r==n-1)
        {
             return matrix[r][c];
        }
        if(dp[r][c]!=null)  //declare dp as Integer
        {   
            return dp[r][c];
        }
       
        int down=mindp(n,dp,matrix,r+1,c);
        
        int ldiag=mindp(n,dp,matrix,r+1,c-1);
        int rdiag=mindp(n,dp,matrix,r+1,c+1);
        dp[r][c]=matrix[r][c]+Math.min(down,Math.min(ldiag,rdiag));
        
        return dp[r][c];

    }
}