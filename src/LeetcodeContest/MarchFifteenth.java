package LeetcodeContest;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MarchFifteenth {

    public static int totalNumbers(int[] digits) {
        Set<Integer> set = new HashSet<>();

        helper(digits,0,set,0);
        return set.size();
    }

    private static void helper(int[] digits, int index, Set<Integer> set, int res){
        if(res <= 999 && res >= 100 && res%2 == 0 &&!set.contains(res)){
            set.add(res);
            return;
        }

        if(res > 999 || (res <= 999 && res >= 100 && res%2 != 0)) return;

        for(int i = 0; i < digits.length;i++){
            if( i == index)continue;
            int tmp = digits[i];
            res = res*10 + tmp;
            helper(digits,i,set,res);
            res -= tmp;
            res  /= 10;
        }
    }

    public static void main(String[] args) {
        //int[] arr = {1,2,3,4};
        //System.out.println(totalNumbers(arr));
//        Spreadsheet obj = new Spreadsheet(3);
//        obj.setCell("A1", 10);
//        System.out.println(obj.getValue("=A1+1"));
        int[] nums = {1,3,1,4,1,3,2};
        int[] queries = {0,3,5};
        System.out.println(solveQueries(nums,queries));
    }

    public static List<Integer> solveQueries(int[] nums, int[] queries) {
        List<Integer> res = new ArrayList<>();
        for(int i = 0; i < queries.length;i++){
            int idx = queries[i];
            res.add(findNear(idx,nums));
        }
        return res;
    }

    private static int findNear(int index, int[] nums){
        int left = index - 1, right = index + 1;
        List<Integer> close = new ArrayList<>();

        while(left >= 0){
            if(nums[left] == nums[index]){
                close.add(left);
            }
            left--;
        }
        while(right < nums.length){
            if(nums[right] == nums[index]){
                close.add(right);
            }
            right++;
        }

        int res = Integer.MAX_VALUE;
        for(int dis : close){
            if(dis > index){
                res = Math.min(res,dis-index);
            }else{
                int tmp = dis + (nums.length - index);
                res = Math.min(res,dis);
            }
        }

        return res == Integer.MAX_VALUE ? -1 : res;
    }



    static class Spreadsheet {

        int[][] grid;

        public Spreadsheet(int rows) {
            this.grid = new int[rows][26];
        }

        public void setCell(String cell, int value) {
            char tmp = cell.charAt(0);
            int col = tmp - 'A';
            int row = Integer.parseInt(cell.substring(1));
            grid[row][col] = value;
        }

        public void resetCell(String cell) {
            //StringBuilder sb = new StringBuilder(cell);
            char tmp = cell.charAt(0);
            int col = tmp - 'A';
            int row = Integer.parseInt(cell.substring(1));
            grid[row][col] = 0;
        }

        public int getValue(String formula) {
            String act = formula.substring(1);
            int indesOfAdd = act.indexOf("+");
            String first = act.substring(0,indesOfAdd);
            String second = act.substring(indesOfAdd+1);
            int str1 = getIndex(first);
            int str2 = getIndex(second);
            return str1 + str2;
        }

        private int getIndex(String str){
            if(str.charAt(0) <= 'Z' && str.charAt(0) >= 'A'){
                int row = str.charAt(0) - 'A';
                int col = Integer.parseInt(str.substring(1));
                return grid[row][col];
            }else{
                return Integer.parseInt(str);
            }
        }
    }
}
