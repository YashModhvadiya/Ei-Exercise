package Task_1.Behaviral_DP;

import java.util.Scanner;

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
        if (paymentStrategy == null) {
            System.out.println("Please select a payment method first!");
        } else {
            paymentStrategy.pay(amount);
        }
    }
}

public class StrategyPattern {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ShoppingCart cart = new ShoppingCart();

        while (true) {
            System.out.println("\nChoose a payment method (Enter '1' for Credit Card, '2' for PayPal, or 'exit' to quit):");
            String input = scanner.nextLine();

            if (input.equalsIgnoreCase("exit")) {
                System.out.println("Exiting the program.");
                break;
            }

            switch (input) {
                case "1":
                    cart.setPaymentStrategy(new CreditCardPayment());
                    break;
                case "2":
                    cart.setPaymentStrategy(new PayPalPayment());
                    break;
                default:
                    System.out.println("Invalid choice. Please enter '1' for Credit Card or '2' for PayPal.");
                    continue;
            }

            // Get the amount to be paid
            System.out.print("Enter the amount to pay: ");
            String amountInput = scanner.nextLine();
            try {
                int amount = Integer.parseInt(amountInput);
                cart.checkout(amount);
            } catch (NumberFormatException e) {
                System.out.println("Invalid amount. Please enter a valid number.");
            }
        }

        scanner.close();
    }
}
