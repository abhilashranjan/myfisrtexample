package demo.hackeerearth.basic;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by anya on 1/5/17.
 */
public class Life {
    public static void main(String[] args) {
        List<Integer> input= new ArrayList<>();
        Scanner sc= new Scanner(System.in);
        while(true){
            int in = Integer.parseInt(sc.nextLine());
            input.add(in);
            if(in>=99){
                break;
            }
        }
        int lastIndex=0;
        if(input.contains(42)){
            lastIndex=input.indexOf(42);
        }
       for(int i=0; i<lastIndex; i++){
           System.out.println(input.get(i));
       }
    }
}
