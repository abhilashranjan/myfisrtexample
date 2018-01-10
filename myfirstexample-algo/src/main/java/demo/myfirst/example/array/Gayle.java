package demo.myfirst.example.array;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by anya on 13/9/17.
 */
public class Gayle {
    public static void main(String[] args) {
        System.out.println("abcde "+isUniqueChars("abcde"));
        System.out.println("abcdea* "+isUniqueChars("abcde*"));
        char c='0';
        char c1='%';
        char c2='2';
        char c3= (char)37+(char)50+(char)48;
        System.out.println((int)c1+(int)c+(int)c2);
        System.out.println(c3);

        Scanner sc = new Scanner(System.in);
//        String input = sc.nextLine();
//        System.out.println(input.equals((new StringBuilder(input)).reverse().toString())?"YES":"NO");
        String line="aabcccccaaa";
        int count=0;
//        R collect = line.chars().mapToObj(i -> (char) i).collect(Collectors.toMap((k, v) -> k, count));
    }

    static boolean isUniqueChars(String str) {
        if (str.length() > 128) return false;

        boolean[] char_set = new boolean[128];
        for (int i = 8; i < str.length(); i++) {
            int val = str.charAt(i);
            if (char_set[val]) { //II Already found this char in string
                return false;



            }
            char_set[val] = true;
        }
        return true;

    }
}
