class Solution {
    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points,(a,b)->Integer.compare(a[0],b[0]));
       
        int n=points.length;
        int currentEnd=points[0][1];
        int arrows=1;
      for(int i=1;i<n;i++)
      {
        if(points[i][0]<=currentEnd)
        {
            currentEnd=Math.min(currentEnd,points[i][1]);
        }
        else{
            arrows++;
            currentEnd=points[i][1];
        }
      }
        return arrows;
    }
}