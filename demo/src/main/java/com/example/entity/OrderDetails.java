package com.example.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;

@Entity
public class OrderDetails {
	@GeneratedValue
	Integer id;
	DealMaster deal;
	Integer noItemsSold;
}
