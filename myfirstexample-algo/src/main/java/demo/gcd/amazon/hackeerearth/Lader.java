package demo.gcd.amazon.hackeerearth;

/**
 * Created by anya on 10/5/17.
 */
public class Lader {

    static  String[] twins(String[] a, String[] b) {
        String ans[]= new String[a.length];
        for(int i=0; i<a.length; i++){
             String rev=a[i].substring(2,4)+a[i].substring(0,2);
             if(rev.equals(b[i])){
                 ans[i]="YES";
             }else{
                 ans[i]="NO";
             }
        }
        return ans;
    }
    public static void main(String[] args) {
        String a="abcd";
        String b=a.substring(2,4)+a.substring(0,2);
        System.out.println(b);
    }

}
