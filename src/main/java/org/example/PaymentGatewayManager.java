package org.example;

public class PaymentGatewayManager {

    double rate=0;
    // Method to process payment
    public boolean processPayment(double amount, String cardNumber, String expiryDate, String cvv) {
        if (!isValidAmount(amount)) {

            // Return false if the amount is invalid
            return false;
        }

        if (!isValidCardNumber(cardNumber) || !isValidExpiryDate(expiryDate) || !isValidCVV(cvv)) {

            // Return false if any card information is invalid
            return false;
        }

        // Create payment processing logic
        boolean paymentSuccess = paymentProcessing(amount, cardNumber, expiryDate, cvv);

        return paymentSuccess;
    }

    // Method to simulate payment processing
    private boolean paymentProcessing(double amount, String cardNumber, String expiryDate, String cvv) {
        //Let's assume payment is successful
        return true;
    }

    // Method to validate the amount
    private boolean isValidAmount(double amount) {

        // the rate amount could be adjusted by the organization
        return amount > rate;
    }

    // Method to validate card number format
    private boolean isValidCardNumber(String cardNumber) {

        // It should have  16 digits
        return cardNumber.matches("\\d{16}");
    }

    // Method to validate expiry date format
    private boolean isValidExpiryDate(String expiryDate) {
        // Validate expiry date format MM/YY
        return expiryDate.matches("\\d{2}/\\d{2}");
    }

    // Method to validate CVV format
    private boolean isValidCVV(String cvv) {
        // Validate CVV format 3 or 4 digits
        return cvv.matches("\\d{3,4}");
    }
}

