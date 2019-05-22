package com.adyen.sample;

import com.adyen.Client;
import com.adyen.model.Address;
import com.adyen.model.Name;
import com.adyen.model.marketpay.*;
import com.adyen.service.Account;

import java.util.HashMap;

public class CreateAccountHolderCreateIndividualFull {

  public static void main(String[] args) throws Exception {
    Client client = AdyenClient.initClient();
    Account account = new Account(client);
    // Create Account Holder Request
    CreateAccountHolderRequest createAccountHolderRequest = new CreateAccountHolderRequest();
    createAccountHolderRequest.setAccountHolderCode("TestAccountHolder5");

    // create AccountHolderDetails
    AccountHolderDetails accountHolderDetails = new AccountHolderDetails();

    // Add address to AccountHolderDetails
    Address address = new Address();
    address.setCity("Amsterdam");
    address.setCountry("US");
    address.houseNumberOrName("10");
    address.postalCode("12345");
    address.stateOrProvince("NH");
    address.setStreet("Teststreet 1");
    accountHolderDetails.setAddress(address);

    // set BankAccountDetails
    BankAccountDetail bankAccountDetail = new BankAccountDetail();
    bankAccountDetail.setAccountNumber("12345678");
    bankAccountDetail.setBankAccountName("baName");
    bankAccountDetail.setBankBicSwift("BicSUSft");
    bankAccountDetail.setBankCity("city");
    bankAccountDetail.setBankName("bankName");
    bankAccountDetail.setBranchCode("122105155");
    bankAccountDetail.setCountryCode("US");
    bankAccountDetail.setCurrencyCode("EUR");
//    bankAccountDetail.setIban("iban");
    bankAccountDetail.setOwnerCity("ownerCity");
    bankAccountDetail.setOwnerCountryCode("BE");
    bankAccountDetail.setOwnerDateOfBirth("1980-01-01"); // set datetime element
    bankAccountDetail.setOwnerHouseNumberOrName("houseNumberOrName");
    bankAccountDetail.setOwnerName("ownerName");
    bankAccountDetail.setOwnerNationality("AD");
    bankAccountDetail.setOwnerPostalCode("ownerPostalCode");
    bankAccountDetail.setOwnerState("ownerState");
    bankAccountDetail.setOwnerStreet("ownerStreet");
    bankAccountDetail.setPrimaryAccount(true);
    bankAccountDetail.setTaxId("bankTaxId");
    accountHolderDetails.addBankAccountDetail(bankAccountDetail);
    accountHolderDetails.setEmail("test@adyen.com");

    // set individualDetails
    IndividualDetails individualDetails = new IndividualDetails();

    // set name inside individualDetails
    Name name = new Name();
    name.firstName("First name");
    name.lastName("Last Name");
    name.gender(Name.GenderEnum.MALE);
    individualDetails.setName(name);

    // set personal data inside individualDetails
    PersonalData personalData = new PersonalData();
    personalData.dateOfBirth("1970-01-01");
    personalData.setIdNumber("1234567890");
    personalData.setNationality("NL");
    individualDetails.setPersonalData(personalData);

    // attach individualDetails into accountHolderDetails
    accountHolderDetails.setIndividualDetails(individualDetails);
    accountHolderDetails.setMerchantCategoryCode("7999");

    // create phone number
    PhoneNumber phoneNumber = new PhoneNumber();
    phoneNumber.setPhoneCountryCode("NL");
    phoneNumber.setPhoneNumber("0612345678");
    phoneNumber.setPhoneType(PhoneNumber.PhoneTypeEnum.MOBILE);
    accountHolderDetails.setPhoneNumber(phoneNumber);
    accountHolderDetails.setWebAddress("http://www.adyen.com");

    HashMap<String, String> metadata = new HashMap<String, String>();
    metadata.put("metaKey", "metaVal");
    accountHolderDetails.setMetadata(metadata);
    // set accountHolderDetails
    createAccountHolderRequest.setAccountHolderDetails(accountHolderDetails);
    createAccountHolderRequest.setCreateDefaultAccount(true);
    createAccountHolderRequest.setLegalEntity(CreateAccountHolderRequest.LegalEntityEnum.INDIVIDUAL);
//    createAccountHolderRequest.setProcessingTier(1);

    // createAccountHolder
    System.out.println(createAccountHolderRequest.toString());
    CreateAccountHolderResponse createAccountHolderResponse = account.createAccountHolder(createAccountHolderRequest);

    AdyenClient.printResponse(createAccountHolderResponse);
  }
}
