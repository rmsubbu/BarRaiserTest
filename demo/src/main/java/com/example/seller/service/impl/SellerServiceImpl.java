package com.example.seller.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.DealMaster;
import com.example.repository.DealMasterRepo;
import com.example.seller.model.Deal;
import com.example.seller.service.SellerService;
import com.example.transformer.EntityTransformer;

@Service
public class SellerServiceImpl implements SellerService {

	@Autowired
	private EntityTransformer transformer;
	
	@Autowired
	private DealMasterRepo dealMasterRepo;
	
	@Override
	public DealMaster createDeal(Deal deal) {
		DealMaster dealMaster = transformer.createDealEntity(deal);
		DealMaster savedMaster = dealMasterRepo.save(dealMaster);
		return savedMaster;
	}

	@Override
	public DealMaster updateDeal(Deal deal) {
		Optional<DealMaster> findByItem = dealMasterRepo.findByItem(deal.getItem());
		if(findByItem.isPresent()) {
			DealMaster dealMaster = findByItem.get();
			transformer.updateDealEntity(dealMaster,deal);
			DealMaster savedMaster = dealMasterRepo.save(dealMaster);
			return savedMaster;
		}
		return null;
	}

	@Override
	public String deleteDeal(String itemName) {
		Optional<DealMaster> findByItem = dealMasterRepo.findByItem(itemName);
		if(findByItem.isPresent()) {
			DealMaster dealMaster = findByItem.get();
			dealMaster.setDealOpen(false);
			dealMasterRepo.save(dealMaster);
			return "Deal Closed Successfully";
		}
		return null;
	}
	
	
	
}
