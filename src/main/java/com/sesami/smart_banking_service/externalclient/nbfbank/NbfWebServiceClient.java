package com.sesami.smart_banking_service.externalclient.nbfbank;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.sesami.smart_banking_service.accountinquiry.dto.AccountDetailsRequestRecordDTO;

@Service
public class NbfWebServiceClient {

	private static final Logger log = LoggerFactory.getLogger(NbfWebServiceClient.class);
	
	
	
	
	
	
	
	
	
	
	
	
	// add a method to fetch account details by account number
	public String fetchAccountDetailsByAccountNumber(AccountDetailsRequestRecordDTO accountDetailsRequestDto) {
		log.info("Fetching account details for account number: {}", accountDetailsRequestDto.accountNumber());
		// Logic to call the NBF web service and fetch account details
		// This is a placeholder implementation
		String responseJson = null;
		try {
			// Simulate a web service call
			// build the request JSON string	
			// Build the JSON request string using JDK 21 text blocks
	        String requestTimestamp = java.time.format.DateTimeFormatter
	                .ofPattern("yyyyMMddHHmmss")
	                .format(java.time.LocalDateTime.now());
	        
	        String isoTimestamp = java.time.OffsetDateTime.now()
	                .format(java.time.format.DateTimeFormatter.ISO_INSTANT);
	        
	        String transactionId = "22" + requestTimestamp;
	        
	        String accountInquiryRequestJsonString = """
	            {"header":{"msgFormat":"JSON",
	            "msgVersion":"1.0",
	            "requestorId":"3",
	            "requestorChannelId":"SCDM",
	            "destinationChannelId":"IDeposit",
	            "requestorUserId":"3",
	            "requestorLanguage":"EN",
	            "requestorSecurityInfo":"",
	            "createdTimeStamp":"%s",
	            "eaiReference":"%s",
	            "returnCode":""},
	            "body":{"ServiceType":"CASH_ACCOUNT",
	            "MessageType":"ENQUIRY",
	            "MsgFormat":"REQUEST",
	            "RequestorId":"3",
	            "TimeStamp":"%s",
	            "RequestorChannelId":"PP",
	            "TransactionType":"CashDeposit",
	            "TerminalID":"%s",
	            "TransactionID":"%s",
	            "CardNo":"",
	            "AccountNo":"%s",
	            "AccReqType":"CREDIT"}}
	            """.formatted(
	                isoTimestamp,
	                transactionId,
	                requestTimestamp,
	                accountDetailsRequestDto.deviceId(),
	                transactionId,
	                accountDetailsRequestDto.accountNumber()
	            );
			Thread.sleep(2000);
			
			log.info("Request JSON: {}", accountInquiryRequestJsonString);
			
			
			
			log.info("Successfully fetched account details for account number: {}", accountDetailsRequestDto.accountNumber());
			// Return the account number as a placeholder for the actual account details
			
			// Build response JSON (hardcoded, no placeholders)
			 responseJson = """
			    {"dinoPayAccountEnquiryResponse":{"header":{"msgFormat":"JSON",
			    "msgVersion":"1.0",
			    "requestorId":"3",
			    "requestorChannelId":"SCDM",
			    "destinationChannelId":"IDeposit",
			    "requestorUserId":"3",
			    "requestorLanguage":"EN",
			    "requestorSecurityInfo":"",
			    "createdTimeStamp":"2024-05-19T12:00:00Z",
			    "eaiReference":"22020240519120000",
			    "returnCode":""},
			    "body":{"ServiceType":"CASH_ACCOUNT",
			    "MessageType":"ENQUIRY",
			    "MsgFormat":"RESPONSE",
			    "RequestorId":"3",
			    "RequestorChannelId":"PP",
			    "TransactionType":"CashDeposit",
			    "TimeStamp":"20240519120000",
			    "TransactionID":"22020240519120000.0226",
			    "Customer_Reference":"",
			    "Customer_CIF":"",
			    "Consumer_No":"",
			    "AccountNo":"1234567890",
			    "TxnDescription1":"",
			    "TxnDescription2":"",
			    "ConsumerAmount":"0",
			    "AmountDue":"0",
			    "MinAmount":"0",
			    "MaxAmount":"0",
			    "Transaction_Limit_Amount":"0",
			    "CoreBanking_Payment_Reference":"",
			    "Middleware_Payment_Reference":"0226",
			    "Utility_Payment_Reference":"",
			    "ReturnCode":"A14",
			    "ReturnDescription":"Account/Card number not available.",
			    "Reserved1":"",
			    "Reserved2":"",
			    "Reserved3":"",
			    "Reserved4":"",
			    "Reserved5":"",
			    "ACCBalance":"5000.00",
			    "MobileNo":"971501234567",
			    "ReloadCard":"",
			    "CardStatus":"",
			    "Category":"",
			    "Target":"",
			    "AccountType":"Savings",
			    "Currency":"AED",
			    "MobileNumber":"971501234567",
			    "CIFType":"",
			    "SegmentType":"",
			    "EmailId":"customer@example.com",
			    "AccountTitle":"John Doe",
			    "AccReqType":"CREDIT",
			    "TerminalID":"DEVICE123",
			    "TotalNotes":"0",
			    "EnteredAmount":"0",
			    "responseStatus":{"status":"Success"}}}}
			    """;
			// Parse the response JSON to extract account details
			
			return responseJson;
		} catch (InterruptedException e) {
			log.error("Error fetching account details for account number: {}", accountDetailsRequestDto.accountNumber(), e);
		}
		return responseJson;
	}
	
	
	// add a method to fetch account details by account number and device ID
	public String sendTranactionDepoistDetails(String transactionDetails , String deviceId) {
		log.info("Fetching account details for account number: {} and device ID: {}", transactionDetails, deviceId);
		// Logic to call the NBF web service and fetch account details
		// This is a placeholder implementation
		try {
			// Simulate a web service call
			Thread.sleep(2000);
			log.info("Successfully fetched account details for account number: {} and device ID: {}", transactionDetails, deviceId);
		} catch (InterruptedException e) {
			log.error("Error fetching account details for account number: {} and device ID: {}", transactionDetails, deviceId, e);
		}
		return transactionDetails;
	}
	
	
	
	
	
}
