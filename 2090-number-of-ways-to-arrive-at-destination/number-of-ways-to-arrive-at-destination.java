class Solution {
    public int countPaths(int n, int[][] roads) {
     int mat[][]=new int[n][n];
   
     for(int i=0;i<n;i++)
     {
        for(int j=0;j<n;j++)
        {
            mat[i][j]=-1;
        }
     }
       for(int p[]:roads)
     {
        int i=p[0];
        int j=p[1];
        int z=p[2];
        mat[i][j]=z;
        mat[j][i]=z;

     }   
     PriorityQueue<long[]>min=new PriorityQueue<>((a,b)->Long.compare(a[0],b[0]));
     int []ways=new int[n];
     long []dist=new long[n];
     Arrays.fill(ways,0);
     Arrays.fill(dist,Long.MAX_VALUE);
     ways[0]=1;
     dist[0]=0;
     int MOD = 1_000_000_007;
     min.offer(new long[]{dist[0],0});
     while(!min.isEmpty())
     {
        long p[]=min.poll();
        long d=p[0];
        int u=(int)p[1];
        if(d>dist[u])
        continue;
        for(int v=0;v<n;v++)
        {
            if(mat[u][v]!=-1)
            {
                int weight=mat[u][v];
                if(dist[u]+weight<dist[v])
               { dist[v]=dist[u]+weight;
                min.offer(new long[]{dist[v],v});
                ways[v]=ways[u];
            }
            else if(dist[u]+weight==dist[v])
            {
                ways[v]=(ways[u]+ways[v])%MOD;
            }
            }
        }
     }

return ways[n-1];
    }
}