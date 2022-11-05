package com.redis.bean;

import java.io.Serializable;

import lombok.Data;

@Data
public class User implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 姓名
	 */
	private String name;
	/**
	 * 年紀
	 */
	private int age;
	/**
	 * 住址
	 */
	private Address address;
}
