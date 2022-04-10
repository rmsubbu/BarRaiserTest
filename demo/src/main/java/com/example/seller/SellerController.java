package com.example.seller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.entity.DealMaster;
import com.example.seller.model.Deal;
import com.example.seller.service.SellerService;

@RestController
public class SellerController {
	
	@Autowired
	private SellerService sellerService;
	
	@PostMapping("/deal")
	public ResponseEntity<DealMaster> createDeal(@RequestBody Deal deal){		
		DealMaster response = sellerService.createDeal(deal);
		return new ResponseEntity<DealMaster>(response, HttpStatus.OK);
	}
	
	@PutMapping("/deal")
	public ResponseEntity<DealMaster> updateDeal(@RequestBody Deal deal){		
		DealMaster response = sellerService.updateDeal(deal);
		return new ResponseEntity<DealMaster>(response, HttpStatus.OK);
	}
	
	@DeleteMapping("/deal")
	public ResponseEntity<String> deleteDeal(@RequestBody String itemName){		
		String response = sellerService.deleteDeal(itemName);
		return new ResponseEntity<String>(response, HttpStatus.OK);
	}
	
	
	
	
}
