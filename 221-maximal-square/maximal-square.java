class Solution {
    public int maximalSquare(char[][] matrix) {
        int m=matrix.length;
        int n=matrix[0].length;
        Integer dp[][]=new Integer[m][n];
        int max=Integer.MIN_VALUE;
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                max=Math.max(max,area(matrix,dp,i,j,m,n));
            }
        }
        return max*max;
    }
    int area(char[][]matrix,Integer[][]dp,int r,int c,int m,int n)
    {
        if(r>=m||c>=n||r<0||c<0)
        return 0;
        if(matrix[r][c]=='0')
        return 0;
        if(dp[r][c]!=null)
        return dp[r][c];
        int right=area(matrix,dp,r,c+1,m,n);
        int down=area(matrix,dp,r+1,c,m,n);
        int diag=area(matrix,dp,r+1,c+1,m,n);
        dp[r][c]=1+Math.min(right,Math.min(down,diag));//1 is the element itself
        return dp[r][c];
    }
}