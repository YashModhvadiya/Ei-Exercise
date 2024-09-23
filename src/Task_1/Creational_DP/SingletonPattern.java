package Task_1.Creational_DP;

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
        Logger logger = Logger.getInstance();
        logger.log("Application started.");

        Logger anotherLogger = Logger.getInstance();
        anotherLogger.log("Application running.");

        // Both loggers are the same instance
        System.out.println(logger == anotherLogger);  // true
    }
}
