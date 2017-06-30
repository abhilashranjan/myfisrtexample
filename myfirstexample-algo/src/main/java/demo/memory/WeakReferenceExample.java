package demo.memory;

import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;

/**
 * Created by anya on 15/6/17.
 */
public class WeakReferenceExample {
    public static void main(String[] args) {
        Object obj= new Object();
        System.out.println("OBJECT BEFORE "+obj);
        WeakReference<Object> sfr= new WeakReference<Object>(obj);
        System.out.println("OBJECT "+obj);
        Object weekRf=sfr.get();

        System.out.println(" STRONG REF "+weekRf);
        weekRf=null;
        System.out.println("INSTANCE");

    }
}
