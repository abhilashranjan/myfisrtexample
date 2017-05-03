package demo.hackeerearth.basic;

import java.util.Scanner;

/**
 * Created by anya on 3/5/17.
 */
public class MagicalWord {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean flag= false;
        Integer len=Integer.parseInt(sc.nextLine());
        String inputStr[]= new String[len];
        for(int i=0; i<len; i++){
            Integer strLen=Integer.parseInt(sc.nextLine());
            String inputString = sc.nextLine();
            if(inputString.length()==strLen) {
                inputStr[i] = inputString;
            }
        }

        for (int i=0; i<len; i++){
            System.out.println(convertString(inputStr[i]));
        }
    }

    public static String convertString(String inputString){
        String returnOut = null;
        char inputCh[]=inputString.toCharArray();
        char outputCh[]=new char[inputString.length()];
        for(int i=0; i<inputCh.length; i++){
            int asciCode=inputCh[i];
           outputCh[i]=convertPrimeCharater(asciCode);
        }
        returnOut=new String(outputCh);
        return returnOut;
    }

    public static char convertPrimeCharater(int chCode){
        char conOutput=' ';
        int val=0;
        boolean flag=false;
        for(int i=chCode+1; i<=(chCode+5); i++){
            for(int j=2; j<i/2; j++){
                if(i%j==0){
                    flag=false;
                    break;
                }else{
                    val=i;
                    flag=true;
                    break;
                }

            }
            if(flag==true){
                val=i;
                break;
            }


        }
        if(flag){
            conOutput=(char)val;
        }

        int check=(int)conOutput;
        char con2=' ';
        if((check-chCode)==2){
            for(int i=chCode-2; i<(chCode); i++){
                for(int j=2; j<i/2; j++){
                    if(i%j==0){
                        flag=false;
                        break;
                    }else{
                        flag=true;
                    }
                }
                if(flag){
                    val=i;
                    break;
                }
            }

        }

        if(con2!=' '){
            return con2;
        }else {
            return conOutput;
        }
    }
}
