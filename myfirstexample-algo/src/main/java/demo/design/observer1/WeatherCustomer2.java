package demo.design.observer1;

/**
 * Created by anya on 17/1/18.
 */
public class WeatherCustomer2 implements WeatherObserver {
    @Override
    public void doUpdate(int temperature) {
        System.out.println("Weather customer 2 just found out the temperature is:" + temperature);
    }
}
