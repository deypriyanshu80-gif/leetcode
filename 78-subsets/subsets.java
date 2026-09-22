class Solution {
   
    public List<List<Integer>> subsets(int[] nums) {
         List<List<Integer>>res=new ArrayList<>();
        sub(nums,new ArrayList<>(),0,res);
        return res;
        
    }
    private void sub(int []nums, ArrayList<Integer>p,int index,List<List<Integer>>res)
    {
        if(index==nums.length)
        {
            res.add(new ArrayList<>(p));
            return;
        }
        p.add(nums[index]);
        sub(nums,p,index+1,res);
        p.remove(p.size()-1);
        sub(nums,p,index+1,res);
    }
}