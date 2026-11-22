class Solution {
    public int findLengthOfLCIS(int[] nums) {
        int n=nums.length;
        int k=1;
        int max=1;
        for(int i=0;i<n-1;i++)
        {
            if(nums[i+1]<=nums[i])
                {k=1;
                continue;
                }
            k++;
            max=Math.max(max,k);

        }
        return max;
    }
}