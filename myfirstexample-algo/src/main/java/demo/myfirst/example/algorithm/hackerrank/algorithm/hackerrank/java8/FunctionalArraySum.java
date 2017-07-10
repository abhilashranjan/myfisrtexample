package demo.myfirst.example.algorithm.hackerrank.algorithm.hackerrank.java8;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

/**
 * Created by abhilash on 14/3/16.
 */
public class FunctionalArraySum {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int arr[] = new int[n];
        Arrays.stream(arr).sum();
        String[] asytr= {"1","3","4"};
        Arrays.stream(asytr).map(Integer::parseInt).reduce((sum,i)->sum+=i).get();

    }


    private static int sumIterator(List<Integer> list) {
        int sum=0;
        for(Integer item:list){
            sum+=item;
        }
        return sum;
    }
}
