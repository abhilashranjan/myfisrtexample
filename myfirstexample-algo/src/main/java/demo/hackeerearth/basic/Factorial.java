package demo.hackeerearth.basic;

import java.util.Scanner;

/**
 * Created by anya on 1/5/17.
 */
public class Factorial {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean flag= false;
        Long number=Long.parseLong(sc.nextLine());
        System.out.printf(String.valueOf(fact(number)));
    }

    public static long fact(long n){
        if(n==1){
            return 1;
        }else
        {
            return(n*fact(n-1));
        }
    }
}
