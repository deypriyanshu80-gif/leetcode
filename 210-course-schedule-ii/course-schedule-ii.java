class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int [][]mat=new int[numCourses][numCourses];
        int []ind=new int[numCourses];
        ArrayList<Integer>k=new ArrayList<>();
        for(int []p:prerequisites)
        {
            int src=p[1];
            int dest=p[0];
            if(mat[src][dest]==0)
            {
                mat[src][dest]=1;
                ind[dest]++;
            }
        }
        Queue<Integer>q=new LinkedList<>();
        for(int i=0;i<numCourses;i++)
        {
            if(ind[i]==0)
            q.offer(i);

        }
        while(!q.isEmpty())
        {
            int curr=q.poll();
            k.add(curr);
            for(int i=0;i<numCourses;i++)
            {
                if(mat[curr][i]==1)
                {
                    ind[i]--;
                    if(ind[i]==0)
                    {
                        q.offer(i);
                        
                    }
                }
            }
        }
        if(k.size()!=numCourses)
        return new int[0];
        int x[]=new int[k.size()];
        for(int i=0;i<k.size();i++)
        {
            x[i]=k.get(i);
        }
        return x;
    }
}