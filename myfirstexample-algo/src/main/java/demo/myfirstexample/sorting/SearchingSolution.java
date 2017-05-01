package demo.myfirstexample.sorting;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by abhilash on 22/3/16.
 * 4
 * 6
 * 1 4 5 7 9 12
 */
public class SearchingSolution {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int search =scanner.nextInt();
        int size=scanner.nextInt();
        int arr[]= new int[size];
        for(int i=0; i<size; i++){
            arr[i]=scanner.nextInt();
        }

        for (int j=0; j<size; j++){
            if(search==arr[j]){
                System.out.println(j);
            }
        }
    }

}
