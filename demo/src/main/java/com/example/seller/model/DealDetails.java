package com.example.seller.model;

import java.math.BigDecimal;

import lombok.Data;

@Data
public class DealDetails {
	private String item;
	private Integer maxNoItems;
	private BigDecimal price;
	private Long timeInSeconds;
}
