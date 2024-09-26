package Task_1.Behaviral_DP;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

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
        Scanner scanner = new Scanner(System.in);
        WeatherData weatherData = new WeatherData();

        Observer currentDisplay = new CurrentConditionsDisplay();
        Observer forecastDisplay = new ForecastDisplay();

        weatherData.registerObserver(currentDisplay);
        weatherData.registerObserver(forecastDisplay);

        while (true) {
            System.out.println("\nEnter the weather data (temperature and humidity) or type 'exit' to quit:");

            // Getting temperature input
            System.out.print("Enter temperature (°C): ");
            String tempInput = scanner.next();
            if (tempInput.equalsIgnoreCase("exit")) break;

            // Getting humidity input
            System.out.print("Enter humidity (%): ");
            String humidityInput = scanner.next();
            if (humidityInput.equalsIgnoreCase("exit")) break;

            // Convert inputs to float and set the measurements
            try {
                float temperature = Float.parseFloat(tempInput);
                float humidity = Float.parseFloat(humidityInput);
                weatherData.setMeasurements(temperature, humidity);
            } catch (NumberFormatException e) {
                System.out.println("Invalid input! Please enter numeric values for temperature and humidity.");
            }
        }
        scanner.close();
        System.out.println("Exiting the program.");
    }
}
