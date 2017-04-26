package demo.myfirstexample.jakson;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * Created by anya on 22/4/17.
 */
public class BlockingQueueExample {
    public static void main(String[] args) throws InterruptedException {
        BlockingQueue<Integer> queue = new ArrayBlockingQueue<Integer>(5);
        for (int i=0; i<5; i++) {
            queue.put(i);
        }
        queue.offer(5);
        System.out.println(queue);


    }

}
