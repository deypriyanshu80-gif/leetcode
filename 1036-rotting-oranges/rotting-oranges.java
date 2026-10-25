class Solution {
    public int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        Queue<int[]> q = new LinkedList<>();
        int fresh = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 2) {
                    q.add(new int[]{i, j});
                } else if (grid[i][j] == 1) {
                    fresh++;
                }
            }
        }

      
        if (fresh == 0) return 0;

        int minutes = 0;
        int[] delR = {-1, 0, 1, 0};
        int[] delC = {0, 1, 0, -1};

        
        while (!q.isEmpty() && fresh > 0) {
            int size = q.size(); 
            
            for (int i = 0; i < size; i++) {
                int[] curr = q.poll();
                int xrow = curr[0];
                int xcol = curr[1];
                for (int d = 0; d < 4; d++) {
                    int yrow = xrow + delR[d];
                    int ycol = xcol + delC[d];
                    if (yrow >= 0 && yrow < m && ycol >= 0 && ycol < n && grid[yrow][ycol] == 1) {
                        grid[yrow][ycol] = 2;
                        q.add(new int[]{yrow, ycol});
                        fresh--;
                    }
                }
            }
            minutes++;
        }

       
        return fresh == 0 ? minutes : -1;
    }
}