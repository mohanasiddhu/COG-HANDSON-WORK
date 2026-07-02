package com.spring.di.enhanced.beans;

import com.spring.di.enhanced.services.PaymentService;

/**
 * ShoppingCart with Setter Injection
 *
 * Setter injection characteristics: 1. Dependencies are optional (can be null)
 * 2. Dependencies can be changed after construction 3. More flexible but less
 * safe than constructor injection 4. Useful for optional dependencies
 */
public class ShoppingCart {

    // Optional dependency - can be null
    private PaymentService paymentService;
    private String cartId;
    private double cartTotal;

    // Default constructor - no dependencies required
    public ShoppingCart() {
        System.out.println("[ShoppingCart] Created with default constructor");
    }

    // Setter injection - dependencies set after construction
    public void setPaymentService(PaymentService paymentService) {
        this.paymentService = paymentService;
        System.out.println("[ShoppingCart] PaymentService injected via setter");
    }

    public void setCartId(String cartId) {
        this.cartId = cartId;
        System.out.println("[ShoppingCart] CartId set to: " + cartId);
    }

    public void setCartTotal(double cartTotal) {
        this.cartTotal = cartTotal;
        System.out.println("[ShoppingCart] CartTotal set to: $" + cartTotal);
    }

    // Checkout method
    public void checkout(String orderId) {
        System.out.println("\n[ShoppingCart] Checkout initiated");
        System.out.println("  Cart ID: " + cartId);
        System.out.println("  Order ID: " + orderId);
        System.out.println("  Cart Total: $" + cartTotal);

        if (paymentService != null) {
            System.out.println("  Payment Service available");
            paymentService.processPayment(orderId, cartTotal);
        } else {
            System.out.println("  ERROR: Payment Service not available!");
        }
    }

    // Getters
    public PaymentService getPaymentService() {
        return paymentService;
    }

    public String getCartId() {
        return cartId;
    }

    public double getCartTotal() {
        return cartTotal;
    }
}
