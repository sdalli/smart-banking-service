package com.sesami.smart_banking_service.transactionposting.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import jakarta.validation.constraints.NotNull;
import java.util.List;

/**
 * TransactionPostingRequestRecordDTO is a data transfer object that represents the request
 * for posting a transaction. It contains various fields related to the transaction
 * and includes validation annotations to ensure that the required fields are provided.
 *
 * Example JSON:
 * {
 *   "accountHolderName": "RIM NO 959",
 *   "accountNumber": "1000068898",
 *   "accountStatus": "Active",
 *   "accountType": "CK",
 *   "bankCode": "NBF",
 *   "bankPaymentId": "",
 *   "ccTxnId": "0",
 *   "cifNumber": "",
 *   "currencyCode": "EUR",
 *   "currencyDenominationDetails": [
 *     {"count": 10, "denomination": "50", "currency": "EUR", "total": "500.00"},
 *     {"count": 20, "denomination": "20", "currency": "EUR", "total": "400.00"},
 *     {"count": 5,  "denomination": "100", "currency": "EUR", "total": "500.00"}
 *   ],
 *   "customerNarration": "6666",
 *   "dailyDepositLimit": "",
 *   "depositAmount": "20.00",
 *   "deviceId": "49",
 *   "deviceLocationName": "",
 *   "eidDateOfBirth": "11/05/1984",
 *   "eidExpiryDate": "16/09/2024",
 *   "eidName": "RAMZI,ABDALLAH,,,,,",
 *   "eidNo": "117629052",
 *   "glAccountNumber": "SCDMUAT2",
 *   "monthlyTransactionLimit": "",
 *   "nationality": "United Arab Emirates",
 *   "requestUniqueNumber": "900120240716171545",
 *   "yearlyTransactionLimit": "",
 *   "extraField1": "",
 *   "extraField2": "",
 *   "extraField3": "",
 *   "extraField4": "",
 *   "extraField5": ""
 * }
 */
public record TransactionPostingRequestRecordDTO(
    @NotBlank(message = "Request unique number must not be blank")
    String requestUniqueNumber,

    @NotBlank(message = "Account number must not be blank")
    String accountNumber,

    @NotBlank(message = "Account holder name must not be blank")
    String accountHolderName,
    @NotBlank(message = "Account Status must not be blank")
    String accountStatus,

    String accountType,

    @NotBlank(message = "Bank code must not be blank")
    String bankCode,

    String bankPaymentId,
    @NotBlank(message = "Cash control transaction ID must not be blank")
    String ccTxnId,

    String cifNumber,

    String currencyCode,

    @NotNull(message = "Currency denomination details must not be null")
    List<DenominationDetail> currencyDenominationDetails,

    String customerNarration,

    String dailyDepositLimit,

    @NotBlank(message = "Deposit amount must not be blank")
    String depositAmount,

    @NotBlank(message = "Device ID must not be blank")
    String deviceId,

    String deviceLocationName,

    String eidDateOfBirth,

    String eidExpiryDate,

    String eidName,

    @NotBlank(message = "EID No must not be blank")
    String eidNo,

    @NotBlank(message = "GL account number must not be blank")
    String glAccountNumber,

    String monthlyTransactionLimit,

    String nationality,

    String yearlyTransactionLimit,

    @Size(max = 255, message = "Extra field 1 must be less than 255 characters")
    String extraField1,

    @Size(max = 255, message = "Extra field 2 must be less than 255 characters")
    String extraField2,

    @Size(max = 255, message = "Extra field 3 must be less than 255 characters")
    String extraField3,

    @Size(max = 255, message = "Extra field 4 must be less than 255 characters")
    String extraField4,

    @Size(max = 255, message = "Extra field 5 must be less than 255 characters")
    String extraField5
) {
    /**
     * Represents a single denomination detail for deposits.
     *
     * Example:
     * {
     *   "count": 10,
     *   "denomination": "50",
     *   "currency": "EUR",
     *   "total": "500.00"
     * }
     */
    public static record DenominationDetail(
        @NotNull(message = "Count must not be null")
        Integer count,

        @NotBlank(message = "Denomination must not be blank")
        String denomination,

        @NotBlank(message = "Currency must not be blank")
        String currency,

        @NotBlank(message = "Total must not be blank")
        String total
    ) {}
}