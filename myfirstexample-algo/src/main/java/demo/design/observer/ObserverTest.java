package demo.design.observer;

import java.util.Observable;
import java.util.Observer;


class MySubject extends Observable{
    public synchronized void setChange(){
        super.setChanged();
    }
}

class MyObserver1 implements Observer {
    @Override
    public void update(Observable arg0, Object arg1) {
        System.out.println("Observer 1: " + arg1.toString());
    }

}

class MyObserver2 implements Observer{
    @Override
    public void update(Observable arg0, Object arg1) {
        System.out.println("Observer 2: " + arg1.toString());
    }
}

public class ObserverTest{

    public static void main(String[] args) {
        MySubject subject = new MySubject();

        MyObserver1 l1 = new MyObserver1();
        MyObserver2 l2 = new MyObserver2();

        subject.addObserver(l1);
        subject.addObserver(l2);

        // change the subject
        subject.setChange();

        Object arg = "Subject has been changed";
        subject.notifyObservers(arg);
    }
}
