package com.redis.bean;

import java.io.Serializable;

import lombok.Data;

@Data
public class Address implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 城市
	 */
	private String city;
	/**
	 * 號碼
	 */
	private int number;
}
