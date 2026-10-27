class Solution {
    public boolean isBipartite(int[][] graph) {
        int n=graph.length;
        int []col=new int[n];
       
        Queue<Integer>q=new LinkedList<>();
        Arrays.fill(col, -1);
        for(int i=0;i <n;i++)
        {
            if(col[i]!=-1)
            continue;
            col[i]=0;
            q.offer(i);
            while(!q.isEmpty())
            {
                int curr=q.poll();
                for(int neighbour:graph[curr])
                {
                    if(col[neighbour]==-1)
                    {
                        col[neighbour]=1-col[curr];
                        q.offer(neighbour);
                    }
                    else if(col[neighbour]==col[curr])
                    {
                        return false;
                    }
                }
            }
        }
    return true;
    }
}