class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int org=image[sr][sc];
        if(org!=color)
        {
            bfs(sr,sc,image,color,org);
        }
        return image;
    }
    void bfs(int row,int col,int [][]image,int color,int org)
    {
        int m=image.length;
         int n=image[0].length;
        Queue<int []>q=new LinkedList<>();
        q.add(new int[]{row,col});
        int []delR={-1,0,1,0};
        int []delC={0,1,0,-1};
        image[row][col]=color;
        while(!q.isEmpty())
        {
            int []curr=q.poll();
            int xrow=curr[0];
            int xcol=curr[1];
            for(int i=0;i<4;i++)
            {
                int yrow=xrow+delR[i];
                int ycol=xcol+delC[i];
                if(yrow>=0&&yrow<m&&ycol>=0&&ycol<n&&image[yrow][ycol]==org)
                {
                    image[yrow][ycol]=color;
                     q.add(new int[]{yrow,ycol});
                }
            }
        }
    }
}