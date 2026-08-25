class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer>dq=new ArrayDeque<>();
        ArrayList<Integer>a=new ArrayList<>();
        for(int i=0;i<nums.length;i++)
        {
        while(!dq.isEmpty()&&dq.peekFirst()<=i-k)
        {
            dq.pollFirst();
        }
        while(!dq.isEmpty()&&nums[i]>=nums[dq.peekLast()])
        {
            dq.pollLast();
        }
        dq.offerLast(i);
        if (i >= k - 1) {
            a.add(nums[dq.peekFirst()]);
        }
        }
        int []result=new int[a.size()];
        for(int i=0;i<result.length;i++)
        {
            result[i]=a.get(i);
        }
      
    return result;
    }

}