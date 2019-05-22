package com.adyen.sample;

import com.adyen.Client;
import com.adyen.model.marketpay.*;
import com.adyen.service.Account;

public class CreateAccountHolderBusiness {

  public static void main(String[] args) throws Exception {
    Client client = AdyenClient.initClient();

    Account account = new Account(client);
    // Create Account Holder Request
    CreateAccountHolderRequest createAccountHolderRequest = new CreateAccountHolderRequest();
    createAccountHolderRequest.setAccountHolderCode("TestAccountHolder6");

    // create AccountHolderDetails
    AccountHolderDetails accountHolderDetails = new AccountHolderDetails();
    accountHolderDetails.setEmail("test@example.com");

    BusinessDetails businessDetails = new BusinessDetails();
    businessDetails.setDoingBusinessAs("Real Good Restaurant");
    businessDetails.setLegalBusinessName("Real Good Restaurant Inc.");
    accountHolderDetails.setBusinessDetails(businessDetails);

    // set accountHolderDetails
    createAccountHolderRequest.setAccountHolderDetails(accountHolderDetails);
    createAccountHolderRequest.setCreateDefaultAccount(true);
    createAccountHolderRequest.setLegalEntity(CreateAccountHolderRequest.LegalEntityEnum.BUSINESS);

    // createAccountHolder
    System.out.println(createAccountHolderRequest.toString());
    CreateAccountHolderResponse createAccountHolderResponse = account.createAccountHolder(createAccountHolderRequest);

    AdyenClient.printResponse(createAccountHolderResponse);
  }

}
