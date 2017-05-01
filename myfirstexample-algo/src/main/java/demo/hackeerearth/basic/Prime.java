package demo.hackeerearth.basic;

import java.util.Scanner;

/**
 * Created by anya on 30/4/17.
 */
public class Prime {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean flag= false;
        Integer len=Integer.parseInt(sc.nextLine());
        for(int i=1; i<=len; i++){
            for(int j=2; j<i; j++){
                if(i%j==0){
                    flag=false;
                    break;
                }else{
                    flag=true;
                }

            }
            if(i==2){
                System.out.print(2+" ");
          }
            if(flag){
                System.out.printf(i+" ");
            }
            flag=false;

        }
    }
}
