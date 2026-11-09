class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        int dist[][]=new int[n+1][n+1];
        for(int i=0;i<n+1;i++)
        {
            for(int j=0;j<n+1;j++)
            {
                dist[i][j]=Integer.MAX_VALUE;
            }
        }
        for(int p[]:times)
        {
            dist[p[0]][p[1]]=p[2];
        }
       
        Queue<int[]>q=new LinkedList<>();
        q.offer(new int[]{k,0});
        int count=0;
        int signal[]=new int[n+1];
        
        Arrays.fill(signal,Integer.MAX_VALUE);
        signal[k]=1;
        while(!q.isEmpty())
        {
            int curr[]=q.poll();
            int u=curr[0];
             int t=curr[1];
             
            for(int i=0;i<n+1;i++)
            {
                if(dist[u][i]!=Integer.MAX_VALUE)
                {
                    
                    int t1=t+dist[u][i];
                    if(t1<signal[i])
                    {signal[i]=t1;
                    q.offer(new int[]{i,t1});
                    }
                }
            }
    
        }
        for(int i=1;i<n+1;i++)
        {
            if(signal[i]==Integer.MAX_VALUE)
            return -1;
        }
        int max=0;
        for(int i=1;i<n+1;i++)
        {
            max=Math.max(max,signal[i]);
        }
 return max;      
      }
}