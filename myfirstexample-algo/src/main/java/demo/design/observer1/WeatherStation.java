package demo.design.observer1;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by anya on 17/1/18.
 */
public class WeatherStation implements WeatherSubject {
    Set<WeatherObserver>  weatherObservers;



    int temperature;

    public WeatherStation(int temperature) {
        weatherObservers= new HashSet<>();
        this.temperature = temperature;
    }

    @Override
    public void addObserver(WeatherObserver observer) {
        weatherObservers.add(observer);
    }

    @Override
    public void removeObeserver(WeatherObserver observer) {
        weatherObservers.remove(observer);
    }

    @Override
    public void doNotify() {
        for(WeatherObserver observer:weatherObservers){
            observer.doUpdate(temperature);
        }
    }

    public void setTemperature(int newTemperature) {
        System.out.println("\nWeather station setting temperature to " + newTemperature);
        temperature = newTemperature;
        doNotify();
    }

    public int getTemperature() {
        return temperature;
    }

}
