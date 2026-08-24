class Solution {
    public String removeKdigits(String num, int k) {
        String rev;
        Stack<Character>s=new Stack<>();
        for(int i=0;i<num.length();i++){
        while(!s.isEmpty() && k>0 && (s.peek()-'0')>(num.charAt(i)-'0'))
        {
            s.pop();
            k=k-1;
        }s.push(num.charAt(i));
    }
    //edge case1
    while(k>0)
    {
        s.pop();
        k--;
    }//edge cae2
    if(s.isEmpty())
    {
        return "0";
    }//adding the stack elements to a new string
   //using stringbuilder to avoid TLE
   StringBuilder res= new StringBuilder();
   while(!s.isEmpty())
   {
    res.append(s.pop());
   }
   
   //reverse first
     rev = res.reverse().toString();
    //remioving frontal 0s from rev
    int j=0;
   
    while(j<rev.length()&&rev.charAt(j)=='0')
    {
    
    j=j+1;
    }
    rev=rev.substring(j);
  
    if(rev.length()==0)
    {
        return "0";
    }
    return rev;

        }
}