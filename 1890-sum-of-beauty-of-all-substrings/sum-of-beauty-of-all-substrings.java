class Solution {
    public int beautySum(String s) {
        int i=0;
        
        int sub=0;
        while(i<s.length()-1)
        {
          
            int arr[]=new int[26];
            for(int j=i;j<s.length();j++)
            {
                  int max=0;
                    int min=Integer.MAX_VALUE;
                arr[s.charAt(j)-'a']+=1;
                for(int k=0;k<arr.length;k++)
                {
                    if(arr[k]>max)
                    max=arr[k];
                     if(arr[k]>0&&arr[k]<min)
                    min=arr[k];
                   
                }
                 sub+=(max-min);
            }
            i++;
        }return sub;
    }
}