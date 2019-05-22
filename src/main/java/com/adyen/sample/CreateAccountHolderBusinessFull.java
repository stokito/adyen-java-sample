package com.adyen.sample;

import com.adyen.Client;
import com.adyen.model.Name;
import com.adyen.model.marketpay.*;
import com.adyen.service.Account;

import java.util.Arrays;
import java.util.List;

public class CreateAccountHolderBusinessFull {

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
    ShareholderContact shareholder =  new ShareholderContact();
    Name shareholderName = new Name();
    shareholderName.setFirstName("FirstName");
    shareholderName.setLastName("LastName");
    shareholderName.setGender(Name.GenderEnum.UNKNOWN);
    shareholder.setName(shareholderName);
    shareholder.setEmail("shareholder@example.com");
    List<ShareholderContact> shareholders = Arrays.asList(shareholder);
    businessDetails.setShareholders(shareholders);

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
