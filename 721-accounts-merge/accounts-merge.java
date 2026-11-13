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

    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        int k=accounts.size();
        dsu ds=new dsu(k);
 HashMap<String,Integer>map=new HashMap<>();
 for(int i=0;i<k;i++)
 {
    for(int j=1;j<accounts.get(i).size();j++)
    {
        if(map.containsKey(accounts.get(i).get(j)))
        {
           ds.union(i,map.get(accounts.get(i).get(j)));
        
           
        }
        else
        {
            map.put(accounts.get(i).get(j),i);
        }
    }


 } 
 ArrayList<ArrayList<String>>x=new ArrayList<>();
 for(int i=0;i<k;i++)
 {
    x.add(new ArrayList<>());

 }
for(String s:map.keySet())
{
    int root=ds.findpar(map.get(s));
    x.get(root).add(s);
} 
List<List<String>>ans=new ArrayList<>();
for(int i=0;i<k;i++)
{
    if(x.get(i).isEmpty())
    continue;
    Collections.sort(x.get(i));
    ArrayList<String>temp=new ArrayList<>();
    temp.add(accounts.get(i).get(0));
    temp.addAll(x.get(i));
    ans.add(temp);
}
return ans;
    }
} 