class Solution {
    public boolean hasDuplicates(char[] charArr) {
        Map<Character, Integer> countMap = new HashMap<>();
        for (char c : charArr) {
            if (c == '.') {
                continue;
            }
            countMap.put(c, countMap.getOrDefault(c, 0) + 1);

            if (countMap.get(c) > 1) {
                return true; // duplicate found
            }
        }
        return false; // no duplicates
    }

    public boolean isValidSudoku(char[][] board) {
        System.out.println(board);
        // check rows has duplictaes
        for (int i = 0; i < board.length; i++) {
            System.out.println(board[i]);
            if (hasDuplicates(board[i])) {
                return false;
            }
        }
        // Check columns
        for (int col = 0; col < 9; col++) {
            char[] column = new char[9];
            for (int row = 0; row < 9; row++) {
                column[row] = board[row][col];
            }

            if (hasDuplicates(column)) {
                return false;
            }
        }

         // Check each 3x3 box
        for (int boxRow = 0; boxRow < 9; boxRow += 3) {
            for (int boxCol = 0; boxCol < 9; boxCol += 3) {

                char[] box = new char[9];
                int index = 0;

                for (int i = boxRow; i < boxRow + 3; i++) {
                    for (int j = boxCol; j < boxCol + 3; j++) {
                        box[index++] = board[i][j];
                    }
                }

                if (hasDuplicates(box)) {
                    return false;
                }
            }
        }
        
        return true;
    }
}
