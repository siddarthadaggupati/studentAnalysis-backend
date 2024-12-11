package com.example.demo.model;

import com.razorpay.Order;
import com.razorpay.RazorpayClient;
import com.razorpay.RazorpayException;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class RazorpayService {

    private static final String RAZORPAY_KEY = "rzp_test_06GeKary0jkcOO";
    private static final String RAZORPAY_SECRET = "DsqFZoH2con0fG6ucBH7XtaP";

    public String createOrder(double amount, String currency) throws RazorpayException {
        // Initialize Razorpay client
        RazorpayClient client = new RazorpayClient(RAZORPAY_KEY, RAZORPAY_SECRET);

        // Create order options
        Map<String, Object> options = new HashMap<>();
        options.put("amount", (int) (amount * 100)); // Convert to paisa
        options.put("currency", currency);
        options.put("receipt", "txn_123456");
        options.put("payment_capture", 1); // Auto-capture

        // Convert Map to JSONObject
        JSONObject orderRequest = new JSONObject(options);

        // Create order
        Order order = client.orders.create(orderRequest);

        // Return order details as String
        return order.toString();
    }
}
