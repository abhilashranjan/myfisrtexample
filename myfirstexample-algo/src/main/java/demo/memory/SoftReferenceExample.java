package demo.memory;

import java.lang.ref.SoftReference;

/**
 * Created by anya on 15/6/17.
 */
public class SoftReferenceExample {
    public static void main(String[] args) {
        Object obj= new Object();
        System.out.println("OBJECT BEFORE "+obj);
        SoftReference<Object> sfr= new SoftReference<Object>(obj);
        System.gc();
        System.out.println("OBJECT "+obj);
        System.out.println(" SOFT REF "+sfr.get());
    }
}
