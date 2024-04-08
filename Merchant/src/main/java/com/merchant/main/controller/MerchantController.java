package com.merchant.main.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.merchant.main.entity.Merchant;
import com.merchant.main.service.MerchantService;


@RestController
@RequestMapping("/merchant")
public class MerchantController {
	@Autowired
	MerchantService merchantservice;
	@GetMapping("/all")
	public ResponseEntity<List<Merchant>> getMerchants() {
		List<Merchant> merchantList = merchantservice.getMerchants();
		return new ResponseEntity<>(merchantList, HttpStatus.OK);
	}

	@GetMapping("/merchant{id}")
	public ResponseEntity<Merchant> getMerchant(@RequestParam("/mid") int mid) {
		Merchant merchant = merchantservice.getMerchant(mid);
		return new ResponseEntity<>(merchant, HttpStatus.OK);
	}

	@PostMapping("/add")
	public ResponseEntity<Merchant> addMerchant( @RequestBody Merchant merchant) {
		Merchant merch = merchantservice.addMerchant(merchant);
		return new ResponseEntity<>(merch, HttpStatus.CREATED);
	}

	@PutMapping("/update")
	public ResponseEntity<Merchant> updateMerchant(@RequestBody Merchant merchant) {
		Merchant merch = merchantservice.updateMerchant(merchant);
		return new ResponseEntity<>(merch, HttpStatus.CREATED);
	}

	@DeleteMapping("/merchant{email}")
	public ResponseEntity<Merchant>getMerchantByEmail(@RequestParam("/mailid") String email){
		Merchant customer = merchantservice.getMerchantByEmail(email);
		return new ResponseEntity<>(customer, HttpStatus.OK);
	}
}
