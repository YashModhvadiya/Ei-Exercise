package Task_1.Structural_DP;

import java.util.Scanner;

// Component Interface
interface Coffee {
    String getDescription();
    double cost();
}

// Concrete Component
class BasicCoffee implements Coffee {
    @Override
    public String getDescription() {
        return "Basic Coffee";
    }

    @Override
    public double cost() {
        return 2.00;
    }
}

// Decorator Abstract Class
abstract class CoffeeDecorator implements Coffee {
    protected Coffee coffee;

    public CoffeeDecorator(Coffee coffee) {
        this.coffee = coffee;
    }

    public String getDescription() {
        return coffee.getDescription();
    }

    public double cost() {
        return coffee.cost();
    }
}

// Concrete Decorators
class Milk extends CoffeeDecorator {
    public Milk(Coffee coffee) {
        super(coffee);
    }

    @Override
    public String getDescription() {
        return coffee.getDescription() + ", Milk";
    }

    @Override
    public double cost() {
        return coffee.cost() + 0.50;
    }
}

class Sugar extends CoffeeDecorator {
    public Sugar(Coffee coffee) {
        super(coffee);
    }

    @Override
    public String getDescription() {
        return coffee.getDescription() + ", Sugar";
    }

    @Override
    public double cost() {
        return coffee.cost() + 0.25;
    }
}

class WhippedCream extends CoffeeDecorator {
    public WhippedCream(Coffee coffee) {
        super(coffee);
    }

    @Override
    public String getDescription() {
        return coffee.getDescription() + ", Whipped Cream";
    }

    @Override
    public double cost() {
        return coffee.cost() + 0.75;
    }
}

// Client Code
public class DecoratorPattern {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Coffee myCoffee = new BasicCoffee();

        while (true) {
            System.out.println("Your coffee: " + myCoffee.getDescription() + " $" + myCoffee.cost());
            System.out.println("Choose an add-on: 1) Milk, 2) Sugar, 3) Whipped Cream, 4) Finish");
            int choice = scanner.nextInt();

            if (choice == 1) {
                myCoffee = new Milk(myCoffee);
            } else if (choice == 2) {
                myCoffee = new Sugar(myCoffee);
            } else if (choice == 3) {
                myCoffee = new WhippedCream(myCoffee);
            } else if (choice == 4) {
                System.out.println("Final coffee: " + myCoffee.getDescription() + " $" + myCoffee.cost());
                break;
            } else {
                System.out.println("Invalid choice. Try again.");
            }
        }

        scanner.close();
    }
}
