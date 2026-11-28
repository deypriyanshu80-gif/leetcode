class Solution {
    public int longestIncreasingPath(int[][] matrix) {
        int m=matrix.length;
        int n=matrix[0].length;
        Integer dp[][]=new Integer[m][n];
        int max=Integer.MIN_VALUE;
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                max=Math.max(max,count(matrix,dp,m,n,i,j));
            }
        }
return max;
    }
    int count(int [][]matrix,Integer [][]dp,int m,int n,int r,int c)
    {int s=0;
        if(r>=m||c>=n||r<0||c<0)
        return 0;
        if(dp[r][c]!=null)
        {
            return dp[r][c];
        }
        int nextR[]={-1,0,1,0};
        int nextC[]={0,1,0,-1};
        for(int i=0;i<4;i++)
        {
            int nr=r+nextR[i];
            int nc=c+nextC[i];
            if(nr<m&&nc<n&&nr>=0&&nc>=0)
            if(matrix[nr][nc]>matrix[r][c])
           s= Math.max(s,count(matrix,dp,m,n,nr,nc));
        }
        dp[r][c]=1+s;  
        return dp[r][c];     
    }
}