package demo.java8;

import java.util.Scanner;

/**
 * Created by anya on 11/9/17.
 */
public class TestSample {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        sc.nextLine()
                .chars()
                .map(val -> (val > 25 && val < 91) ? val + 32 : val - 32)
                .mapToObj(i -> (char) i)
                .forEach(System.out::print);
        Double d1= Double.valueOf(sc.nextLine());

    }

    public String checkPaddingMessage(String message){

        if(message.contains(".")){
            String[] split = message.split(".");

            for(int i=0; i<split.length; i++){
//                if(!split[i].contains("0") && (split[i]<=(split[i].length() ))){
//
//                }
            }

        }
        return "NO";
    }
}
