package demo.myfirst.example.algorithm.hackerrank;

import java.util.Scanner;

/**
 * Created by abhilash on 8/3/16.
 */
public class MatrixSolution {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        int sumOne = 0;
        int sumTwo = 0;

        for (int i = 0, j = n - 1; i < n; i++, j--) {
            String[] inputLine = scan.nextLine().split(" ");

            sumOne = sumOne
                    + Integer.parseInt(inputLine[i]);
            sumTwo = sumTwo
                    + Integer.parseInt(inputLine[j]);
        }
        System.out.println(Math.abs(sumOne - sumTwo));
    }
}
