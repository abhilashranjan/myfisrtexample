package demo.thread.example;

/**
 * Created by anya on 1/8/17.
 */
public class EvenOdd {
    static boolean isOdd = true;

    public static void main(String[] args) {
        EvenOdd evenOdd = new EvenOdd();

        Thread odd = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (evenOdd) {
                    for (int i = 1; i < 10; i = i + 2) {
                        try {
                            evenOdd.printOdd(i);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        });

        Thread even = new Thread(new Runnable() {

            @Override
            public void run() {
                synchronized (evenOdd) {
                    for (int i = 2; i < 10; i = i + 2) {
                        try {
                            evenOdd.printEven(i);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        });

        odd.start();
        even.start();
    }


    public void printEven(int number) throws InterruptedException {
        synchronized (this) {
            if (isOdd)
                wait();

            System.out.println(number);
        }
        isOdd = true;
        notify();
    }


    public void printOdd(int number) throws InterruptedException {
        synchronized (this) {
            if (!isOdd)
                wait();
            System.out.println(number);
        }
        isOdd = false;
        notify();
    }
}