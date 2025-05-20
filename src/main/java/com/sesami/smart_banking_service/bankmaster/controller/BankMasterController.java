package com.sesami.smart_banking_service.bankmaster.controller;

import java.io.IOException;
import java.nio.file.Files;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ResourceLoader;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;

import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
@RequestMapping("/bank")
public class BankMasterController {

//	@Autowired
//	private BankService bankService;
//
//	private final ResourceLoader resourceLoader;
//
//	@Autowired
//	public BankController(ResourceLoader resourceLoader , BankService bankService) {
//		this.resourceLoader = resourceLoader;
//		this.bankService = bankService;
//	}
//
//	@GetMapping("/v1")
//	public ResponseEntity<String> getBanks() throws IOException {
//		Resource resource = resourceLoader.getResource("classpath:data/banks.json");
//		String json = new String(Files.readAllBytes(resource.getFile().toPath()));
//		return ResponseEntity.ok(json);
//	}

}

