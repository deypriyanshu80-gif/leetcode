class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result=new ArrayList<>();
        backtrack(result,new ArrayList<>(),candidates,target,0);
        return result;
        
    }
public void backtrack(List<List<Integer>> result,List<Integer> p,int candidates[],int target,int index){
   if(index==candidates.length)
   {
    if(target==0)
    {
        result.add(new ArrayList<>(p));
    }
    
        return;
    
   }
    if(candidates[index]<=target)
    {
        p.add(candidates[index]);
        backtrack(result,p,candidates,target-candidates[index],index);
    
    p.remove(p.size()-1);
    }
    backtrack(result,p,candidates,target,index+1);
   }
}

