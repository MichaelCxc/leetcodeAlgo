import java.util.Hashtable;

public class Contest {
    public static boolean canPartitionGrid(int[][] grid) {
        int r = grid.length,c = grid[0].length;
        long[] preSumR = new long[r];
        long[] preSumC = new long[c];
        //preSumR[0][0] = grid[0][0];
        for(int i = 0; i < r; i++){
            preSumR[i] = grid[i][0];
            for(int j = 1; j < c;j++){
                preSumR[i] +=  grid[i][j];
            }
            if(i > 0){
                preSumR[i] += preSumR[i-1];
            }
        }

        for(int i = 0; i < c;i++){
            preSumC[i] = grid[0][i];
            for(int j = 1; j < r;j++){
                preSumC[i] += grid[j][i];
            }
            if(i > 0){
                preSumC[i] += preSumC[i-1];
            }
        }
        Hashtable

        //check row sum
        for(int i = 0; i < r-1; i++){
            long upSide = preSumR[i];

            long downSide = preSumR[r-1] - upSide;
            if(upSide == downSide) return true;
        }

        //chec column sum
        for(int i = 0; i < c-1;i++){
            long left = preSumC[i];
            long right = preSumC[c-1] - left;
            if(left == right) return true;
        }
        return false;

    }

    public static void main(String[] args) {
        int[][] grid = {{1,4},{2,3}};
        System.out.println(canPartitionGrid(grid));
    }
}
