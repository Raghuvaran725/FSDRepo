package com.merchant.main.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.merchant.main.dao.MerchantDao;
import com.merchant.main.entity.Merchant;
import com.merchant.main.service.MerchantService;
@Service
public class MerchantServiceImpl implements MerchantService{
	@Autowired
	MerchantDao merchantdao;
	@Override
	public List<Merchant> getMerchants() {
		List<Merchant> mlist=merchantdao.getMerchants();
		return mlist;
	}

	@Override
	public Merchant getMerchant(int mid) {
		Merchant m = merchantdao.getMerchant(mid);
		return m;
	}

	@Override
	public Merchant addMerchant(Merchant merchant) {
	Merchant m =merchantdao.addMerchant(merchant);
		return m;
	}

	@Override
	public Merchant updateMerchant(Merchant merchant) {
		Merchant m = merchantdao.updateMerchant(merchant);
		return m;
	}

	@Override
	public String deleteMerchant(int mid) {
		merchantdao.deleteMerchant(mid);
		return " deleted Customer Succesfully";
		
	}

	@Override
	public Merchant getMerchantByEmail(String email) {
	Merchant m = merchantdao.getMerchantByEmail(email);
		return m;
	}

}
