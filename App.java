package com.billing;

public class App {

    private static final double TAX_RATE = 0.18;
    private static final double DISCOUNT_RATE = 0.10;

    public double calculateSubtotal(double price, int quantity) {
        if (price < 0 || quantity < 0) {
            throw new IllegalArgumentException("Price and quantity must be positive");
        }
        return price * quantity;
    }

    public double applyDiscount(double subtotal, boolean isMember) {
        if (subtotal < 0) {
            throw new IllegalArgumentException("Subtotal cannot be negative");
        }
        if (isMember) {
            return subtotal - (subtotal * DISCOUNT_RATE);
        }
        return subtotal;
    }

    public double calculateTax(double amount) {
        if (amount < 0) {
            throw new IllegalArgumentException("Amount cannot be negative");
        }
        return amount * TAX_RATE;
    }

    public double generateFinalBill(double price, int quantity, boolean isMember) {
        double subtotal = calculateSubtotal(price, quantity);
        double discountedAmount = applyDiscount(subtotal, isMember);
        double tax = calculateTax(discountedAmount);
        return discountedAmount + tax;
    }
}