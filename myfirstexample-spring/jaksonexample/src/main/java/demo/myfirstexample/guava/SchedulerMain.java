package demo.myfirstexample.guava;

import java.util.Timer;

/**
 *
 * @author Dhinakaran P.
 */

//Main class
public class SchedulerMain {
    public static void main(String args[]) throws InterruptedException {

		Timer time = new Timer(); // Instantiate Timer Object
		ScheduledTask st = new ScheduledTask(); // Instantiate SheduledTask class
		time.schedule(st, 0, 3000); // Create Repetitively task for every 1 secs
		CacheDemo cacheDemo= new CacheDemo();
		//for demo only.
		for (int i = 0; i <= 5; i++) {
			System.out.println("Execution in Main Thread...." + i);
			cacheDemo.getEmployee(cacheDemo);
			Thread.sleep(4000);
			if (i == 5) {
				System.out.println("Application Terminates");
				System.exit(0);
			}
		}
	}
}