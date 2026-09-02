class Solution {
    public boolean rotateString(String s, String goal) {
        if(s.length()!=goal.length())
        {
            return false;
        }
        for(int i=s.length()-1;i>=0;i--)
        {
           s=s.substring(1)+s.charAt(0);
           if(s.equals(goal))
           {
            return true;
           }
        }
        return false;
    }
}