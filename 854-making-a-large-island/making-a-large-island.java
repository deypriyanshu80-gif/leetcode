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
    public int largestIsland(int[][] grid) {
        int n=grid.length;
        dsu ds=new dsu(n*n);
        int delr[]={-1,0,1,0};
        int delc[]={0,1,0,-1};
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(grid[i][j]==0)
                continue;
                int one=0;
                for(int k=0;k<4;k++)
                {
                    int row=i+delr[k];
                    int col=j+delc[k];
                    if(row>=0&&row<n&&col>=0&&col<n&&grid[row][col]==1)
                    {
                        int nodeId=i*n+j;
                        int adjId=row*n+col;
                        ds.union(nodeId,adjId);
                
                    }
                }
            }
        }
        int max=Integer.MIN_VALUE;
           for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(grid[i][j]==1)
                continue;
                int sum=1;
                 Set<Integer> s = new HashSet<>();
                for(int k=0;k<4;k++)
                {
                    int row=i+delr[k];
                    int col=j+delc[k];
                    if(row>=0&&row<n&&col>=0&&col<n&&grid[row][col]==1)
                    {
                       
                        int adjId=row*n+col;
                        
                    s.add(ds.findpar(adjId));


                    }
                }
              for(int root:s)
              {
                sum=sum+ds.size[root];
              }
            max=Math.max(max,sum);
            }
        }
        
 int max1=0;
boolean flag=true;
for(int i=0;i<n;i++)
{
    for(int j=0;j<n;j++)
    {
        if(grid[i][j]==0)
        flag=false;
    }
}
if(flag==true)
{
    max1=n*n;
    return max1;
}
else
return max;
    }
}