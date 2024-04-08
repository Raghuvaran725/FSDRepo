package com.merchant.main.daoimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.merchant.main.dao.MerchantDao;
import com.merchant.main.entity.Merchant;
import com.merchant.main.repository.MerchantRepo;


@Repository
public class MerchantDaoImpl implements MerchantDao {
	@Autowired
	MerchantRepo merchantrepo;

	@Override
	public List<Merchant> getMerchants() {
		List<Merchant> mlist= merchantrepo.findAll();
		return mlist;
	}

	@Override
	public Merchant getMerchant(int mid) {
		Merchant merchant = merchantrepo.findById(mid).orElse(null);
		return merchant;
	}

	@Override
	public Merchant addMerchant(Merchant merchant) {
		Merchant m=merchantrepo.save(merchant);
		return m;
	}

	@Override
	public Merchant updateMerchant(Merchant merchant) {
		Merchant m=merchantrepo.save(merchant);
		return m;
	}

	@Override
	public boolean deleteMerchant(int mid) {
		Merchant merch = merchantrepo.findById(mid).orElse(null);
		if (merch != null) {
			merchantrepo.delete(merch);
			return true;
		}
		return false;
	}

	@Override
	public Merchant getMerchantByEmail(String email) {
		Merchant merchant = merchantrepo.findByMerchantEmail(email);
		return merchant;
	}
	
}
