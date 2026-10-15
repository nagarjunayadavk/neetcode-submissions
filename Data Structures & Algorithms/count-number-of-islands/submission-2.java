class Solution {
    public int numIslands(char[][] grid) {

        int rows = grid.length;
        int cols = grid[0].length;
        int isLandCount = 0;

        boolean[][] visited = new boolean[rows][cols];

        int[] dir= {-1, 0, 1, 0, -1};

        for(int r =0 ; r < rows; r++){
            for(int c=0; c < cols; c++){
                if(grid[r][c] == '1' && !visited[r][c]){
                    isLandCount++;
                    Queue<int[]> q = new ArrayDeque<>();
                    q.offer(new int[]{r, c}); //default push base one
                    while(!q.isEmpty()){
                       int[] currentPostion = q.poll(); 
                       int currentRow = currentPostion[0];
                       int currentCol = currentPostion[1];
                       
                       //all 4 directions
                       for(int i=0; i < 4; i++){
                        int newRow = currentRow + dir[i];
                        int newCol = currentCol + dir[i+1];
                        
                        // check cell is inside and ==1 the make visited
                        if( newRow >=0  && newRow < rows &&
                            newCol >=0 && newCol < cols &&
                            grid[newRow][newCol] == '1' &&
                            !visited[newRow][newCol]){
                                visited[newRow][newCol] = true;
                                 q.offer(new int[]{newRow, newCol}); 
                            }

                       }
                    }
                }
            }
        }
        
        return isLandCount;
    }
}
