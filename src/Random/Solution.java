package Random;

public class Solution {

    public static boolean isValidSudoku(char[][] board) {
        for(int i = 0; i < 9;i++){
            for(int j = 0; j < 9;j++){
                if(board[i][j] == '.') continue;
                if(!isRowValid(board,i,j) || !isColValid(board,i,j) || !isBlockValid(board,i,j))
                    return false;
            }
        }
        return true;
    }

    private static boolean isRowValid(char[][] b, int row, int col){
        int[] map = new int[9];
        map[b[row][col] - '1']++;
        for(int i = 0; i < 9;i++){
            if(i == col || b[row][i] == '.') continue;
            if(b[row][i] == b[row][col]) return false;
            if(map[b[row][i] -'1'] > 0) return false;
            map[b[row][i] - '1']++;
        }

        return true;
    }

    private static boolean isColValid(char[][] b, int row, int col){
        int[] map = new int[9];
        map[b[row][col] - '1']++;
        for(int i = 0; i < 9;i++){
            if(i == row || b[i][col] == '.') continue;
            if(b[i][col] == b[row][col]) return false;
            if(map[b[i][col]- '1']> 0) return false;
            map[b[i][col] - '1']++;
        }
        return true;
    }

    private static boolean isBlockValid(char[][] b, int row, int col){
        int[] map = new int[9];
        map[b[row][col] - '1']++;

        //int rowStart =


        for(int i = (row/3)*3;i <  (row/3)*3+3;i++){
            for(int j = (col/3)*3;j<(col/3)*3+3;j++){
                if((i == row && j == col) || b[i][j] == '.') continue;
                if(b[row][col] == b[i][j]) return false;
                if(map[b[i][j]-'1'] > 0) return false;
                map[b[i][j] - '1']++;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        char[][] board = {
                {'.','.','.','.','5','.','.','1','.'},
                {'.','4','.','3','.','.','.','.','.'},
                {'.','.','.','.','.','3','.','.','1'},
                {'8','.','.','.','.','.','.','2','.'},
                {'.','.','2','.','7','.','.','.','.'},
                {'.','1','5','.','.','.','.','.','.'},
                {'.','.','.','.','.','2','.','.','.'},
                {'.','2','.','9','.','.','.','.','.'},
                {'.','.','4','.','.','.','.','.','.'}};

        isValidSudoku(board);

    }
}
