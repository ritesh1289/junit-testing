package com.billing;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class AppTest {

    private App billing;

    @BeforeEach
    void setUp() {
        billing = new App();
    }

    @Test
    void testCalculateSubtotal() {
        assertEquals(500.0, billing.calculateSubtotal(100, 5));
    }

    @Test
    void testApplyDiscountForMember() {
        assertEquals(900.0, billing.applyDiscount(1000, true));
    }

    @Test
    void testApplyDiscountForNonMember() {
        assertEquals(1000.0, billing.applyDiscount(1000, false));
    }

    @Test
    void testCalculateTax() {
        assertEquals(180.0, billing.calculateTax(1000));
    }

    @Test
    void testGenerateFinalBillForMember() {
        double finalBill = billing.generateFinalBill(100, 10, true);
        assertEquals(1062.0, finalBill);
    }

    @Test
    void testGenerateFinalBillForNonMember() {
        double finalBill = billing.generateFinalBill(100, 10, false);
        assertEquals(1180.0, finalBill);
    }

    @Test
    void testNegativePriceThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> {
            billing.calculateSubtotal(-10, 5);
        });
    }

    @Test
    void testNegativeAmountTaxThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> {
            billing.calculateTax(-100);
        });
    }
}