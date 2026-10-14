class Solution {
    public int[] arrayRankTransform(int[] arr) {
      int rank[]=new int[arr.length];
      HashMap<Integer,Integer>map=new HashMap<>();
    int arr1[]=new int[arr.length];
    for(int i=0;i<arr.length;i++)
    {
        arr1[i]=arr[i];
    }
    Arrays.sort(arr1);
    int count =1;
      for(int i=0;i<arr1.length;i++)
      {
        if(map.containsKey(arr1[i]))
        {
            continue;
        }
        else
        map.put(arr1[i],count++);
      }
      for(int i=0;i<arr.length;i++)
      {
        rank[i]=map.get(arr[i]);
      }  
      return rank;
    }
}