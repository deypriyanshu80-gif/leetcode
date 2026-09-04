class Solution {
    public String longestPalindrome(String s) {
        int start=0;
        int end=0;
        int l,r;
        int max=0;
        for(int i=0;i<s.length();i++)
        {
           l=i;
           r=i;
           while(l>=0&&r<s.length()&&s.charAt(l)==s.charAt(r))
           {
            l--;
            r++;
           }int len1=r-l-1;
           l=i;
           r=i+1;
           while(l>=0&&r<s.length()&&s.charAt(l)==s.charAt(r))
           {
            l--;
            r++;
           }int len2=r-l-1;
           //********* */
           max=Math.max(len1,len2);
           if(max>end-start)
           {
            start=i-(max-1)/2; //vvi
            end=i+max/2;  //vvi
           }
           

        }
        return s.substring(start,end+1);
    }
}