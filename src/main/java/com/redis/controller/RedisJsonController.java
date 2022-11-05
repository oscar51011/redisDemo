package com.redis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.redis.bean.DeleteHashParamBean;
import com.redis.bean.HashFieldParamBean;
import com.redis.bean.User;
import com.redis.service.RedisJsonTypeService;

@RestController
@RequestMapping("/redis/json")
public class RedisJsonController {
	
	@Autowired
	private RedisJsonTypeService redisJsonTypeService;
	
	
	@PostMapping("/setUserJsonData")
	public String setUserJsonData() {
		redisJsonTypeService.setUserJsonData();
		return "ok";
	}
	
	@PostMapping("/getUserJsonData")
	public User getUserJsonData() {
		return redisJsonTypeService.getUserJsonData();
	}
	
}
