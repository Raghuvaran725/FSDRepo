package com.merchant.main.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.merchant.main.entity.Merchant;

public interface MerchantRepo extends JpaRepository<Merchant,Integer> {

	Merchant findByMerchantEmail(String email);

}
