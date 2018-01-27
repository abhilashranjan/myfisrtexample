package demo.design.observer1;

/**
 * Created by anya on 17/1/18.
 */
public class Demo {
    public static void main(String[] args) {
        WeatherStation weatherStation= new WeatherStation(33);
        WeatherCustomer1 wc1= new WeatherCustomer1();
        WeatherCustomer2 wc2= new WeatherCustomer2();
        System.out.println("Weather "+weatherStation.getTemperature());
        weatherStation.addObserver(wc1);
        weatherStation.addObserver(wc2);
        weatherStation.setTemperature(34);
        weatherStation.removeObeserver(wc2);
        weatherStation.setTemperature(35);
    }
}
