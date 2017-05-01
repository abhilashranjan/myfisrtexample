package demo.hackeerearth.basic;

import java.util.Scanner;

/**
 * Created by anya on 30/4/17.
 */
public class RoyAndPicture {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Integer len=Integer.parseInt(sc.nextLine());
        long sizeOfArray= Long.parseLong(sc.nextLine());
        double answer=1.0;
        String array[]=new String[Math.toIntExact(sizeOfArray)];
        for(int i=0; i<sizeOfArray; i++){
            array[i]=sc.nextLine();
        }
        boolean check= false;
        for(int i=0; i<sizeOfArray; i++){
            check=true;
            String[] split = array[i].split(" ");
            if((check==true)&&(((Integer.parseInt(split[0])>=len && Integer.parseInt(split[1])>=len) && (Integer.parseInt(split[0])==Integer.parseInt(split[1])))||(Integer.parseInt(split[0])==len) && ((Integer.parseInt(split[1])==len)))){
                System.out.println("ACCEPTED");
                check=false;
            }if((check==true) &&((Integer.parseInt(split[0])<len)||(Integer.parseInt(split[1])<len))){
                System.out.println("UPLOAD ANOTHER");
                check=false;
            }if((check==true) && ((Integer.parseInt(split[0])>len) || (Integer.parseInt(split[1])>len))){
                System.out.println("CROP IT");
                check=false;
            }
        }
    }
}
