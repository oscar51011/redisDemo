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

	private static final String LIST_KEY = "LIST";
	
	@Resource
    private RedisTemplate<String, String> redisTemplate;
	
	private void setStringSerializer(){
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        redisTemplate.setValueSerializer(new StringRedisSerializer());
    }
	
	public void pushDataFromLeft(String data) {
		setStringSerializer();
		redisTemplate.opsForList().leftPush(LIST_KEY, data);
	}
	
	public String popDataFromLeft() {
		setStringSerializer();
		return redisTemplate.opsForList().leftPop(LIST_KEY);
	}
	
	public void pushDataFromRight(String data) {
		setStringSerializer();
		redisTemplate.opsForList().rightPush(LIST_KEY, data);
	}
	
	public String popDataFromRight() {
		setStringSerializer();
		return redisTemplate.opsForList().rightPop(LIST_KEY);
	}
	
	public long getListSize() {
		return redisTemplate.opsForList().size(LIST_KEY);
	}
}
