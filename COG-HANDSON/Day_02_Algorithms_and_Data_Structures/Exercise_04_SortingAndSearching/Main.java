package day02.exercise04;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] data = {5,3,8,1,2,9,4};
        int[] sorted = MergeSort.sort(data);
        System.out.println("Sorted: " + Arrays.toString(sorted));
        System.out.println("Index of 8: " + MergeSort.binarySearch(sorted,8));
    }
}
