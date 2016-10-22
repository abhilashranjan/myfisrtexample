package demo.myfirst.example.algorithm.hackerrank.sorting;

import com.sun.xml.internal.bind.v2.model.annotation.Quick;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Queue;
import java.util.Scanner;

/**
 * Created by abhilash on 22/4/16.
 */
public class Quicksort {
    public static void quick(int arr[],int low, int high) {
        int pivot = arr[low];
        int i = low, j = high;
        while(i<=j){
            while(arr[i]<pivot){
                i++;
            }
            while(arr[j]>pivot){
                j--;
            }
            if(i<=j){
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                i++;
                j--;
            }
        }
        if (low < j)
            quick(arr, low, j);

        if (high > i)
            quick(arr, i, high);
    }

    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int n=in.nextInt();
        // unsorted integer array

        int[] x = new int[n];
        int i=0;
        while(i<n){
            x[i]=in.nextInt();
            i++;
        }
        int low = 0;
        int high = x.length - 1;
        quick(x,low,high);
        print(x);
    }

    public static void print(int a[]){
        for (Integer i:a ) {
            System.out.print(" "+i);
        }
    }
}
