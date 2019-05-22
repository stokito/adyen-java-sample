package com.adyen.sample;

import com.adyen.Client;
import com.adyen.model.checkout.PaymentMethodsRequest;
import com.adyen.model.checkout.PaymentMethodsResponse;
import com.adyen.service.Checkout;
import com.adyen.service.exception.ApiException;
import java.io.IOException;

public class CheckoutTest {

  public static void main(String[] args) throws IOException, ApiException {
    Client client = AdyenClient.initClient();
    Checkout checkout = new Checkout(client);
    PaymentMethodsRequest paymentMethodsRequest = new PaymentMethodsRequest();
    paymentMethodsRequest.setMerchantAccount("163309413");
    PaymentMethodsResponse paymentMethodsResponse = checkout.paymentMethods(paymentMethodsRequest);
    System.out.println(paymentMethodsResponse);
  }
}
