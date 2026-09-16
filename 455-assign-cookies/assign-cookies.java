class Solution {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int l=0;
        int r=0;
        int l1=g.length;
        int l2=s.length;
        while(r<l1&&l<l2)
        {
            if(s[l]>=g[r])
            {
                r++;
            }
        l++;
        }
        return r;

    }
}