package com.ecom.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class UserAddress {
	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	private long addressID;
	private String addressType;
	private String country;
	private String state;
	private String district;
	private String city;
	private String floor;
	private String landmark;
	private String remark;
}
