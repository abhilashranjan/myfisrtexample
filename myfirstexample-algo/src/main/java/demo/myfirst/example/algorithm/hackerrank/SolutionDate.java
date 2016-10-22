package demo.myfirst.example.algorithm.hackerrank;

import java.util.Scanner;

/**
 * Created by abhilash on 10/3/16.
 */
public class SolutionDate {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String time = in.next();
        String split[]=time.split(":");
        String str="";
        split[2]=split[2].substring(0,2);
        Integer hh = Integer.parseInt(split[0]);
        if(time.contains("PM")){
            split[0]=(hh<12)?String.valueOf(hh+12):"12";
        }if(time.contains("AM")){
            split[0]=(hh==12)?"00":String.valueOf(hh);
        }
        for (int i=0; i<split.length; i++){
            str=str+split[i];
            if(i<split.length-1){
                str+=":";
            }
        }
        System.out.println(str);
    }
}
