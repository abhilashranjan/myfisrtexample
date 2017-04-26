package demo.myfirstexample.guava;

import java.util.concurrent.*;

/**
 * Created by anya on 25/4/17.
 */
public class ScheduleExecutorDemo{

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        schedule();
        scheduleAtFixedDelay();
    }

    private static void schedule() throws InterruptedException, ExecutionException {
        ScheduledExecutorService scheduledExecutorService =
                Executors.newScheduledThreadPool(5);

        ScheduledFuture scheduledFuture =
                scheduledExecutorService.schedule(new Callable() {
                                                      public Object call() throws Exception {
                                                          System.out.println("Executed!");
                                                          return "Called!";
                                                      }
                                                  },
                        5,
                        TimeUnit.SECONDS);

        System.out.println("result = " + scheduledFuture.get());

        scheduledExecutorService.shutdown();
    }

    private static void scheduleAtFixedDelay() throws InterruptedException, ExecutionException {
        ScheduledExecutorService scheduledExecutorService =
                Executors.newScheduledThreadPool(5);

        ScheduledFuture scheduledFuture =
                scheduledExecutorService.scheduleWithFixedDelay(new Runnable() {

                                                                    public void run() {
                                                                        System.out.println("Delay Execution");
                                                                    }
                                                                },
                        5,5,
                        TimeUnit.SECONDS);

        System.out.println("result = " + scheduledFuture.get());

        scheduledExecutorService.shutdown();
    }
}
