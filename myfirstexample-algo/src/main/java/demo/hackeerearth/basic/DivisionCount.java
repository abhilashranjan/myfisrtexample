package demo.hackeerearth.basic;

import java.util.Scanner;

/**
 * Created by anya on 30/4/17.
 */
public class DivisionCount {
    public static void main(String[] args) {
        int count=0;
        Scanner sc = new Scanner(System.in);
        String split[]=sc.nextLine().split(" ");
        for(int i=Integer.parseInt(split[0]); i<=Integer.parseInt(split[1]); i++){
            int div=i%Integer.parseInt(split[2]);
            if(div==0){
                count++;
            }
        }
        System.out.println(count);

    }
}
