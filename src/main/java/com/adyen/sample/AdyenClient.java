package com.adyen.sample;

import com.adyen.Client;
import com.adyen.Config;
import com.adyen.enums.Environment;
import com.adyen.model.marketpay.BankAccountDetail;
import com.adyen.model.marketpay.CreateAccountHolderResponse;
import com.adyen.model.marketpay.KYCBankAccountCheckResult;

public class AdyenClient {
  private static String username = "ws_@user_here";
  private static String password = "password_here";
  private static String environment = "TEST";  //Test environment, use LIVE for production

  public static Client initClient() {
    Config config = new Config();
    config.setUsername(username);
    config.setPassword(password);
    config.setEnvironment(Environment.valueOf(environment));
    Client client = new Client(config);
    // this line needed to initialize endpoints based on env
    client.setEnvironment(config.getEnvironment(), null);
    return client;
  }

  public static void printResponse(CreateAccountHolderResponse createAccountHolderResponse) {
    System.out.println("Response:");
    System.out.println(createAccountHolderResponse.toString());
    if (!createAccountHolderResponse.getInvalidFields().isEmpty()) {
      System.err.println("Error:");
      System.err.println(createAccountHolderResponse.getInvalidFields());
    } else {
      System.out.println("Response fields:");
      System.out.println(createAccountHolderResponse.getAccountCode());
      for (BankAccountDetail bankAccountDetail : createAccountHolderResponse.getAccountHolderDetails().getBankAccountDetails()) {
        System.out.println(bankAccountDetail.getBankAccountUUID());
      }
      for (KYCBankAccountCheckResult bankAccount : createAccountHolderResponse.getVerification().getBankAccounts()) {
        System.out.println(bankAccount.getChecks().get(0).getCheckType());
        System.out.println(bankAccount.getChecks().get(0).getCheckStatus());
      }
    }
  }
}
