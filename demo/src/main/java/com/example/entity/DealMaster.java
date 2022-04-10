package com.example.entity;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Entity;

import lombok.Data;

@Entity
@Data
public class DealMaster {
	private String item;
	private Integer maxNoItems;
	private BigDecimal price;
	private Date expTime;
	private boolean isDealOpen;
	
}
