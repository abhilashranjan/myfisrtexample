package demo.myfirst.example.algorithm.hackerrank;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Abhilash Ranjan
 */
public class InsertionSortDemo {

    public static void main(String args[]) {
        Scanner in=new Scanner(System.in);
        int n=in.nextInt();
        // unsorted integer array

        int[] unsorted = new int[n];
        int i=0;
        while(i<n){
            unsorted[i]=in.nextInt();
            i++;
        }
        insertionSort(unsorted);
        //System.out.println(Arrays.toString(unsorted));
    }


    /*
     * Sort integer array using Insertion sort algorithm.
     * only good for small array.
     */
    public static void insertionSort(int[] unsorted) {
        int cnt=0;
        for (int i = 1; i < unsorted.length; i++) {
            int j = i;
            while (j > 0 && unsorted[j] < unsorted[j - 1]) {
                //swap
                int temp = unsorted[j - 1];
                unsorted[j - 1] = unsorted[j];
                unsorted[j] = temp;
                j--;
                cnt++;
            }
//            System.out.println(unsorted[j]);
            priint(unsorted);
            System.out.println();
        }
        System.out.println(cnt);
    }
    public static void priint(int[] unsorted){
        for (int i = 0; i < unsorted.length; i++) {
            System.out.print(unsorted[i]+" ");
        }
    }

}


