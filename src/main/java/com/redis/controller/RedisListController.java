package com.redis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.redis.bean.RedisStringParamBean;
import com.redis.service.RedisListService;

@RestController
@RequestMapping("/redis/list")
public class RedisListController {

	@Autowired
	private RedisListService redisListService;
	
	@PostMapping("/pushDataFromLeft")
	public String pushDataFromLeft(@RequestBody RedisStringParamBean paramBean) {
		redisListService.pushDataFromLeft(paramBean.getData());
		return "ok";
	}
	
	@PostMapping("/popDataFromLeft")
	public String popDataFromLeft() {
		String data = redisListService.popDataFromLeft();
		if(data == null) return "無資料可從left pop";
		return "取出的資料: " + data;
	}
	
	@PostMapping("/pushDataFromRight")
	public String pushDataFromRght(@RequestBody RedisStringParamBean paramBean) {
		redisListService.pushDataFromRight(paramBean.getData());
		return "ok";
	}
	
	@PostMapping("/popDataFromRight")
	public String popDataFromRight() {
		String data = redisListService.popDataFromRight();
		if(data == null) return "無資料可從right pop";
		return "取出的資料: " + data;
	}
	
	@PostMapping("/getListSize")
	public String getListSize() {
		return "LIST數量: " + redisListService.getListSize();
	}
}
