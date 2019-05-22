package com.adyen.sample;

import com.adyen.Client;
import com.adyen.model.Name;
import com.adyen.model.marketpay.AccountHolderDetails;
import com.adyen.model.marketpay.CreateAccountHolderRequest;
import com.adyen.model.marketpay.CreateAccountHolderResponse;
import com.adyen.model.marketpay.IndividualDetails;
import com.adyen.service.Account;

public class CreateAccountHolderCreateIndividual {

  public static void main(String[] args) throws Exception {
    Client client = AdyenClient.initClient();

    Account account = new Account(client);
    // Create Account Holder Request
    CreateAccountHolderRequest createAccountHolderRequest = new CreateAccountHolderRequest();
    createAccountHolderRequest.setAccountHolderCode("TestAccountHolder5");

    // create AccountHolderDetails
    AccountHolderDetails accountHolderDetails = new AccountHolderDetails();
    accountHolderDetails.setEmail("test@adyen.com");

    // set individualDetails
    IndividualDetails individualDetails = new IndividualDetails();
    // set name inside individualDetails
    Name name = new Name();
    name.firstName("First name");
    name.lastName("Last Name");
    name.gender(Name.GenderEnum.MALE);
    individualDetails.setName(name);
    // attach individualDetails into accountHolderDetails
    accountHolderDetails.setIndividualDetails(individualDetails);

    // set accountHolderDetails
    createAccountHolderRequest.setAccountHolderDetails(accountHolderDetails);
    createAccountHolderRequest.setCreateDefaultAccount(true);
    createAccountHolderRequest.setLegalEntity(CreateAccountHolderRequest.LegalEntityEnum.INDIVIDUAL);

    // createAccountHolder
    System.out.println(createAccountHolderRequest.toString());
    CreateAccountHolderResponse createAccountHolderResponse = account.createAccountHolder(createAccountHolderRequest);

    AdyenClient.printResponse(createAccountHolderResponse);
  }
}
