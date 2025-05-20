package com.sesami.smart_banking_service.bankmaster.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Lock;

import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.persistence.LockModeType;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.annotation.PostConstruct;
import jakarta.persistence.LockModeType;
import jakarta.transaction.Transactional;

public class BankMasterService {

//
//
//    @Autowired
//    private BankRepository bankRepository;
//    
//    
//
//   // @PostConstruct
//    @Transactional
//    @Lock(LockModeType.PESSIMISTIC_WRITE)
//    public void init() throws IOException {
//        String json = new String(Files.readAllBytes(Paths.get("src/main/resources/data/banks.json")));
//        // Parse JSON and save to database (use a library like Jackson or Gson)
//        // Example: 
//      
//        List<Bank> banks = new ObjectMapper().readValue(json, new TypeReference<List<Bank>>() {});
//       bankRepository.saveAll(banks);
//    }
//    
////    public Bank saveBanksJson() throws IOException {
////        String json = new String(Files.readAllBytes(Paths.get("src/main/resources/data/banks.json")));
////        // Parse JSON and save to database (use a library like Jackson or Gson)
////        // Example: 
////        List<Bank> banks = new ObjectMapper().readValue(json, new TypeReference<List<Bank>>() {});
////        List<Bank> returnBanks =  bankRepository.saveAll(banks);
////        System.out.println(returnBanks.get(0));
////        return returnBanks.get(0);
////    }
//    
//    @Transactional
//    @Lock(LockModeType.PESSIMISTIC_WRITE)
//    public synchronized  Bank saveBanksJson() throws IOException {
//        String json = new String(Files.readAllBytes(Paths.get("src/main/resources/data/banks.json")));
//        List<Bank> banks = new ObjectMapper().readValue(json, new TypeReference<List<Bank>>() {});
//        
//        
//        List<Bank> returnBanks = bankRepository.saveAllAndFlush(banks);
//        System.out.println(returnBanks.get(0));
//        
//        
//        return returnBanks.get(0);
//    }
    
    
    

}
