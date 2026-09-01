class Solution {
    public int leastInterval(char[] tasks, int n) {
       HashMap<Character,Integer>map=new HashMap<>();
       PriorityQueue<Integer>max=new PriorityQueue<>(Collections.reverseOrder());
      
       int count=0;
       int k=tasks.length;
       for(int i=0;i<k;i++)
       {
        map.put(tasks[i],map.getOrDefault(tasks[i],0)+1);
       } 
       max.addAll(map.values());
        while(max.size()>0)
       
        { 
             ArrayList<Integer>list=new ArrayList<>();
             int j=0;
        int taskpull=0;
        while(j!=n+1)
        {if(max.size()>0)
        {
          int curr=max.poll();
          curr--;
          if(curr>0)
          {
            list.add(curr);
          }
          taskpull++;
        }
        j++;

        }
        max.addAll(list);
        if(max.size()==0)
        {
            count+=taskpull;
        }
        else{
            count+=n+1;
        }
       

    }
     return count;
}
}