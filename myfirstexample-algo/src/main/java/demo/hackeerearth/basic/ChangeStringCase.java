package demo.hackeerearth.basic;

import java.util.Scanner;

/**
 * Created by anya on 29/4/17.
 */
public class ChangeStringCase {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        char input[]=sc.nextLine().toCharArray();
        int length = input.length;
        char[] output= new char[length];
        for (int i = 0; i< length; i++){
            output[i]=convert(input[i]);
        }
        System.out.println(output);



    }

    public static char convert(char a){

        int c1=(int)a;
        if(c1>64 && c1<91){
            c1=c1+32;

        }else{
            c1=c1-32;

        }
        char b=(char)c1;
        return  b;
    }
}
