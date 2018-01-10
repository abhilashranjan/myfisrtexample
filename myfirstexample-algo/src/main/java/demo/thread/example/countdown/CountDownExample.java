package demo.thread.example.countdown;

import java.util.concurrent.CountDownLatch;

/**
 * Created by anya on 2/8/17.
 */
public class CountDownExample {


    public static void main(String[] args) {
        CountDownLatch latch= new CountDownLatch(2);
        Thread odd= new Thread(new Odd(latch));
        Thread even= new Thread(new Even(latch));
        odd.start();
        even.start();
        try {
            latch.await();
            System.out.println("All done");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    static class Odd implements Runnable{
        CountDownLatch latch;

        public Odd(CountDownLatch latch) {
            this.latch = latch;
        }

        @Override
        public void run() {
            for (int i=1; i<10; i=i+2){
                System.out.println(i);
            }
            latch.countDown();
        }
    }

    static class Even implements Runnable{

        CountDownLatch latch;

        public Even(CountDownLatch latch) {
            this.latch = latch;
        }

        @Override
        public void run() {
            for (int i=2; i<10; i=i+2){
                System.out.println(i);
            }
            latch.countDown();
        }
    }
}
