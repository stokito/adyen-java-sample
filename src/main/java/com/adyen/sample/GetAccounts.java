package com.adyen.sample;

import com.adyen.Client;
import com.adyen.model.marketpay.GetAccountHolderRequest;
import com.adyen.model.marketpay.GetAccountHolderResponse;
import com.adyen.service.Account;

/*
class GetAccountHolderResponse {
    verification: KYCVerificationResult{shareholders=[], accountHolder=null, bankAccounts=[]}
    submittedAsync: false
    accountHolderCode: Dodax5-1558533009313
    requirementsForNextAccountState: []
    accountHolderDetails: class AccountHolderDetails {
        metadata: {}
        address: null
        phoneNumber: null
        bankAccountDetails: []
        individualDetails: null
        webAddress: null
        merchantCategoryCode: 7999
        fullPhoneNumber: null
        businessDetails: class BusinessDetails {
            shareholders: []
            doingBusinessAs: companyName
            taxId: null
            legalBusinessName: companyName
            registrationNumber: companyRegistrationNumber
        }
        email: null@example.com
    }
    accountHolderStatus: class AccountHolderStatus {
        processingState: class AccountProcessingState {
            disableReason: null
            processedTo: class Amount {
                value: 0
                currency: EUR
            }
            processedFrom: class Amount {
                value: 0
                currency: EUR
            }
            tierNumber: 0
            disabled: false
        }
        statusReason: null
        payoutState: class AccountPayoutState {
            disableReason: null
            allowPayout: true
            tierNumber: 0
            disabled: false
            payoutLimit: class Amount {
                value: 0
                currency: EUR
            }
        }
        status: Active
        accountEvents: []
    }
    accounts: [class Account {
        accountCode: 145389541
        beneficiaryAccount: null
        beneficiaryMerchantReference: null
        description: MICGZQIK
        payoutSchedule: class PayoutScheduleResponse {
            schedule: HOLD
            nextScheduledPayout: null
        }
        status: Active
    }]
    description: null
    pspReference: 8515619128234340
    legalEntity: Business
    primaryCurrency: null
}
 */
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
