package Task_1.Structural_DP;

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

// Another Concrete Decorator
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
        Coffee myCoffee = new BasicCoffee();
        System.out.println(myCoffee.getDescription() + " $" + myCoffee.cost());

        myCoffee = new Milk(myCoffee);
        System.out.println(myCoffee.getDescription() + " $" + myCoffee.cost());

        myCoffee = new Sugar(myCoffee);
        System.out.println(myCoffee.getDescription() + " $" + myCoffee.cost());

        myCoffee = new WhippedCream(myCoffee);
        System.out.println(myCoffee.getDescription() + " $" + myCoffee.cost());
    }
}
