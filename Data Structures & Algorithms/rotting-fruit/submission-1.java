class Solution {
    public int orangesRotting(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;

        Deque<int[]> que = new ArrayDeque<>();
        int freshCount = 0;

        int[] dir = {-1, 0, 1, 0, -1};

        // Add all initially rotten oranges
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (grid[r][c] == 2) {
                    que.offer(new int[]{r, c});
                } else if (grid[r][c] == 1) {
                    freshCount++;
                }
            }
        }

        if (freshCount == 0) {
            return 0;
        }

        int minutes = 0;

        while (!que.isEmpty()) {
            int size = que.size();

            for (int i = 0; i < size; i++) {
                int[] current = que.poll();

                int cr = current[0];
                int cc = current[1];

                for (int j = 0; j < 4; j++) {
                    int nr = cr + dir[j];
                    int nc = cc + dir[j + 1];

                    if (nr >= 0 && nr < rows &&
                        nc >= 0 && nc < cols &&
                        grid[nr][nc] == 1) {

                        grid[nr][nc] = 2;
                        freshCount--;

                        que.offer(new int[]{nr, nc});
                    }
                }
            }

            minutes++;

            if (freshCount == 0) {
                return minutes;
            }
        }

        return -1;
    }
}