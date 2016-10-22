package demo.myfirst.example.algorithm.hackerrank;

import java.util.Scanner;

/**
 * Created by abhilash on 10/3/16.
 */
public class SolutionFraction {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = Integer.parseInt(in.nextLine());
        int arr[] = new int[n];
        int sumNegative=0;
        int sumPositive=0;
        int countNegative=0;
        int countPositive=0;
        int countZero=0;
        for(int arr_i=0; arr_i < n; arr_i++){
            arr[arr_i] = in.nextInt();
            if(arr[arr_i]<0){
                sumNegative=sumNegative+arr[arr_i];
                countNegative++;
            }
            if(arr[arr_i]>0){
                sumPositive=sumPositive+arr[arr_i];
                countPositive++;
            }if(arr[arr_i]==0){
                countZero++;
            }
        }
        System.out.println((double)countPositive/n);
        System.out.println((double)countNegative/n);
        System.out.println((double)countZero/n);
    }
}
