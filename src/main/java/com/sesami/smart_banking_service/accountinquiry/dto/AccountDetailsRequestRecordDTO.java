package com.sesami.smart_banking_service.accountinquiry.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import jakarta.validation.constraints.NotNull;

/**
 * AccountDetailsRequestRecordDTO represents the request structure for account details inquiry.
 *
 * Example JSON:
 * {
 *   "accountNumber": "1111",
 *   "bankCode": "NBF",
 *   "subBankCode": "NBFBranch",
 *   "deviceId": "63",
 *   "eidDateOfBirth": "11/05/1984",
 *   "eidExpiryDate": "16/09/2024",
 *   "eidName": "RAMZI, ABDALLAH",
 *   "eidNo": "117629052",
 *   "eidType": "EIDA",
 *   "glAccountNumber": "5",
 *   "isOnlineValidationRequired": true,
 *   "extraField1": "",
 *   "extraField2": "",
 *   "extraField3": "",
 *   "extraField4": "",
 *   "extraField5": ""
 * }
 */
public record AccountDetailsRequestRecordDTO(

    @NotBlank(message = "Account number must not be blank")
    String accountNumber,

    @NotBlank(message = "Bank code must not be blank")
    String bankCode,

    String subBankCode,

    @NotBlank(message = "Device ID must not be blank")
    String deviceId,

    @NotBlank(message = "GL account number must not be blank")
    String glAccountNumber,

    @NotNull(message = "Is online validation required must not be null")
    Boolean isOnlineValidationRequired,

    String eidNo,

    String eidType,

    String eidName,

    String eidDateOfBirth,

    String eidExpiryDate,

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
) {}