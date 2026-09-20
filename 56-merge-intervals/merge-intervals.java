class Solution {
    public int[][] merge(int[][] intervals) {
        ArrayList<int[]>list=new ArrayList<>();
        Arrays.sort(intervals,(a,b)->Integer.compare(a[0],b[0]));
        int n=intervals.length;
       
       
        
        list.add(intervals[0]);
        for(int i=1;i<n;i++)
        {
        if(intervals[i][0]<=list.get(list.size()-1)[1])
        {
            list.get(list.size()-1)[1]=Math.max(list.get(list.size()-1)[1],intervals[i][1]);
            list.get(list.size()-1)[0]=Math.min(list.get(list.size()-1)[0],intervals[i][0]);
            
        }
        else
        {
        list.add(intervals[i]);
        }
        }
        int arr[][]=new int[list.size()][2];
        for(int i=0;i<arr.length;i++)
        {
            arr[i]=list.get(i);
        }
        return arr;
    }
}