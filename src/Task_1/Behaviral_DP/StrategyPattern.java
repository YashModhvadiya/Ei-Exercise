package Task_1.Behaviral_DP;

// Strategy Interface
interface PaymentStrategy {
    void pay(int amount);
}

// Concrete Strategy for CreditCard
class CreditCardPayment implements PaymentStrategy {
    @Override
    public void pay(int amount) {
        System.out.println("Paid " + amount + " using Credit Card.");
    }
}

// Concrete Strategy for PayPal
class PayPalPayment implements PaymentStrategy {
    @Override
    public void pay(int amount) {
        System.out.println("Paid " + amount + " using PayPal.");
    }
}

// Context Class
class ShoppingCart {
    private PaymentStrategy paymentStrategy;

    public void setPaymentStrategy(PaymentStrategy paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }

    public void checkout(int amount) {
        paymentStrategy.pay(amount);
    }
}

public class StrategyPattern {
    public static void main(String[] args) {
        ShoppingCart cart = new ShoppingCart();

        // Paying by Credit Card
        cart.setPaymentStrategy(new CreditCardPayment());
        cart.checkout(100);

        // Paying by PayPal
        cart.setPaymentStrategy(new PayPalPayment());
        cart.checkout(250);
    }
}
