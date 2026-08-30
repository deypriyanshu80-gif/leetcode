class Solution {
    public int lastStoneWeight(int[] stones) {
    PriorityQueue<Integer>max=new PriorityQueue<>(Collections.reverseOrder());
    int n=stones.length;
    
    for(int i=0;i<n;i++)
    {
        max.add(stones[i]);
    }
    int i=0;
    while(max.size()>1)
    {
        
        int first=max.peek();
        max.poll(); 
        int second=max.peek();
        max.poll();
        if(first>second)
        max.add(first-second);
        i++;

    }return max.isEmpty()?0:max.peek();
        
    }
}