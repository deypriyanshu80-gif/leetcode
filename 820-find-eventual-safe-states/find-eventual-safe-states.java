class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        
       
        int n=graph.length;
       List<List<Integer>>rev=new ArrayList<>();
       List<Integer>k=new ArrayList<>();
       Queue<Integer>q=new LinkedList<>();
       for(int i=0;i<n;i++)
       {rev.add(new ArrayList<>());
       }
       int []outd=new int[n];
       for(int j=0;j<n;j++)
       {
        outd[j]=graph[j].length;
        for(int v:graph[j])
        {
            rev.get(v).add(j);
        }
       }
       for(int i=0;i<n;i++)
       {
        if(outd[i]==0)
        {
            q.add(i);
        }
       }
       if(q.isEmpty())
       return k;
       while(!q.isEmpty())
       {
        int curr=q.poll();
        k.add(curr);
        for(int x:rev.get(curr))
        {
            outd[x]--;
            if(outd[x]==0)
            {
                q.offer(x);
            }
        }
       }
       Collections.sort(k);
       return k;

      
    }
}