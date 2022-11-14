package com.redis.service;

import java.util.Set;

import javax.annotation.Resource;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.stereotype.Service;

/**
 * 處理 redis 集合服務 - Set 
 * 
 * @author oscar51011
 *
 */
@Service
public class RedisSetService {

	@Resource
    private RedisTemplate<String, String> redisTemplate;
	
	private static final String SORT_KEY = "SORT";

	private void setStringSerializer(){
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        redisTemplate.setValueSerializer(new StringRedisSerializer());
    }
	
	public Long addData(String data) {
		setStringSerializer();
		return redisTemplate.opsForSet().add(SORT_KEY, data);
	}
	
	/**
	 * 隨機刪除 member
	 * @return
	 */
	public String randomPopData() {
		setStringSerializer();
		return redisTemplate.opsForSet().pop(SORT_KEY);
	}
	
	/**
	 * 檢查資料是否存在於 Set中
	 * @param data
	 * @return
	 */
	public boolean isDataExist(String data) {
		setStringSerializer();
		return redisTemplate.opsForSet().isMember(SORT_KEY, data);
	}
	
	public Set<String> getMembers() {
		setStringSerializer();
		return redisTemplate.opsForSet().members(SORT_KEY);
	}

}
