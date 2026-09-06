class Solution {
    public String reverseWords(String s) {
        String k="";
        int l;
        int r=s.length()-1;
        StringBuilder sb = new StringBuilder();
       while(r>=0)
        {
           
            
           while(r>=0&&s.charAt(r)==' ')
          {  
        
            r--;
          }
        if(r<0)
        break;
        l=r;
        while(r>=0&&s.charAt(r)!=' ')
        {
            r--;
        }
        k=s.substring(r+1,l+1);
        sb.append(k).append(" ");
        }
        return sb.toString().trim();
    }
}