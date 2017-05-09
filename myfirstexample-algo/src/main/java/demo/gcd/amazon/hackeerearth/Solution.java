import java.util.*;
class Main
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNextInt())
        {
            int intInput = sc.nextInt();
            if(intInput == 42) break;
            System.out.println(intInput);
        }
    }
}