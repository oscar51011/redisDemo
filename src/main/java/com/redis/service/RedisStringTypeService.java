package com.redis.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.stereotype.Service;

/**
 * String Type 一般操作 redis 服務
 * 
 * @author oscar51011
 *
 */
@Service
public class RedisStringTypeService {
	
	private static final String TEST_KEY = "test";

	@Autowired
    private RedisTemplate<String, String> redisTemplate;
	
	@Autowired
    private RedisTemplate<Object, Object> redisTemplate2;
	
	private void setStringSerializer(){
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        redisTemplate.setValueSerializer(new StringRedisSerializer());
    }
	
	public String getTestData() {
		String data = redisTemplate.opsForValue().get(TEST_KEY);
		if(data == null)
			data = "資料不存在";
		return data;
	}
	
	/**
	 * 設定資料
	 * @param data
	 */
	public void setTestData(String data) {
		setStringSerializer();
		redisTemplate.opsForValue().set(TEST_KEY, data);
	}
	
	/**
	 * 刪除 Key 為 test 的資料
	 */
	public boolean deleteTestData() {
		return redisTemplate.delete(TEST_KEY);
	}
	
	/**
	 * 設定資料，如果原本的 key "不"存在，才會寫入資料
	 * 
	 * @param value
	 */
	public boolean setTestDataIfAbsent(String data) {
		setStringSerializer();
		return redisTemplate.opsForValue().setIfAbsent(TEST_KEY, data);
	}
	
	/**
	 * 設定資料，如果原本的 key "有"存在，才會寫入資料
	 * 
	 * @param value
	 */
	public boolean setTestDataIfPresent(String data) {
		setStringSerializer();
		return redisTemplate.opsForValue().setIfPresent(TEST_KEY, data);
	}
	
}
