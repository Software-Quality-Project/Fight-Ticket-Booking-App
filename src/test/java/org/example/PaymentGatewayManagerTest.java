package org.example;

import org.junit.Test;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class PaymentGatewayManagerTest {

    @Test
    public void testProcessPayment_Successful() {
        PaymentGatewayManager paymentGateway = new PaymentGatewayManager();
        double amount = 100.00;
        String cardNumber = "1234567890123456";
        String expiryDate = "12/25";
        String cvv = "123";

        boolean paymentSuccess = paymentGateway.processPayment(amount, cardNumber, expiryDate, cvv);

        assertTrue(paymentSuccess);
    }

    @Test
    public void testProcessPayment_InvalidAmount() {
        PaymentGatewayManager paymentGateway = new PaymentGatewayManager();
        double amount = -100.00; // Invalid amount
        String cardNumber = "1234567890123456";
        String expiryDate = "12/25";
        String cvv = "123";

        boolean paymentSuccess = paymentGateway.processPayment(amount, cardNumber, expiryDate, cvv);

        assertFalse(paymentSuccess);
    }

    @Test
    public void testProcessPayment_InvalidCardInformation() {
        PaymentGatewayManager paymentGateway = new PaymentGatewayManager();
        double amount = 100.00;
        String cardNumber = "1234"; // Invalid card number
        String expiryDate = "12/25";
        String cvv = "123";

        boolean paymentSuccess = paymentGateway.processPayment(amount, cardNumber, expiryDate, cvv);

        assertFalse(paymentSuccess);
    }
}
