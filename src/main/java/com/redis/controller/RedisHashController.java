package com.redis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.redis.bean.DeleteHashParamBean;
import com.redis.bean.HashFieldParamBean;
import com.redis.bean.User;
import com.redis.service.RedisHashTypeService;

@RestController
@RequestMapping("/redis/hash")
public class RedisHashController {
	
	@Autowired
	private RedisHashTypeService redisHashTypeService;
	
	
	@PostMapping("/setHashData")
	public String setHashData() {
		redisHashTypeService.setHashData();
		return "ok";
	}
	
	@PostMapping("/getHashUserField")
	public User getHashUserField() {
		return redisHashTypeService.getHashUserField();
	}
	
	@PostMapping("/deleteHashData")
	public String deleteHashData() {
		return "是否有資料被刪除: " + redisHashTypeService.deleteHashData();
	}
	
	@PostMapping("/addHashField")
	public String addHashField(@RequestBody HashFieldParamBean paramBean) {
		redisHashTypeService.addHashField(paramBean.getHashKey(), paramBean.getHashValue());
		return "ok";
	}
	
	@PostMapping("/deleteHashField")
	public String deleteHashField(@RequestBody DeleteHashParamBean paramBean) {
		long counter = redisHashTypeService.deleteHashField(paramBean.getHashKey());
		if(counter == 1) return "資料" + paramBean.getHashKey() + "已刪除";
		return "無資料刪除";
	}

}
