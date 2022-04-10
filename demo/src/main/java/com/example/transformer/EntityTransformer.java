package com.example.transformer;

import java.util.Calendar;
import java.util.Date;

import org.springframework.stereotype.Component;

import com.example.entity.DealMaster;
import com.example.seller.model.Deal;


@Component
public class EntityTransformer {

	public DealMaster createDealEntity(Deal deal) {
		DealMaster dealMaster = new DealMaster();
		dealMaster.setItem(deal.getItem());
		dealMaster.setDealOpen(true);
		dealMaster.setMaxNoItems(deal.getMaxNoItems());
		dealMaster.setPrice(deal.getPrice());
		dealMaster.setExpTime(getExpTime(deal.getTimeInMinutes()));
		return dealMaster;
	}

	public void updateDealEntity(DealMaster dealMaster, Deal deal) {
		dealMaster.setMaxNoItems(deal.getMaxNoItems());
		dealMaster.setExpTime(getExpTime(deal.getTimeInMinutes()));
	}

	private Date getExpTime(Integer timeInMinutes) {
		Calendar instance = Calendar.getInstance();
		instance.add(Calendar.MINUTE, timeInMinutes);
		return instance.getTime();
	}

}
