package com.sesami.smart_banking_service.transactionposting.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sesami.smart_banking_service.transactionposting.dto.TransactionPostingRequestRecordDTO;
import com.sesami.smart_banking_service.transactionposting.dto.TransactionPostingResponseDTO;

@RestController
@RequestMapping("/smart-banking-service/api/transaction-posting")
public class TransactionPostingController {

	// add a method to handle the posting of transactions
	@PostMapping("/post-transaction")
	public ResponseEntity<TransactionPostingResponseDTO> postTransaction(
			@RequestBody TransactionPostingRequestRecordDTO transactionPostingRequestDTO) {
		// Logic to post transaction
		// TransactionPostingResponseDTO transactionPostingResponseDTO =
		// transactionPostingService.postTransaction(transactionPostingRequestDTO);

		// For now, we will just return a dummy response
		TransactionPostingResponseDTO transactionPostingResponseDTO = new TransactionPostingResponseDTO();
		transactionPostingResponseDTO.setRequestUniqueNumber(transactionPostingRequestDTO.requestUniqueNumber());
		transactionPostingResponseDTO.setDeviceId(transactionPostingRequestDTO.deviceId());
		transactionPostingResponseDTO.setBankCode(transactionPostingRequestDTO.bankCode());
		transactionPostingResponseDTO.setAccountNumber(transactionPostingRequestDTO.accountNumber());
		transactionPostingResponseDTO.setBankUniqueTransactionNumber(generateFTNumber());
		transactionPostingResponseDTO.setBankWebServiceCode("0");
		transactionPostingResponseDTO.setBankWebServiceDesc("TRANSACTION POSTED SUCCESSFULLY");
		transactionPostingResponseDTO.setBankApiResponseMessage("TRANSACTION POSTED SUCCESSFULLY");
		transactionPostingResponseDTO
				.setCdmCustomerErrorMessage("Transaction posted successfully with bank transaction ref ID: "
						+ transactionPostingResponseDTO.getBankUniqueTransactionNumber());
		transactionPostingResponseDTO.setCdmApiCode(0);
		transactionPostingResponseDTO.setInternalWebServiceCode("200");
		transactionPostingResponseDTO.setInternalWebServiceDesc("SUCCESS");
		transactionPostingResponseDTO.setExtraField1(transactionPostingRequestDTO.extraField1());

		transactionPostingResponseDTO.setExtraField2(transactionPostingRequestDTO.extraField2());
		transactionPostingResponseDTO.setExtraField3(transactionPostingRequestDTO.extraField3());
		transactionPostingResponseDTO.setExtraField4(transactionPostingRequestDTO.extraField4());
		transactionPostingResponseDTO.setExtraField5(transactionPostingRequestDTO.extraField5());


		return ResponseEntity.ok(transactionPostingResponseDTO);
	}

	private String generateFTNumber() {
		String prefix = "FT";
		String dateTime = java.time.LocalDateTime.now()
				.format(java.time.format.DateTimeFormatter.ofPattern("yyyyMMddHHmmss"));
		int randomSuffix = java.util.concurrent.ThreadLocalRandom.current().nextInt(100000, 1000000); // 6 digits
		return prefix + dateTime + randomSuffix;
	}

}
