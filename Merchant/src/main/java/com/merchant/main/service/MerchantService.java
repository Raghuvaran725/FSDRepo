package com.merchant.main.service;

import java.util.List;

import com.merchant.main.entity.Merchant;

public interface MerchantService {
	public List<Merchant> getMerchants();

	public Merchant getMerchant(int mid);

	public Merchant addMerchant(Merchant merchant);

	public Merchant updateMerchant(Merchant merchant);

	public String deleteMerchant(int mid);

	public Merchant getMerchantByEmail(String email);
}
