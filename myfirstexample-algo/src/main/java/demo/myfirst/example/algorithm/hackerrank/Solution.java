package demo.myfirst.example.algorithm.hackerrank;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = Integer.parseInt(in.nextLine());
        int a[][] = new int[n][n];
        int sumOne=0;
        int sumTwo=0;

        for(int a_i=0; a_i < n; a_i++){
            String input[]=in.nextLine().split(" ");
            for(int a_j=n-1; a_j >=0; a_j--){
                a[a_i][a_j] = Integer.parseInt(input[a_j]);
                if(a_i==a_j){
                    sumOne=sumOne+a[a_i][a_j];
                }
                if(Math.abs(a_j+a_i)==(n-1)){
                    sumTwo=sumTwo+a[a_i][a_j];
                }
            }
        }

        System.out.println("SUM ONE :_"+sumOne);
        System.out.println("SUM TWO :_"+sumTwo);
        System.out.println(Math.abs(sumOne-sumTwo));
    }
}
