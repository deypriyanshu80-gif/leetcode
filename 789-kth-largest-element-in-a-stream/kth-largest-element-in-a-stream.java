class KthLargest {
    PriorityQueue<Integer>min=new PriorityQueue<>();
    int k;

    public KthLargest(int k, int[] nums) {
        int n=nums.length;
        this.k=k;
        
        for (int i=0;i<n;i++)
        {
            min.add(nums[i]);
            if(min.size()>k)
            {
                min.poll();
            }
        }
        
    }
    
    public int add(int val) {
        min.add(val);
        if(min.size()>k)
        min.poll();
        return min.peek();
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */