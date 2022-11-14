package com.redis.service;

import javax.annotation.Resource;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.stereotype.Service;


/**
 * 處理 redis 集合服務 - List 
 * 
 * @author oscar51011
 *
 */
@Service
public class RedisListService {

	private static final String JSON_KEY = "LIST";
	
	@Resource
    private RedisTemplate<String, String> redisTemplate;
	
	private void setStringSerializer(){
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        redisTemplate.setValueSerializer(new StringRedisSerializer());
    }
	
	public void pushDataFromLeft(String data) {
		setStringSerializer();
		Long count = redisTemplate.opsForList().leftPush(JSON_KEY, data);
		System.out.println("寫入筆數:" + count );
	}
	
	public String popDataFromLeft() {
		setStringSerializer();
		return redisTemplate.opsForList().leftPop(JSON_KEY);
	}
	
	public void pushDataFromRight(String data) {
		setStringSerializer();
		redisTemplate.opsForList().rightPush(JSON_KEY, data);
	}
	
	public String popDataFromRight() {
		setStringSerializer();
		return redisTemplate.opsForList().rightPop(JSON_KEY);
	}
	
	public long getListSize() {
		return redisTemplate.opsForList().size(JSON_KEY);
	}
}
