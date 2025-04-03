package HackRank;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class Segments {

    public static int birthday(List<Integer> s, int d, int m) {
        // Write your code here
        int left = 0, right = m - 1;
        int[] arr = new int[s.size()];
        for(int i = 0; i < m; i++){
            arr[i] += s.get(i);
            if(i > 0){
                arr[i] += arr[i-1];
            }
        }
        int res = 0;
        while(right < s.size()){
            // arr[right] += s.get(right);
            if(arr[right] == d)
                res++;
            right++;
            if(right < s.size()){
                arr[right] += arr[right-1];
                arr[right] += s.get(right);
                arr[right] -= s.get(left++);
            }
        }
        return res;
    }

    public static int pickingNumbers(List<Integer> a) {
        // Write your code here
        int[] arr = new int[a.size()];
        for(int i = 0; i < a.size();i++){
            arr[i] = a.get(i);
        }

        //Arrays.sort(a);

        Arrays.sort(arr);

        int pivotal = 0;

        int res = 0;

        while(pivotal < arr.length){
            if(pivotal >=1 && arr[pivotal] == arr[pivotal-1]){
                pivotal++;
                continue;
            }
            int val = 0;
            int right = pivotal , left = pivotal ;
            while(right< arr.length&&Math.abs(arr[right] -arr[pivotal])<=1 ){
                right++;
            }

            while(left >= 0 && Math.abs(arr[pivotal] - arr[left])<=1){
                left--;
            }

            if(right == pivotal + 1 && left == pivotal - 1){
                val = 1;
            }else if(right == arr.length && left == -1){
                return arr.length;
            }else{
                val = right - left - 2;
            }

            res = Math.max(res,val);
            pivotal++;
        }
        return res;
    }


    public static void main(String[] args) throws IOException {
//        List<Integer> arr = new ArrayList<>();
//        arr.add(1);arr.add(2);arr.add(2);arr.add(3);arr.add(1);arr.add(2);
//        System.out.println(pickingNumbers(arr));
        int i = 5;
        System.out.println(++i);
    }
}
