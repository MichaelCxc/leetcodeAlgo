package Sort;

import java.util.Arrays;

public class QuickSort {
    public static void sortRecursively(int[] nums) {
        quickSortRecursively(nums, 0, nums.length - 1);
    }

    public static void sortIteratively(int[] nums) {
        if (nums.length == 0 || nums.length == 1) return;
        quickSortIteratively(nums, 0, nums.length - 1);
    }

    private static void quickSortRecursively(int[] nums, int left, int right) {
        if (left >= right) return;

        int p = partition4(nums, left, right);
        quickSortRecursively(nums, left, p - 1);
        quickSortRecursively(nums, p + 1, right);
    }

    private static void quickSortIteratively(int arr[], int l, int h) {
        int stack[] = new int[h-l+1];

        int top = -1;
        stack[++top] = l;
        stack[++top] = h;

        while (top >= 0) {
            h = stack[top--];
            l = stack[top--];

            int p = partition3(arr, l, h);

            if (p-1 > l) {
                stack[++top] = l;
                stack[++top] = p - 1;
            }

            if (p+1 < h) {
                stack[++top] = p + 1;
                stack[++top] = h;
            }
        }
    }

    private static int partition(int[] nums, int left, int right) {
        int pivot = nums[right];
        int i = (left - 1);
        for (int j = left; j < right; j++) {
            if (nums[j] <= pivot) {
                i++;
                swap(nums, i, j);
            }
        }
        swap(nums, i+1, right);
        return (i + 1);
    }


    private static int partition2(int[] nums, int left, int right) {
        int pivot = nums[right];
        int i = left;
        for (int j=left; j<right; j++) {
            if (nums[j] <= pivot) {
                swap(nums, i, j);
                i++;
            }
        }
        swap(nums, i, right);
        return i;
    }

    private static int partition3(int[] nums, int left, int right) {
        int pivot = nums[left];
        int i = left+1;
        int j = right;
        while (true) {
            while (i <= j && nums[i] <= pivot) i++;
            while (i <= j && nums[j] > pivot) j--;
            if (i >= j) break;
            swap(nums, i, j);
        }
        swap(nums, left, j);
        return j;
    }

    private static int partition4(int[] nums, int start, int end){
        int pivotal = nums[end];
        int l = start, r = end-1;
        while(l < r){
            while(l<=r &&nums[l] < pivotal)l++;
            while(l <= r && nums[r] >= pivotal)r--;
            if(l < r){
                swap(nums,l,r);
            }else{
                break;
            }
            //l++;r--;
        }
        if(nums[l] >= pivotal){
            swap(nums,l,end);
        }

        return l;
    }


    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        int[] arr1 = {10, 3, 7, 5, 20, 15, 1,1,1,1,1,3,3,3,3,3,116,15,15,1,5,15,15,17};
        QuickSort.quickSortRecursively(arr1,0,arr1.length-1);
        System.out.println(Arrays.toString(arr1));
//
//        int[] arr2 = {};
//        QuickSort.sortIteratively(arr2);
//        System.out.println(Arrays.toString(arr2));
//
//        int[] arr3 = {10};
//        QuickSort.sortIteratively(arr3);
//        System.out.println(Arrays.toString(arr3));
        int[] arr4 = {0,1,2,3,4,5,6,7,8,9,10};
        QuickSort.quickSortRecursively(arr4,0,arr4.length-1);
        System.out.println(Arrays.toString(arr4));
    }
}
