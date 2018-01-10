package demo.thread.example.cyclicbarrier;

import demo.thread.example.countdown.CountDownExample;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * Created by anya on 2/8/17.
 */
public class CyclicBarrierExample {
    public static void main(String[] args) {
        CyclicBarrier barrier= new CyclicBarrier(2);
        Thread odd= new Thread(new Odd(barrier));
        Thread even= new Thread(new Even(barrier));
        odd.start();
        even.start();


    }

    static class Odd implements Runnable{
        CyclicBarrier barrier;

        public Odd(CyclicBarrier barrier) {
            this.barrier= barrier;
        }

        @Override
        public void run() {
            for (int i=1; i<10; i=i+2){
                System.out.println(i);
            }
            try {
                barrier.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
        }
    }

    static class Even implements Runnable{

        CyclicBarrier barrier;

        public Even(CyclicBarrier barrier) {
            this.barrier = barrier;
        }

        @Override
        public void run() {
            for (int i=2; i<10; i=i+2){
                System.out.println(i);
            }
            try {
                barrier.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
        }
    }
}
