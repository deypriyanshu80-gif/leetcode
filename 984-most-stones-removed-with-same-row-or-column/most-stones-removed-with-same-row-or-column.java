class dsu
{
int parent[];
int size[];
public dsu(int n)
{
    parent=new int[n];
    size=new int[n];
    for(int i=0;i<n;i++)
    {
        parent[i]=i;
        size[i]=1;


    }
}
    public int findpar(int x)
    {
        if(x==parent[x])
        return x;
        return parent[x]=findpar(parent[x]);
    }
    public void union(int u,int v)
    {
        int rootx=findpar(u);
        int rooty=findpar(v);
        if(rootx==rooty)
        return;
        if(size[rootx]<size[rooty])
        {
            parent[rootx]=rooty;
            size[rooty]+=size[rootx];
        }
        else{
            parent[rooty]=rootx;
            size[rootx]+=size[rooty];
        }

    }


}
class Solution {
    public int removeStones(int[][] stones) {
        int n=stones.length;
        dsu ds=new dsu(n);
        int count=0;
        for(int i=0;i<n;i++)
        {
            for(int j=i+1;j<n;j++)
            {
                if(stones[i][0]==stones[j][0]||stones[i][1]==stones[j][1])
                {
                    ds.union(i,j);
                }
            }
        }
        for(int i=0;i<n;i++)
        {
            if(ds.findpar(i)!=i)
            count++;
        }
    return count;
    }
}