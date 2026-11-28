class Solution {
    public int islandPerimeter(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        int peri=0;
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(grid[i][j]==0)
                continue;
                else {
                    int delR[]={-1,0,1,0};
                    int delC[]={0,1,0,-1};
                    for(int k=0;k<4;k++)
                    {
                        int nr=i+delR[k];
                        int nc=j+delC[k];
                        if((!(nr<m&&nc<n&&nr>=0&&nc>=0))||(grid[nr][nc]==0))
                        peri++;
                        
                          else 
                            {
                                continue;
                            }
                        } 
                    }

                }
            }
            return peri;
        }
    }
