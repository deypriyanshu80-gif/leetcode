class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>>res=new ArrayList<>();
        helper(1,k,n,0,new ArrayList<>(),res);
        return res;
    }
    public void helper(int index,int k,int sum,int j,ArrayList<Integer>p,List<List<Integer>>res)
    {
      
        if(j==k){
        if(sum==0)
        {
            res.add(new ArrayList<>(p));
             return;
        }
        return;
        }
          if(index>9)
        {
            return;
        }
       
        if(index<10&&j<k)
        {if(index<=sum)
        {
            p.add(index);
            helper(index+1,k,sum-index,j+1,p,res);
            p.remove(p.size()-1);
        }
        }
      
        
         helper(index+1,k,sum,j,p,res);
    }
}