package com.sesami.smart_banking_service.accountinquiry.service;

import java.time.LocalDateTime;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sesami.smart_banking_service.accountinquiry.dto.AccountDetailsRequestRecordDTO;
import com.sesami.smart_banking_service.accountinquiry.dto.AccountDetailsResponseDTO;
import com.sesami.smart_banking_service.common.util.DateUtil;
import com.sesami.smart_banking_service.externalclient.nbfbank.NbfWebServiceClient;

@Service
public class AccountInquiryService {

	
	
	
	@Autowired
	private NbfWebServiceClient nbfWebServiceClient;
	
	
	public AccountDetailsResponseDTO fetchAccountDetailsByAccountDetailsRequestDto( AccountDetailsRequestRecordDTO accountDetailsRequestRecordDTO) {
		// Call the NBF web service client to fetch account details 
		AccountDetailsResponseDTO accountDetailsResponseDTO = new AccountDetailsResponseDTO();
		// do the null check for the request AccountDetailsRequestRecordDTO if the  bankCode is not null
		if (accountDetailsRequestRecordDTO.bankCode() == null) {
			throw new IllegalArgumentException("Bank code must not be null");
		}else {
			// Call the NBF web service client to fetch account details 
			if (accountDetailsRequestRecordDTO.bankCode().equalsIgnoreCase("NBF")) {
				// Call the NBF web service client to fetch account details 
				// nbfWebServiceClient.fetchAccountDetailsByAccountDetailsRequestDto(accountDetailsRequestRecordDTO);
				
				accountDetailsResponseDTO.setRequestUniqueNumber(accountDetailsRequestRecordDTO.deviceId()+DateUtil.dateToString("yyyyMMddHHmmss", LocalDateTime.now()));
				accountDetailsResponseDTO.setAccountNumber(accountDetailsRequestRecordDTO.accountNumber());
				accountDetailsResponseDTO.setAccountHolderName("RIM NO 959");
				accountDetailsResponseDTO.setAccountType("SAVINGS");
				accountDetailsResponseDTO.setDailyDepositLimit("250000.00");
				accountDetailsResponseDTO.setMonthtlyTransactionLimit("250000.00");
				accountDetailsResponseDTO.setYearlyTransactionLimit("250000.00");
				accountDetailsResponseDTO.setCifNumber("123456789");
				accountDetailsResponseDTO.setBankPaymentId("900001");
				accountDetailsResponseDTO.setCurrencyCode("AED");
				accountDetailsResponseDTO.setAccountStatus("Active");
				accountDetailsResponseDTO.setDepositAllowed(true);
				accountDetailsResponseDTO.setBankWebServiceCode("0");
				accountDetailsResponseDTO.setBankWebServiceDesc("Success");
				accountDetailsResponseDTO.setBankApiResponseMessage("");
				accountDetailsResponseDTO.setCdmCustomerErrorMessage("Account is valid");
				accountDetailsResponseDTO.setCdmApiCode(1);
				accountDetailsResponseDTO.setInternalWebServiceCode("200");
				accountDetailsResponseDTO.setInternalWebServiceDesc("Success");
				accountDetailsResponseDTO.setExtraField1("");
				accountDetailsResponseDTO.setExtraField2("");
				accountDetailsResponseDTO.setExtraField3("");
				accountDetailsResponseDTO.setExtraField4("");
				accountDetailsResponseDTO.setExtraField5("");
						
			}else if (accountDetailsRequestRecordDTO.bankCode().equalsIgnoreCase("CBD")) {
				// Call the CDM web service client to fetch account details 
				// nbfWebServiceClient.fetchAccountDetailsByAccountDetailsRequestDto(accountDetailsRequestRecordDTO);
			}else if (accountDetailsRequestRecordDTO.bankCode().equalsIgnoreCase("DEEM")) {
				// Call the DEEM web service client to fetch account details
				//
			}
			// nbfWebServiceClient.fetchAccountDetailsByAccountDetailsRequestDto(accountDetailsRequestRecordDTO);
			
			
		}
		

		
		
		
		
		return accountDetailsResponseDTO;
	}
	
	
}
