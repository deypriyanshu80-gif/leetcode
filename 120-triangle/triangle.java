class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n=triangle.size();
        Integer dp[][]=new Integer[n][n];
        int min=findmin(n,dp,triangle,0,0);
        return min;
    }
    int findmin(int n,Integer[][]dp,List<List<Integer>>triangle,int r,int c)
    {
    if(c>=triangle.get(r).size()||r<0||c<0||r>=n)
    return Integer.MAX_VALUE;
       if(r==n-1)
       {
        return triangle.get(r).get(c);
       } 
    if(dp[r][c]!=null)
    {
        return dp[r][c];
    }
    int next=findmin(n,dp,triangle,r+1,c);
    int next1=findmin(n,dp,triangle,r+1,c+1);
    dp[r][c]=triangle.get(r).get(c)+Math.min(next,next1);
    return dp[r][c];

       
    }
}