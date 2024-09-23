package Task_1.Behaviral_DP;

import java.util.ArrayList;
import java.util.List;

// Observer Interface
interface Observer {
    void update(float temperature, float humidity);
}

// Subject Interface
interface WeatherStation {
    void registerObserver(Observer o);
    void removeObserver(Observer o);
    void notifyObservers();
}

// Concrete Subject
class WeatherData implements WeatherStation {
    private List<Observer> observers;
    private float temperature;
    private float humidity;

    public WeatherData() {
        observers = new ArrayList<>();
    }

    public void setMeasurements(float temperature, float humidity) {
        this.temperature = temperature;
        this.humidity = humidity;
        notifyObservers();
    }

    @Override
    public void registerObserver(Observer o) {
        observers.add(o);
    }

    @Override
    public void removeObserver(Observer o) {
        observers.remove(o);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(temperature, humidity);
        }
    }
}

// Concrete Observers
class CurrentConditionsDisplay implements Observer {
    @Override
    public void update(float temperature, float humidity) {
        System.out.println("Current conditions: " + temperature + "°C and " + humidity + "% humidity");
    }
}

class ForecastDisplay implements Observer {
    @Override
    public void update(float temperature, float humidity) {
        System.out.println("Forecast display: Temp = " + temperature + "°C, Humidity = " + humidity + "%");
    }
}

public class ObserverPattern1 {
    public static void main(String[] args) {
        WeatherData weatherData = new WeatherData();
        Observer currentDisplay = new CurrentConditionsDisplay();
        Observer forecastDisplay = new ForecastDisplay();

        weatherData.registerObserver(currentDisplay);
        weatherData.registerObserver(forecastDisplay);

        weatherData.setMeasurements(30, 65);
        weatherData.setMeasurements(28, 70);
    }
}
