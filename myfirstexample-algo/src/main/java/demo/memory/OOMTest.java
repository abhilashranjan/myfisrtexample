package demo.memory;

/**
 * Created by anya on 15/6/17.
 */
public class OOMTest {
    public static void main(String[] args) {
        System.out.println("OOM Test ");
        long[][] ary = new long[Integer.MAX_VALUE][Integer.MAX_VALUE];
        System.out.println(ary.length);
    }
}
