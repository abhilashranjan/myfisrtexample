package demo.design.observer1;

/**
 * Created by anya on 17/1/18.
 */
public interface WeatherSubject {
    void addObserver(WeatherObserver observer);
    void removeObeserver(WeatherObserver observer);
    void doNotify();
}
