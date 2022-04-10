package com.example.test.sellerServiceImplTest;

import java.math.BigDecimal;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoSettings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.DemoApplication;
import com.example.entity.DealMaster;
import com.example.repository.DealMasterRepo;
import com.example.seller.model.Deal;
import com.example.seller.service.SellerService;
import com.example.seller.service.impl.SellerServiceImpl;
import com.example.transformer.EntityTransformer;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = DemoApplication.class)
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
public class SellerServiceImplTest {
	
	
	SellerService sellerService = new SellerServiceImpl();
	
	@MockBean
	private EntityTransformer transformer;
	
	@MockBean
	private DealMasterRepo dealMasterRepo;
	
	
	
	@Test
	public void testCreateDeal() {
		Deal deal = new Deal();
		deal.setItem("laptop");
		deal.setMaxNoItems(3);
		deal.setPrice(BigDecimal.valueOf(300));
		deal.setTimeInMinutes(120);
		Mockito.when(transformer.createDealEntity(Mockito.any())).thenReturn(new DealMaster());
		Mockito.when(dealMasterRepo.save(Mockito.any())).thenReturn(new DealMaster());
		DealMaster createdDeal = sellerService.createDeal(deal);
		Assert.assertNotNull(createdDeal);
	}
}
