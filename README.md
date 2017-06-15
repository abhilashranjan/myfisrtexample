## References in JAVA 

There are four kind of refernce present in java 
   1. [Strong reference](#strong-reference)
   2. [Weak Reference](#weak-reference)
   3. [Soft Reference](#soft-reference)
   4. [Phantom Reference](#phantom-reference)
 
 #### Strong Reference 
 
  Strong Reference is most simple as we use it in our day to day programming life e.g. in the code, String s = "abc" , reference variable s has strong reference to String object "abc". Any object which has Strong reference attached to it is not eligible for garbage collection.
  
  
   #### Weak Reference
  
  Unlike Soft References, Weak References can be reclaimed by the JVM during a GC cycle, even though there’s enough free memory available.  Our first example on weaker reference models was based on Weak References. As long as GC does not occur, we can retrieve a strong reference out of a weak reference by calling the ref.get() method.
  ```java
          import java.lang.ref.WeakReference;
            
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

```
  
  #### Soft Reference 
  According to the Java API Specification, the JVM implementations are encouraged not to clear out a soft reference if the JVM has enough memory. That is, if free heap space is available, chances are that a soft reference will not be freed during a garbage collection cycle (so it survives from GC).  However, before throwing an OutOfMemoryError, JVM will attempt to reclaim memory by releasing instances that are softly reachable.  This makes Soft References ideal for implementing memory sensitive caches (as in our example problem).
  
  Consider the following example.
  ```java
public class TestSoftRef {
      public static void main(String[] args) {
  
          // Initial Strong Ref
          Object obj = new Object();  
          System.out.println("Instance : " + obj);
          
         // Make a Soft Reference on obj
          SoftReference<Object> softReference = 
                      new SoftReference<Object>(obj); 
  
          // Make obj eligible for GC !
          obj = null;     
          
          System.gc();    // Run GC
  
          // should be null if GC collected
          System.out.println("Instance : " + softReference.get());
      }
  }
  
```
  ```text
And the output will be…
  
  Instance : java.lang.Object@de6ced
  Instance : java.lang.Object@de6ced
```

   
  #### Phantom Reference 
   
   Phantom references are the weakest form of referencing. Instances that are referred via a phantom reference cannot be accessed directly using a get() method (it always returns null), as in case of Soft / Weak references.
   
   Instead, we need to rely on Reference Queues to make use of Phantom References. We will take a look at reference queues in a while. One use case of Phantom references is to keep track of active references with in an application, and to know when those instances will be garbage collected. If we use strong references, then the instance will not be eligible for GC due to the strong reference we maintain. Instead, we could rely on a phantom reference with the support of a reference queue to handle the situation. An example of Phantom References is provided under Reference Queues below.
   
   #### Reference Queues 
   
   ReferenceQueue is the mechanism provided by the JVM to be notified when a referenced instance is about to be garbage collected. Reference Queues can be used with all of the reference types by passing it to the constructor. When creating a PhantomReference, it is a must to provide a Reference Queue.
   
   The use of reference queue is as follows.
   ```java
   public class TestPhantomRefQueue {
   
      public static void main(String[] args) 
   			throws InterruptedException {
   
         Object obj = new Object();
         final ReferenceQueue queue = new ReferenceQueue();
   
         PhantomReference pRef = 
   		new PhantomReference(obj,queue);
   
         obj = null;
   
         new Thread(new Runnable() {
            public void run() {
              try {
                System.out.println("Awaiting for GC");
   
     	     // This will block till it is GCd
                PhantomReference pRef = 
   		(PhantomReference) queue.remove(); 
   
                System.out.println("Referenced GC'd");
   
               } catch (InterruptedException e) {
                 e.printStackTrace();
               }
             }
           }).start();
   
           // Wait for 2nd thread to start
           Thread.sleep(2000);
   
           System.out.println("Invoking GC");
           System.gc();       
       }
   }

```
```text
   The output would be
   
   Awaiting for GC
   Invoking GC
   Referenced GC'd


```
       
