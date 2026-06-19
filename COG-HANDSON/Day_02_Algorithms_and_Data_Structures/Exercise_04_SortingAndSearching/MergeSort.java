package day02.exercise04;

import java.util.Arrays;

public class MergeSort {
    public static int[] sort(int[] arr){
        if (arr.length<=1) return arr;
        int mid = arr.length/2;
        int[] left = sort(Arrays.copyOfRange(arr,0,mid));
        int[] right = sort(Arrays.copyOfRange(arr,mid,arr.length));
        return merge(left,right);
    }
    private static int[] merge(int[] a,int[] b){
        int[] r = new int[a.length+b.length]; int i=0,j=0,k=0;
        while(i<a.length && j<b.length) r[k++] = (a[i]<=b[j])? a[i++] : b[j++];
        while(i<a.length) r[k++]=a[i++]; while(j<b.length) r[k++]=b[j++]; return r;
    }
    public static int binarySearch(int[] arr,int target){
        int l=0,r=arr.length-1;
        while(l<=r){ int m=(l+r)/2; if(arr[m]==target) return m; if(arr[m]<target) l=m+1; else r=m-1; }
        return -1;
    }
}
