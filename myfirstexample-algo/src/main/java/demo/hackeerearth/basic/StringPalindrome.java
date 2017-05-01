package demo.hackeerearth.basic;

import java.util.Scanner;

/**
 * Created by anya on 29/4/17.
 */
public class StringPalindrome {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char input[]=sc.nextLine().toCharArray();
        int length = input.length;
        char[] output= new char[length];
        for(int i=length-1; i>=0; i--){
            output[(length-1)-i]=input[i];
        }
        boolean val=true;
        for(int j=0; j<length; j++){
            if(input[j]!=output[j]){
                val=false;
                break;
            }
        }
        if(val){
            System.out.println("YES");
        }else{
            System.out.println("NO");
        }

    }


}
