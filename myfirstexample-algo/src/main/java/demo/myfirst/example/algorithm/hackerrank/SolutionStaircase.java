package demo.myfirst.example.algorithm.hackerrank;

import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * Created by abhilash on 10/3/16.
 */
public class SolutionStaircase {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        IntStream.range(0, n).forEach(i -> {
            IntStream.range(0, n).filter(j -> Math.abs(i + j) >= n - 1).forEach(j -> System.out.print("#"));
            System.out.println();
        });
        int a = in.nextInt();
        int b = in.nextInt();

    }

    private static void usingNormalJava(int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(Math.abs(i + j) >= (n - 1) ? "#" : " ");
            }
            System.out.println();
        }
    }
}
