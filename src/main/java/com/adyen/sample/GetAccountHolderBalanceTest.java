package com.adyen.sample;

import com.adyen.Client;
import com.adyen.model.marketpay.AccountHolderBalanceRequest;
import com.adyen.model.marketpay.AccountHolderBalanceResponse;
import com.adyen.service.Fund;

public class GetAccountHolderBalanceTest {

  public static void main(String[] args) throws Exception {
    Client client = AdyenClient.initClient();
    Fund fund = new Fund(client);
    AccountHolderBalanceRequest accountHolderBalanceRequest = new AccountHolderBalanceRequest();
    accountHolderBalanceRequest.setAccountHolderCode("TestAccountHolder781664");
    AccountHolderBalanceResponse accountHolderBalanceResponse = fund.accountHolderBalance(accountHolderBalanceRequest);
    System.out.println(accountHolderBalanceResponse);
  }
}
