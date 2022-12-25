package com.redis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.redis.bean.RedisStringParamBean;
import com.redis.service.RedisStringTypeService;

@RestController
@RequestMapping("/redis/string")
public class RedisStringController {
	
	@Autowired
	private RedisStringTypeService redisStringTypeService;
	
	@PostMapping("/setTestData")
	public String setTestData(@RequestBody RedisStringParamBean paramBean)
	{
		redisStringTypeService.setTestData(paramBean.getData());
        return "ok";
	}
	
	@PostMapping("/setTestDataIfAbsent")
	public String setTestDataIfAbsent(@RequestBody RedisStringParamBean paramBean)
	{
        return "是否有資料寫入: " + redisStringTypeService.setTestDataIfAbsent(paramBean.getData());
	}
	
	@PostMapping("/setTestDataIfPresent")
	public String setTestDataIfPresent(@RequestBody RedisStringParamBean paramBean)
	{
        return "是否有資料寫入: " + redisStringTypeService.setTestDataIfPresent(paramBean.getData());
	}
	
	@PostMapping("/deleteTestData")
	public String deleteTestData() {
		return "是否有資料被刪除: " + redisStringTypeService.deleteTestData();
	}
	
	@PostMapping("/getTestData")
	public String getTestData() {
		return redisStringTypeService.getTestData();
	}
	
}
