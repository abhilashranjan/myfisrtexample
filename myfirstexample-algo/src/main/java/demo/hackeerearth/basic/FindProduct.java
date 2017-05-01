package demo.hackeerearth.basic;


import java.util.Scanner;

/**
 * Created by anya on 30/4/17.
 */
public class FindProduct {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        long sizeOfArray= Long.parseLong(sc.nextLine());
        double answer=1.0;
        long array[]=new long[Math.toIntExact(sizeOfArray)];
        String split[]=sc.nextLine().split(" ");
        for (int i=0; i<sizeOfArray; i++){
            array[i]=Long.parseLong(split[i]);
            answer=  ((answer*array[i])%((Math.pow(10,9))+7));

        }
       System.out.println((long) answer);

    }
}
