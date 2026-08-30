class Solution {
    public int[][] kClosest(int[][] points, int k) {
        int m=points.length;
    
        PriorityQueue<int[]>max=new PriorityQueue<>((a,b)->(b[0]*b[0]+b[1]*b[1])-(a[0]*a[0]+a[1]*a[1]));
        for(int i=0;i<m;i++)
        {
           max.add(points[i]);
           if(max.size()>k)
           max.poll();
        }
        int nums[][]=new int[max.size()][2];
        int i=0;
        while(max.size()>0)
        {
            nums[i]=max.peek();
            max.poll();
            i++;
        }
        return nums;
        
    }
}