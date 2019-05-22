package com.adyen.sample;

import static com.adyen.model.marketpay.CreateAccountRequest.PayoutScheduleEnum.MONTHLY;
import com.adyen.Client;
import com.adyen.model.marketpay.CreateAccountRequest;
import com.adyen.model.marketpay.CreateAccountResponse;
import com.adyen.service.Account;

public class SubMerchantAccount {

  public static void main(String[] args) throws Exception {
    Client client = AdyenClient.initClient();
    Account account = new Account(client);
    CreateAccountRequest createAccountRequest = new CreateAccountRequest();
    createAccountRequest.setAccountHolderCode("TestAccountHolder781664");
    createAccountRequest.setDescription("merchantId");
    createAccountRequest.setPayoutSchedule(MONTHLY);
    CreateAccountResponse createAccountResponse = account.createAccount(createAccountRequest);
    System.out.println(createAccountResponse);
  }
}
