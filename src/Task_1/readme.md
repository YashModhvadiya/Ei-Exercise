# Task 1
---

# Design Patterns in Java

This repository contains examples of various design patterns implemented in Java. Each design pattern demonstrates a different approach to software design and provides flexibility and reusability. Below is a brief overview of each design pattern included in this repository and how to run the examples.

## 1. **Observer Pattern** (`ObserverPattern1.java`)
- **Type**: Behavioral
- The Observer Pattern allows objects to observe the state of another object (subject). When the subject's state changes, all registered observers are notified.
- **How to Run**:
    - Instantiate `WeatherData` and register observers (e.g., `CurrentConditionsDisplay` and `ForecastDisplay`).
    - Simulate weather data updates using `setMeasurements()`.

## 2. **Strategy Pattern** (`StrategyPattern.java`)
- **Type**: Behavioral
- The Strategy Pattern allows dynamic selection of algorithms (or strategies) at runtime. Different payment methods (credit card, PayPal) can be selected.
- **How to Run**:
    - Create a `ShoppingCart`, set a payment strategy (`CreditCardPayment` or `PayPalPayment`), and call `checkout()`.

## 3. **Factory Method Pattern** (`FactoryMethodPattern.java`)
- **Type**: Creational
- The Factory Method Pattern allows the creation of objects without exposing the creation logic to the client. This example demonstrates a vehicle factory that creates either a car or a bike.
- **How to Run**:
    - Use the `VehicleFactory.getVehicle()` method to create either a car or bike and call `drive()` on the returned object.

## 4. **Singleton Pattern** (`SingletonPattern.java`)
- **Type**: Creational
- The Singleton Pattern ensures that only one instance of a class is created. This example shows a logger that can only have a single instance.
- **How to Run**:
    - Retrieve the `Logger` instance using `Logger.getInstance()` and log messages using `log()`. Verify that both loggers are the same instance.

## 5. **Adapter Pattern** (`AdapterPattern.java`)
- **Type**: Structural
- The Adapter Pattern allows incompatible interfaces to work together. Here, `AudioPlayer` uses `MediaAdapter` to play different media formats (MP3, MP4, VLC).
- **How to Run**:
    - Create an `AudioPlayer` and call `play()` with different file formats (MP3, MP4, VLC) to observe how the adapter bridges incompatible types.

## 6. **Decorator Pattern** (`DecoratorPattern.java`)
- **Type**: Structural
- The Decorator Pattern allows adding responsibilities to objects dynamically. This example demonstrates adding different ingredients (milk, sugar, whipped cream) to a coffee.
- **How to Run**:
    - Start with a `BasicCoffee`, then dynamically add decorations (e.g., `Milk`, `Sugar`, `WhippedCream`) by wrapping the original object.

---

## How to Run the Programs
1. Clone this repository.
2. Open the project in an IDE (e.g., IntelliJ IDEA).
3. Run each pattern’s main class as a Java application:
    - Observer: `ObserverPattern1.java`
    - Strategy: `StrategyPattern.java`
    - Factory Method: `FactoryMethodPattern.java`
    - Singleton: `SingletonPattern.java`
    - Adapter: `AdapterPattern.java`
    - Decorator: `DecoratorPattern.java`

## Requirements
- Java 8 or higher
- An IDE or Java compiler (e.g., IntelliJ IDEA, Eclipse)

---

