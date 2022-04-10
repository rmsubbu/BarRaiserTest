package com.example.seller.service;

import com.example.entity.DealMaster;
import com.example.seller.model.Deal;

public interface SellerService {

	DealMaster createDeal(Deal deal);

	DealMaster updateDeal(Deal deal);

	String deleteDeal(String itemName);

}
