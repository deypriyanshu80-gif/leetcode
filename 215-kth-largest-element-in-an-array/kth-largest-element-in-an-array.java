class Solution {
    public int findKthLargest(int[] nums, int k) {
        int n=nums.length;
        PriorityQueue<Integer>min=new PriorityQueue<>();
        for(int i=0;i<n;i++)
        {
            min.add(nums[i]);
            if(min.size()>k)
            {
                min.poll();
            }
        }
        return min.peek();
    }
}