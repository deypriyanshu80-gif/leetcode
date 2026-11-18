class Solution {
    public List<String> maxNumOfSubstrings(String s) {
        int []first=new int[26];
        int []last=new int[26];
        Arrays.fill(first,-1);
        for(int i=0;i<s.length();i++)
        {
            int c=s.charAt(i)-'a';
            if(first[c]==-1)
            {
                first[c]=i;
            }
            last[c]=i;
        }
            
            List<int[]>k=new ArrayList<>();
            for(int a=0;a<26;a++)
            {
                if(first[a]==-1)
                continue;
                boolean valid=true;
                int left=first[a];
                int right=last[a];
                for(int z=left;z<=right;z++)
                {
                    int l=s.charAt(z)-'a';
                    if(first[l]<left)
                    {
                        valid=false;
                        break;
                    }
                    right=Math.max(right,last[l]);
                }
                if(valid)
                k.add(new int[]{left,right});
            }
        
            List<String>ans=new ArrayList<>();
            k.sort((a,b)->(a[1]-b[1]));
            int prev=-1;
            for(int j[]:k)
            {
                if(j[0]>prev)
                {
                    ans.add(s.substring(j[0],j[1]+1));
                    prev=j[1];
                }

            }
        
    return ans;
    }
}