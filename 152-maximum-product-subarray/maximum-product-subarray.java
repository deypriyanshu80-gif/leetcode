class Solution {
    public int maxProduct(int[] nums) {
  int currmax=nums[0];
  int currmin=nums[0];
  int ans=nums[0];
  int n=nums.length;
  if(n==1)
  return nums[0];
  for(int i=1;i<n;i++)
  {
    int prevmax=currmax*nums[i];
    int prevmin=currmin*nums[i];
    currmax=Math.max(nums[i],Math.max(prevmax,prevmin));
    currmin=Math.min(nums[i],Math.min(prevmax,prevmin));
    ans=Math.max(ans,currmax);
    
  }      
  
return ans;
    }
}