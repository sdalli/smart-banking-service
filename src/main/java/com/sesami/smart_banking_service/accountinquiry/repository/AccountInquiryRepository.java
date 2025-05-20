package com.sesami.smart_banking_service.accountinquiry.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sesami.smart_banking_service.accountinquiry.module.AccountMasterEntity;

import java.util.Optional;

@Repository
public interface AccountInquiryRepository extends JpaRepository<AccountMasterEntity, Long> {

    Optional<AccountMasterEntity> findByAccountNumber(String accountNumber);

    Optional<AccountMasterEntity> findByBankCodeAndSubBankCodeAndDeviceId(String bankCode, String subBankCode, String deviceId);

}