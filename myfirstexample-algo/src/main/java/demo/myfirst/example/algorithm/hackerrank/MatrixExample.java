package demo.myfirst.example.algorithm.hackerrank;

import java.util.Scanner;

/**
 * Created by abhilash on 8/3/16.
 */
public class MatrixExample {
    public static void main(String[] args) {
        int leftD=0;
        int rightD=0;
        Scanner reader = new Scanner(System.in);
        System.out.println("No of Input :-");
        int numInputs= reader.nextInt();
        for(int j = 0; j < numInputs; j++){
            for(int k = 0; k < numInputs; k++){
                System.out.printf("CURSOR INPUT");
                int curInput=reader.nextInt();
                if(j == k){
                    leftD += curInput;
                }
                if(j+k == (numInputs-1)){
                    rightD += curInput;
                }
            }
        }
        int ans = Math.abs(leftD-rightD);
        System.out.println("ANS "+ans);

    }

}
