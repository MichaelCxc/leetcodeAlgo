package Random;

import java.util.HashMap;
import java.util.Map;

public class LongestPalindrome {
    public static int longestPalindrome(String s) {
        char[] chArr = s.toCharArray();
        int len = s.length();
        Map<Character, Integer> map = new HashMap<>();

        for(int i = 0; i < len;i++){
            map.put(chArr[i], map.getOrDefault(chArr[i],0)+1);
        }

        int evenNums = 0;
        int oddMax = 0;
        for(Character ch : map.keySet()){
            if(map.get(ch)%2 == 0){
                evenNums+=map.get(ch);
            }else{
                oddMax = Math.max(oddMax,map.get(ch));
            }
        }
        return oddMax + evenNums;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7,8,9};
        int[] arr2 = arr;
        arr2[0] = 999;
        System.out.println(arr[0]);
    }
}
