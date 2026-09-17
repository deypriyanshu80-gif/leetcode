class Solution {
    public boolean canJump(int[] nums) {
        int l=nums.length;
        int max=0;
        for(int i=0;i<l;i++)
        {
            if(i>max)
            return false;
            max=Math.max(max,nums[i]+i);
        }
        return true;
    }
}