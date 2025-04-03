package LeetcodeContest;

import java.util.*;

public class Solution {

    public static long[] findMaxSum(int[] nums1, int[] nums2, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(k,(x,y)-> x-y);
        Map<Integer,List<Integer>> map = new HashMap<>();

        long[] res = new long[nums1.length];

        for(int i = 0; i < nums1.length;i++){
            int key = nums1[i];
            map.put(i,new ArrayList<>());
            for(int j = 0; j< nums1.length;j++){
                if(i == j) continue;
                if(nums1[j] < key){
                    List<Integer> tmp = map.get(i);
                    tmp.add(j);
                    map.put(i,tmp);
                }
            }
        }

        for(int i = 0;i < nums1.length;i++){
            pq.clear();
            //int key = nums1[i];
            List<Integer> items = map.get(i);
            long tmpVal = 0;
            for(Integer myInt : items){
                int index = myInt;
                int value = nums2[index];
                if(!pq.isEmpty() && value > pq.peek()){
                    //pq.poll();
                    if(pq.size() == k){
                        pq.poll();
                    }
                    pq.offer(value);
                }else if(pq.isEmpty()){
                    pq.offer(value);
                }
            }

            int a = 0;
            while(!pq.isEmpty() && a < k){
                tmpVal += (long)(pq.poll());
                a++;
            }
            res[i] = tmpVal;
        }

        return res;

    }

    public static void main(String[] args) {
        int[] nums1 = {25,15,1,28,3,13,29,26,1,2,28,5,2,14,19,2,4};
        int[] nums2 = {25,21,3,23,26,6,30,22,27,21,24,27,15,17,15,16,25};

        findMaxSum(nums1,nums2,9);
    }
}
