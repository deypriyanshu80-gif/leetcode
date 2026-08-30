class Solution {
    public int halveArray(int[] nums) {
        int n=nums.length;
        PriorityQueue<Double>max=new PriorityQueue<>(Collections.reverseOrder());
        double sum=0;
        double half;
        for(int i=0;i<n;i++)
        {
            sum+=nums[i];
             max.add((double)nums[i]);
        }
        half=sum/2;
        double curr=0;
        int op=0;
        while(curr<half)
        {
            double x=max.peek();
            max.poll();
            curr+=x/2.0;
            op++;
            max.add(x/2.0);
        }
        return op;

        
    }
}