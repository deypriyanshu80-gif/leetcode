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
    public int makeConnected(int n, int[][] connections) {
        dsu d=new dsu(n);
        int extra=0;
        for(int edge[]:connections)
        {
            int u=edge[0];
            int v=edge[1];
            if(d.findpar(u)==d.findpar(v))
            {
                extra++;
            }
            else
            {
                d.union(u,v);
            }
        }
        int components=0;
        for(int i=0;i<n;i++)
        {
            if(d.parent[i]==i)
            components++;
        }
        int ans=components-1;
        if(extra>=ans)
        {
            return ans;
        }
        return -1;
    }
}