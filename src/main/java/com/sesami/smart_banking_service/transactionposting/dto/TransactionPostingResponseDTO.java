package com.sesami.smart_banking_service.transactionposting.dto;

/**
 * TransactionPostingResponseDTO represents the response for transaction posting requests.
 * 
 * Example JSON:
 * {
 *   "requestUniqueNumber": "900120240716155949",
 *   "deviceId": "12345",
 *   "bankCode": "CBD",
 *   "accountNumber": "1000068898",
 *   "bankUniqueTransactionNumber": "FT40716155949",
 *   "bankWebServiceCode": "0",
 *   "bankWebServiceDesc": "TRANSACTION POSTED SUCCESSFULLY",
 *   "bankApiResponseMessage": null,
 *   "cdmCustomerErrorMessage": "Error 1",
 *   "cdmApiCode": 0,
 *   "internalWebServiceCode": "200",
 *   "internalWebServiceDesc": "SUCCESS",
 *   "extraField1": null,
 *   "extraField2": null,
 *   "extraField3": null,
 *   "extraField4": null,
 *   "extraField5": null
 * }
 */
public class TransactionPostingResponseDTO {

    private String requestUniqueNumber;
    private String deviceId;
    private String bankCode;
    private String accountNumber;
    private String bankUniqueTransactionNumber;
    private String bankWebServiceCode;
    private String bankWebServiceDesc;
    private String bankApiResponseMessage;
    private String cdmCustomerErrorMessage;
    private Integer cdmApiCode;
    private String internalWebServiceCode;
    private String internalWebServiceDesc;
    private String extraField1;
    private String extraField2;
    private String extraField3;
    private String extraField4;
    private String extraField5;

    public String getRequestUniqueNumber() {
        return requestUniqueNumber;
    }
    public void setRequestUniqueNumber(String requestUniqueNumber) {
        this.requestUniqueNumber = requestUniqueNumber;
    }
    public String getDeviceId() {
        return deviceId;
    }
    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }
    public String getBankCode() {
        return bankCode;
    }
    public void setBankCode(String bankCode) {
        this.bankCode = bankCode;
    }
    public String getAccountNumber() {
        return accountNumber;
    }
    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }
    public String getBankUniqueTransactionNumber() {
        return bankUniqueTransactionNumber;
    }
    public void setBankUniqueTransactionNumber(String bankUniqueTransactionNumber) {
        this.bankUniqueTransactionNumber = bankUniqueTransactionNumber;
    }
    public String getBankWebServiceCode() {
        return bankWebServiceCode;
    }
    public void setBankWebServiceCode(String bankWebServiceCode) {
        this.bankWebServiceCode = bankWebServiceCode;
    }
    public String getBankWebServiceDesc() {
        return bankWebServiceDesc;
    }
    public void setBankWebServiceDesc(String bankWebServiceDesc) {
        this.bankWebServiceDesc = bankWebServiceDesc;
    }
    public String getBankApiResponseMessage() {
        return bankApiResponseMessage;
    }
    public void setBankApiResponseMessage(String bankApiResponseMessage) {
        this.bankApiResponseMessage = bankApiResponseMessage;
    }
    public String getCdmCustomerErrorMessage() {
        return cdmCustomerErrorMessage;
    }
    public void setCdmCustomerErrorMessage(String cdmCustomerErrorMessage) {
        this.cdmCustomerErrorMessage = cdmCustomerErrorMessage;
    }
    public Integer getCdmApiCode() {
        return cdmApiCode;
    }
    public void setCdmApiCode(Integer cdmApiCode) {
        this.cdmApiCode = cdmApiCode;
    }
    public String getInternalWebServiceCode() {
        return internalWebServiceCode;
    }
    public void setInternalWebServiceCode(String internalWebServiceCode) {
        this.internalWebServiceCode = internalWebServiceCode;
    }
    public String getInternalWebServiceDesc() {
        return internalWebServiceDesc;
    }
    public void setInternalWebServiceDesc(String internalWebServiceDesc) {
        this.internalWebServiceDesc = internalWebServiceDesc;
    }
    public String getExtraField1() {
        return extraField1;
    }
    public void setExtraField1(String extraField1) {
        this.extraField1 = extraField1;
    }
    public String getExtraField2() {
        return extraField2;
    }
    public void setExtraField2(String extraField2) {
        this.extraField2 = extraField2;
    }
    public String getExtraField3() {
        return extraField3;
    }
    public void setExtraField3(String extraField3) {
        this.extraField3 = extraField3;
    }
    public String getExtraField4() {
        return extraField4;
    }
    public void setExtraField4(String extraField4) {
        this.extraField4 = extraField4;
    }
    public String getExtraField5() {
        return extraField5;
    }
    public void setExtraField5(String extraField5) {
        this.extraField5 = extraField5;
    }
}