class Solution {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        int [][]dist=new int[n][n];
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                dist[i][j]=Integer.MAX_VALUE;
                dist[i][i]=0;
            }
        }
        for(int p[]:edges)
        {
            dist[p[0]][p[1]]=p[2];
            dist[p[1]][p[0]]=p[2];
        }
 
        for(int k=0;k<n;k++)
        {
            for(int i=0;i<n;i++)
            {
                for(int j=0;j<n;j++)
                {
                    if(dist[i][k]!=Integer.MAX_VALUE&&dist[k][j]!=Integer.MAX_VALUE)
                    {
                        dist[i][j]=Math.min(dist[i][j],dist[i][k]+dist[k][j]);
                    }
                }
            }
        }
           int mincity=Integer.MAX_VALUE;
    int city=-1;
  for(int k=0;k<n;k++)
  {
    int count=0;
 
    for(int j=0;j<n;j++)
    {
        if(k!=j&&dist[k][j]<=distanceThreshold)
        {
            count++;
        }
    }
    if(count<=mincity)
    {
        mincity=count;
        city=k;
    }

  }
 return city;   
 }
}