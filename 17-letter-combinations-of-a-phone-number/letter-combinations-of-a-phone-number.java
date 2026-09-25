class Solution {
    public List<String> letterCombinations(String digits) {
      
        List<String>res=new ArrayList<>();
        HashMap<String,String>map=new HashMap<>();
        map.put("2","abc");
        map.put("3","def");
        map.put("4","ghi");
        map.put("5","jkl");
        map.put("6","mno");
        map.put("7","pqrs");
        map.put("8","tuv");
        map.put("9","wxyz");
          if(digits.length()==0||digits==null)
        return res;
        helper(0,"",digits,map,res);
        return res;
    }
    public void helper(int index,String temp,String digits,HashMap<String,String>map,List<String>res)
    {
        if(index==digits.length())
        {
            res.add(temp);
            return;
        }
        String red=map.get(String.valueOf(digits.charAt(index)));
        for(int i=0;i<red.length();i++)
        {
            helper(index+1,temp+red.charAt(i),digits,map,res);
            
        }
        //helper(index+1,temp+red.charAt(i),digits,map,res)
    }
}