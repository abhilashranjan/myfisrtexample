package demo;

public class Test {
    public static void main(String[] args) {
        System.out.printf(roll("abz"));
        String element = "az";
        element.length();
//        String s;
//        s = ""+element.charAt(1);
//        int x = Integer.parseInt(s);
    }
public static String roll(String s){
        char a= (char) (s.charAt(0)+1);
        char b= (char) (s.charAt(1)+1);
        char c= (char) (s.charAt(2)+1);
    System.out.println((char)((int) (s.charAt(2))-25));
        String s1=String.valueOf(a)+String.valueOf(b)+String.valueOf(c);
    return s1;
}
}

