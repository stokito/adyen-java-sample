package com.adyen.sample;

import com.adyen.Client;
import com.adyen.model.marketpay.GetAccountHolderRequest;
import com.adyen.model.marketpay.GetAccountHolderResponse;
import com.adyen.service.Account;

public class GetAccounts {

  public static void main(String[] args) throws Exception {
    Client client = AdyenClient.initClient();
    Account account = new Account(client);
    GetAccountHolderRequest accountHolderRequest = new GetAccountHolderRequest();
    accountHolderRequest.setAccountHolderCode("TestAccountHolder781664");
    accountHolderRequest.setShowDetails(true);
    GetAccountHolderResponse accountHolder = account.getAccountHolder(accountHolderRequest);
    com.adyen.model.marketpay.Account account1 = accountHolder.getAccounts().get(0);
    account1.getAccountCode();
    System.out.println(accountHolder);
  }
}
