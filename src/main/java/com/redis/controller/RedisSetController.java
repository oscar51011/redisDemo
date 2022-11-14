package com.redis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.redis.bean.RedisStringParamBean;
import com.redis.bean.SortViewBean;
import com.redis.service.RedisSetService;

@RestController
@RequestMapping("/redis/sort")
public class RedisSetController {

	@Autowired
	private RedisSetService redisSetService;
	
	@PostMapping("/addData")
	public String addData(@RequestBody RedisStringParamBean paramBean) {
		long count = redisSetService.addData(paramBean.getData());
		if(count == 0) return "無資料寫入";
		return "ok";
	}
	
	@PostMapping("/randomPopData")
	public String randomPopData() {
		redisSetService.randomPopData();
		return "ok";
	}
	
	@PostMapping("/isDataExist")
	public String isDataExist(@RequestBody RedisStringParamBean paramBean) {
		boolean isDataExist = redisSetService.isDataExist(paramBean.getData());
		return "資料" + paramBean.getData() + " 是否存在:" + isDataExist;
	}
	
	/**
	 * 取得所有 Sort 集合的資料
	 * @return
	 */
	@PostMapping("/getMembers")
	public SortViewBean getMembers() {
		SortViewBean viewBean = new SortViewBean();
		viewBean.setResults(redisSetService.getMembers());
		return viewBean;
	}
}
