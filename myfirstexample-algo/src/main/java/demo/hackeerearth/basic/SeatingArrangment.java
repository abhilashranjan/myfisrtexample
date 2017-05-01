package demo.hackeerearth.basic;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by anya on 1/5/17.
 */
public class SeatingArrangment {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean flag= false;
        Long number=Long.parseLong(sc.nextLine());
        int array[]=new int[Math.toIntExact(number)];
        for (int i=0; i<number; i++){
            array[i]=Integer.parseInt(sc.nextLine());

        }
        for(int j=0; j<number; j++){
            findCompartment(array[j]);
        }


    }

    public static void findCompartment(int number){
        int lowerLimit=0;
        int upperLimit=0;
        for(int i=1; i<=108; i=i+12){
            if(number>=i && number<=(i+11)){
                lowerLimit=i;
                upperLimit=i+11;

            }
        }

        int x =findOppositeSeat(number,lowerLimit,upperLimit);
        System.out.println(x+" "+findSeatArrangment(x, lowerLimit, upperLimit));
    }

    public static int  findOppositeSeat(int number, int lowerLimit, int upperLimit){
        int opposite=0;
        int j=11;
        int k=1;
        for (int i=lowerLimit; i<=upperLimit; i++){
            if(number<=(upperLimit-6) && (i<=(upperLimit-6))){
                int x = i + j;
                j=j-2;
                if(i==number) {
                    opposite=x;
                    break;
                }
            }if(number>=(upperLimit-5)&& i>=(upperLimit-5)){
                int x =i-k;
                k=k+2;
                if(i==number) {
                    opposite=x;
                    break;
                }
            }
        }
        return opposite;

    }

    public static String findSeatArrangment(int number, int lowerLimit, int upperLimit){
        Map<Integer, String> seatArrangment= new LinkedHashMap<>();
        int j=5;
        for(int i=lowerLimit; i<=(upperLimit); i++) {
            if(i==lowerLimit || i==(lowerLimit+5) ||i==(lowerLimit+6) ||i==(lowerLimit+11)) {
                seatArrangment.put(i, "WS");
            }if(i==(lowerLimit+1) || i==(lowerLimit+4) ||i==(lowerLimit+7) || i==(lowerLimit+10)){
                seatArrangment.put(i,"MS");
            }if(i==(lowerLimit+2) || i==(lowerLimit+3) || i==(lowerLimit+8) || i==(lowerLimit+9)){
                seatArrangment.put(i,"AS");
            }
        }
        return seatArrangment.get(number);
    }
}
