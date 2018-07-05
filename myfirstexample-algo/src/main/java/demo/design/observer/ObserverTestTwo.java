package demo.design.observer;

import java.util.ArrayList;
import java.util.List;

interface Observer{
    public void update(float interest);
}

class NewsPaper implements Observer{

    @Override
    public void update(float interest) {
        System.out.println("Update interest rate in newspaper "+interest);
    }
}


class Internet implements Observer{

    @Override
    public void update(float interest) {
        System.out.println("Update interest rate in internet "+interest);
    }
}


interface Subject{
    public void registerObserver(Observer observer);

    public void removeObserver(Observer observer);

    public void notifyObservers();

}

class Loan implements Subject{
    float interest;
    String bank;
    String type;

    public Loan(float interest, String bank, String type) {
        this.interest = interest;
        this.bank = bank;
        this.type = type;
    }

    public void setInterest(float interest) {
        this.interest = interest;
    }

    public void setBank(String bank) {
        this.bank = bank;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<Observer> observers= new ArrayList<>();
    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        observers.stream().forEach((Observer o)->{
            System.out.println("interest rate updated"+interest+" for "+o.getClass().getName());
            o.update(interest);
        });
    }
}


public class ObserverTestTwo {
    public static void main(String[] args) {
        NewsPaper newsPaper= new NewsPaper();
        Internet internet= new Internet();
        Loan loan= new Loan(8.5f,"idbi", "home-loan");
        loan.registerObserver(newsPaper);
        loan.registerObserver(internet);
        loan.notifyObservers();
        loan.setInterest(8.0f);
        loan.notifyObservers();
    }
}
