class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>>res=new ArrayList<>();
        helper(new ArrayList<>(),nums,0,res);
        return res;

    }
    private void helper(ArrayList<Integer>p,int []nums,int index,List<List<Integer>>res)
    {
        if(index==nums.length)
        {
            res.add(new ArrayList<>(p));
            return;
        }
        p.add(nums[index]);
        helper(p,nums,index+1,res);
        p.remove(p.size()-1);
        while(index+1<nums.length&&nums[index]==nums[index+1])
        {
            index++;
        }
        helper(p,nums,index+1,res);
    }
}
