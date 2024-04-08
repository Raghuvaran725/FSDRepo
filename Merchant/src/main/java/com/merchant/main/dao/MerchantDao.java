package com.merchant.main.dao;

import java.util.List;
import com.merchant.main.entity.Merchant;

public interface MerchantDao {
	public List<Merchant> getMerchants();

	public Merchant getMerchant(int mid);

	public Merchant addMerchant(Merchant merchant);

	public Merchant updateMerchant(Merchant merchant);

	public boolean deleteMerchant(int mid);

	public Merchant getMerchantByEmail(String email);
}
