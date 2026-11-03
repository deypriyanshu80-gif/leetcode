class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
         
        int mat[][]=new int[n][n];
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                mat[i][j]=Integer.MAX_VALUE;
            }
        }
        for(int []x:flights)
        {
            int u=x[0];
            int v=x[1];
            int y=x[2];
            mat[u][v]=y;
        }
        for(int i=0;i<n;i++)
        {
            mat[i][i]=0;
        }
    Queue<int[]>q=new LinkedList<>();
    int price=0;
    int c=0;
    q.offer(new int[]{src,price,c});
    int sum=Integer.MAX_VALUE;
    int []min=new int[n];
    
    Arrays.fill(min,Integer.MAX_VALUE);
    min[src]=0;
    while(!q.isEmpty())    
    {
        int curr[]=q.poll();
        int row=curr[0];
        int p=curr[1];
         c=curr[2];
        if(row==dst)
        {
            sum=Math.min(sum,p);
            continue;
        }
      
        if(row<n&&c<=k)
        {
            for(int i=0;i<n;i++)
            {
                if(mat[row][i]>0&&mat[row][i]!=Integer.MAX_VALUE)
                { 
                    int ncost=p+mat[row][i];
                    if(min[i]>ncost)
                    {
                        min[i]=ncost;
                        q.offer(new int[]{i,ncost,c+1});
                    }
                }
            }
        }
    
    }
    if(sum==Integer.MAX_VALUE)
    return -1;
    
        return sum;
    }
}