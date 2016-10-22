package demo.myfirst.example.algorithm.hackerrank.algorithm.hackerrank.java8;

import java.util.Scanner;
import java.util.function.BinaryOperator;

/**
 * Created by abhilash on 14/3/16.
 */
public class FunctionalSum {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int a;
        a = in.nextInt();
        int b;
        switch (b = in.nextInt()) {
        }
        BinaryOperator<Integer> sum=(i,j)->i+j;
        System.out.println(sum.apply(a,b));
    }
}

