package com.order.main.entity;

import java.util.Date;



import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Orders {
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
	
    private String customerName;
	
    private Date orderDate;
	
    private double totalPrice;
}
