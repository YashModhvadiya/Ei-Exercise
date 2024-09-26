package Task_1.Creational_DP;

import java.util.Scanner;

// Singleton Class
class Logger {
    private static Logger instance;

    private Logger() {
        // Private constructor prevents instantiation
    }

    public static Logger getInstance() {
        if (instance == null) {
            instance = new Logger();
        }
        return instance;
    }

    public void log(String message) {
        System.out.println("Log: " + message);
    }
}

public class SingletonPattern {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Logger logger = Logger.getInstance();

        while (true) {
            System.out.println("Enter a message to log (type 'exit' to quit): ");
            String input = scanner.nextLine();

            if (input.equalsIgnoreCase("exit")) {
                System.out.println("Exiting the logger.");
                break;
            }

            logger.log(input);
        }

        // Demonstrating that anotherLogger is the same instance
        Logger anotherLogger = Logger.getInstance();
        anotherLogger.log("This log is from another logger instance.");

        System.out.println("Are both logger instances the same? " + (logger == anotherLogger));  // true

        scanner.close();
    }
}
