class Solution {
    public int numIslands(char[][] grid) {

        int[] dir = {-1, 0, 1, 0, -1};

        int rows = grid.length;
        int cols = grid[0].length;

        int islands = 0;
        boolean[][] visited = new boolean[rows][cols];

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {

                if (grid[r][c] == '1' && !visited[r][c]) {

                    islands++;

                    Queue<int[]> queue = new ArrayDeque<>();

                    visited[r][c] = true;
                    queue.offer(new int[]{r, c});

                    while (!queue.isEmpty()) {

                        int[] cell = queue.poll();

                        int row = cell[0];
                        int col = cell[1];

                        for (int i = 0; i < 4; i++) {

                            int newRow = row + dir[i];
                            int newCol = col + dir[i + 1];

                            if (newRow >= 0 && newRow < rows &&
                                newCol >= 0 && newCol < cols &&
                                grid[newRow][newCol] == '1' &&
                                !visited[newRow][newCol]) {

                                visited[newRow][newCol] = true;
                                queue.offer(new int[]{newRow, newCol});
                            }
                        }
                    }
                }
            }
        }

        return islands;
    }
}
