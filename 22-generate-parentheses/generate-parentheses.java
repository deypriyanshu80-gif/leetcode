class Solution {
    public List<String> generateParenthesis(int n) {
        ArrayList<String>list=new ArrayList<>();
        helper("",0,0,n,list);
        return list;

    }
    private void helper(String k,int open,int close,int n,ArrayList list)
    {
        if(open==n&&close==n)
        list.add(k);
        if(open<n)
        {
            helper(k+"(",open+1,close,n,list);
        }
        if(close<n&&close<open)
        {
            helper(k+")",open,close+1,n,list);
        }
    }
}