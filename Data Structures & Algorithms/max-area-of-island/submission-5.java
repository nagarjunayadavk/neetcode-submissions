class Solution {
    // find max area
    private int dfs(int x, int y, int[][] grid, boolean[][] visited) {
        int rows = grid.length;
        int cols = grid[0].length;
        //   if( x < 0 || x >= grid.length||
        //       y < 0 || y >= grid[0].length||
        //       grid[x][y] == 0){
        //         return 0;
        //       }
        //       grid[x][y] =0;

        int area = 1;

        int[] dir = {-1, 0, 1, 0, -1};
        // count the area based on land cell connected to land
        for (int i = 0; i < 4; i++) {
            int newRow = x + dir[i];
            int newCol = y + dir[i + 1];
            if (newRow >= 0 && newRow < rows && newCol >= 0 && newCol < cols
                && grid[newRow][newCol] == 1 && !visited[newRow][newCol]) {
                visited[newRow][newCol] = true;
                area += dfs(newRow, newCol, grid, visited);
            }
        }
        return area;
    }

    public int maxAreaOfIsland(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;

        int maxArea = 0;
        boolean[][] visited = new boolean[rows][cols];

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (grid[row][col] == 1) {
                    visited[row][col] = true;
                    maxArea = Math.max(maxArea, dfs(row, col, grid, visited));
                }
            }
        }
        return maxArea;
    }
}