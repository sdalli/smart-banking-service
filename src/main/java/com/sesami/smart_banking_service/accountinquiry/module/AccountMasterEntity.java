package com.sesami.smart_banking_service.accountinquiry.module;


import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import jakarta.persistence.*;

@Entity
@Table(name = "cc_account_master")
public class AccountMasterEntity implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = -3813069864564508571L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 50)
    private String bankCode;

    @Column(length = 50)
    private String subBankCode;

    @Column(length = 50)
    private String deviceId;

    @Column(length = 50)
    private String deviceMappedId;

    @Column(length = 50)
    private String accountNumber;

    @Column(length = 20)
    private String accountType;

    @Column(length = 50)
    private String cifNumber;

    @Column(length = 50)
    private String machineUserId;

    @Column(length = 100)
    private String customerEmailId;

    @Column(length = 20)
    private String status;

    @Column(length = 50)
    private String createdBy;

    private LocalDate createdDate;

    @Column(length = 100)
    private String deviceLocationName;

    @Column(length = 100)
    private String accountHolderName;

    @Column(length = 50)
    private String eidNumber;

    private LocalDate eidExpiryDate;

    @Column(length = 100)
    private String eidHolderName;

    private BigDecimal dailyDepositLimit;
    private BigDecimal monthlyDepositLimit;
    private BigDecimal yearlyDepositLimit;

    @Column(length = 20)
    private String tempBlockStatus;

    private String extraField1;
    private String extraField2;
    private String extraField3;
    private String extraField4;
    private String extraField5;

    // No-arg constructor
    public AccountMasterEntity() {}

    // All-arg constructor
    public AccountMasterEntity(Long id, String bankCode, String subBankCode, String deviceId, String deviceMappedId,
            String accountNumber, String accountType, String cifNumber, String machineUserId, String customerEmailId,
            String status, String createdBy, LocalDate createdDate, String deviceLocationName, String accountHolderName,
            String eidNumber, LocalDate eidExpiryDate, String eidHolderName, BigDecimal dailyDepositLimit,
            BigDecimal monthlyDepositLimit, BigDecimal yearlyDepositLimit, String tempBlockStatus, String extraField1,
            String extraField2, String extraField3, String extraField4, String extraField5) {
        this.id = id;
        this.bankCode = bankCode;
        this.subBankCode = subBankCode;
        this.deviceId = deviceId;
        this.deviceMappedId = deviceMappedId;
        this.accountNumber = accountNumber;
        this.accountType = accountType;
        this.cifNumber = cifNumber;
        this.machineUserId = machineUserId;
        this.customerEmailId = customerEmailId;
        this.status = status;
        this.createdBy = createdBy;
        this.createdDate = createdDate;
        this.deviceLocationName = deviceLocationName;
        this.accountHolderName = accountHolderName;
        this.eidNumber = eidNumber;
        this.eidExpiryDate = eidExpiryDate;
        this.eidHolderName = eidHolderName;
        this.dailyDepositLimit = dailyDepositLimit;
        this.monthlyDepositLimit = monthlyDepositLimit;
        this.yearlyDepositLimit = yearlyDepositLimit;
        this.tempBlockStatus = tempBlockStatus;
        this.extraField1 = extraField1;
        this.extraField2 = extraField2;
        this.extraField3 = extraField3;
        this.extraField4 = extraField4;
        this.extraField5 = extraField5;
    }

    // Getters and setters for all fields

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getBankCode() { return bankCode; }
    public void setBankCode(String bankCode) { this.bankCode = bankCode; }

    public String getSubBankCode() { return subBankCode; }
    public void setSubBankCode(String subBankCode) { this.subBankCode = subBankCode; }

    public String getDeviceId() { return deviceId; }
    public void setDeviceId(String deviceId) { this.deviceId = deviceId; }

    public String getDeviceMappedId() { return deviceMappedId; }
    public void setDeviceMappedId(String deviceMappedId) { this.deviceMappedId = deviceMappedId; }

    public String getAccountNumber() { return accountNumber; }
    public void setAccountNumber(String accountNumber) { this.accountNumber = accountNumber; }

    public String getAccountType() { return accountType; }
    public void setAccountType(String accountType) { this.accountType = accountType; }

    public String getCifNumber() { return cifNumber; }
    public void setCifNumber(String cifNumber) { this.cifNumber = cifNumber; }

    public String getMachineUserId() { return machineUserId; }
    public void setMachineUserId(String machineUserId) { this.machineUserId = machineUserId; }

    public String getCustomerEmailId() { return customerEmailId; }
    public void setCustomerEmailId(String customerEmailId) { this.customerEmailId = customerEmailId; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public String getCreatedBy() { return createdBy; }
    public void setCreatedBy(String createdBy) { this.createdBy = createdBy; }

    public LocalDate getCreatedDate() { return createdDate; }
    public void setCreatedDate(LocalDate createdDate) { this.createdDate = createdDate; }

    public String getDeviceLocationName() { return deviceLocationName; }
    public void setDeviceLocationName(String deviceLocationName) { this.deviceLocationName = deviceLocationName; }

    public String getAccountHolderName() { return accountHolderName; }
    public void setAccountHolderName(String accountHolderName) { this.accountHolderName = accountHolderName; }

    public String getEidNumber() { return eidNumber; }
    public void setEidNumber(String eidNumber) { this.eidNumber = eidNumber; }

    public LocalDate getEidExpiryDate() { return eidExpiryDate; }
    public void setEidExpiryDate(LocalDate eidExpiryDate) { this.eidExpiryDate = eidExpiryDate; }

    public String getEidHolderName() { return eidHolderName; }
    public void setEidHolderName(String eidHolderName) { this.eidHolderName = eidHolderName; }

    public BigDecimal getDailyDepositLimit() { return dailyDepositLimit; }
    public void setDailyDepositLimit(BigDecimal dailyDepositLimit) { this.dailyDepositLimit = dailyDepositLimit; }

    public BigDecimal getMonthlyDepositLimit() { return monthlyDepositLimit; }
    public void setMonthlyDepositLimit(BigDecimal monthlyDepositLimit) { this.monthlyDepositLimit = monthlyDepositLimit; }

    public BigDecimal getYearlyDepositLimit() { return yearlyDepositLimit; }
    public void setYearlyDepositLimit(BigDecimal yearlyDepositLimit) { this.yearlyDepositLimit = yearlyDepositLimit; }

    public String getTempBlockStatus() { return tempBlockStatus; }
    public void setTempBlockStatus(String tempBlockStatus) { this.tempBlockStatus = tempBlockStatus; }

    public String getExtraField1() { return extraField1; }
    public void setExtraField1(String extraField1) { this.extraField1 = extraField1; }

    public String getExtraField2() { return extraField2; }
    public void setExtraField2(String extraField2) { this.extraField2 = extraField2; }

    public String getExtraField3() { return extraField3; }
    public void setExtraField3(String extraField3) { this.extraField3 = extraField3; }

    public String getExtraField4() { return extraField4; }
    public void setExtraField4(String extraField4) { this.extraField4 = extraField4; }

    public String getExtraField5() { return extraField5; }
    public void setExtraField5(String extraField5) { this.extraField5 = extraField5; }

    // equals and hashCode can also be generated as needed
}
