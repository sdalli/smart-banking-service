package com.sesami.smart_banking_service.accountinquiry.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sesami.smart_banking_service.accountinquiry.dto.AccountDetailsRequestRecordDTO;
import com.sesami.smart_banking_service.accountinquiry.dto.AccountDetailsResponseDTO;
import com.sesami.smart_banking_service.accountinquiry.service.AccountInquiryService;

@RestController
@RequestMapping("/smart-banking-service/api")
public class AccountInquiryController {

	
	
	@Autowired
	private AccountInquiryService accountInquiryService;
	
	
	
	
	// add a method to handle the fetching of account details
	@PostMapping("/fetch-account-details")
	public ResponseEntity<AccountDetailsResponseDTO> fetchAccountDetailsByAccountDetailsRequestDto(@RequestBody AccountDetailsRequestRecordDTO accountDetailsRequestRecordDTO) {
		// Logic to fetch account details
		AccountDetailsResponseDTO  accountDetailsResponseDTO = accountInquiryService.fetchAccountDetailsByAccountDetailsRequestDto(accountDetailsRequestRecordDTO);
		 return ResponseEntity.ok(accountDetailsResponseDTO);
	}
	
	
	
	
	
}
