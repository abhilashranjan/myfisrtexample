package demo.hackeerearth.implmentation;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by anya on 4/5/17.
 */
public class CountNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Integer numTest=Integer.parseInt(sc.nextLine());
        String straArr[]= new String[numTest];
        for(int i=0; i<numTest; i++){
            int strLen=Integer.parseInt(sc.nextLine());
            String s=sc.nextLine();
            if(strLen==s.length()){
                straArr[i]=s;
            }
        }
        for(int i=0; i<numTest; i++){
            System.out.println(findNumber(straArr[i]));
        }

        }

    private static int findNumber(String str) {

        char ctr[] = str.toCharArray();
        char ctr2[] = new char[str.length()];

        StringBuffer sb = new StringBuffer();
        for (int j = 0; j < ctr.length; j++) {
            int ctrInt = (int) ctr[j];
            if (ctrInt >= 48 && ctrInt <= 57) {
                ctr2[j] = ctr[j];
            } else {
                ctr2[j] = ',';
            }

        }

        String s1 = new String(ctr2);
        List<Long> arr = new ArrayList<>();
        String[] split = s1.split(",");
        for (int j = 0; j < split.length; j++) {
            if ((!split[j].equalsIgnoreCase(""))) {
                arr.add(Long.parseLong(split[j]));
            }
        }


        return  arr.size();
    }


}
