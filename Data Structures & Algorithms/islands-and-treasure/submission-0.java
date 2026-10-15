// class Solution {
//     public void islandsAndTreasure(int[][] grid) {
//         if (grid == null || grid.length == 0)
//             return;

//         int rows = grid.length;
//         int cols = grid[0].length;

//         Queue<int[]> q = new ArrayDeque<>();
//         // Note: We don't even need a separate visited array!
//         // Any cell that is no longer Integer.MAX_VALUE can be considered visited.

//         // Step 1: Add all treasures (0) to the queue to start BFS simultaneously
//         for (int r = 0; r < rows; r++) {
//             for (int c = 0; c < cols; c++) {
//                 if (grid[r][c] == 0) {
//                     q.offer(new int[] {r, c});
//                 }
//             }
//         }

//         // Direction array for moving Up, Right, Down, Left
//         int[] dir = {-1, 0, 1, 0, -1};

//         // Step 2: Global BFS expansion outward
//         while (!q.isEmpty()) {
//             int[] current = q.poll();
//             int r = current[0];
//             int c = current[1];

//             for (int d = 0; d < 4; d++) {
//                 int nr = r + dir[d];
//                 int nc = c + dir[d + 1];

//                 // Check bounds and verify if the cell is an unvisited land area (INF)
//                 // INF is typically represented by Integer.MAX_VALUE (2147483647)
//                 if (nr >= 0 && nr < rows && nc >= 0 && nc < cols
//                     && grid[nr][nc] == Integer.MAX_VALUE) {
//                     // The distance to the neighbor is always the current cell's distance + 1
//                     grid[nr][nc] = grid[r][c] + 1;
//                     q.offer(new int[] {nr, nc});
//                 }
//             }
//         }
//     }
// }

class Solution {
    public void islandsAndTreasure(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;

        Queue<int[]> tresures = new ArrayDeque<>();
        boolean[][] visited = new boolean[rows][cols];
        int[] dir = {-1, 0, 1, 0, -1};

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (grid[r][c] == 0) {
                    visited[r][c] = true;
                    tresures.offer(new int[] {r, c});
                }
            }
        }

        // for (int r = 0; r < rows; r++) {
        //     for (int c = 0; c < cols; c++) {
                // main Logic
                while (!tresures.isEmpty()) {
                    int tresuresSize = tresures.size();
                    // int reachTresureCount = 0;
                    for (int i = 0; i < tresuresSize; i++) {
                        int[] currentPostion = tresures.poll();
                        int currentRow = currentPostion[0];
                        int currentCol = currentPostion[1];

                        for (int d = 0; d < 4; d++) {
                            int nr = currentRow + dir[d];
                            int nc = currentCol + dir[d + 1];
                            if (nr >= 0 && nr < rows && nc >= 0 && nc < cols && grid[nr][nc] > 0
                                && grid[nr][nc] != -1 && grid[nr][nc] != 0 && !visited[nr][nc]) {
                                visited[nr][nc] = true;
                                grid[nr][nc] = grid[currentRow][currentCol] +1;
                                tresures.offer(new int[] {nr, nc});
                            }
                        }
                    }
                    // grid[r][c] = Math.min(grid[r][c], reachTresureCount);
                }

                // end
        //     }
        // }
    }
}
