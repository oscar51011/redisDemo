package com.redis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.redis.service.RedisStringTypeService;

@RestController
@RequestMapping("/redis/string")
public class RedisStringController {
	
	@Autowired
	private RedisStringTypeService redisStringTypeService;
	
	@RequestMapping("/setTestData")
	public String setTestData(@RequestBody String data)
	{
		redisStringTypeService.setTestData(data);
        return "ok";
	}
	
	@RequestMapping("/setTestDataIfAbsent")
	public String setTestDataIfAbsent(@RequestBody String data)
	{
        return "是否有資料寫入: " + redisStringTypeService.setTestDataIfAbsent(data);
	}
	
	@RequestMapping("/setTestDataIfPresent")
	public String setTestDataIfPresent(@RequestBody String data)
	{
        return "是否有資料寫入: " + redisStringTypeService.setTestDataIfPresent(data);
	}
	
	@RequestMapping("/deleteTestData")
	public String deleteTestData() {
		return "是否有資料被刪除: " + redisStringTypeService.deleteTestData();
	}
	
	@RequestMapping("/getTestData")
	public String getTestData() {
		return redisStringTypeService.getTestData();
	}
	
}
