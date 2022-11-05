package com.redis.bean;

import lombok.Data;

@Data
public class HashFieldParamBean {
	
	/**
	 * hash key
	 */
	private String hashKey;
	
	/**
	 * hash value
	 */
	private String hashValue;
}
